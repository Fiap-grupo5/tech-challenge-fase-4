package com.fiap.g5.mslogistic.logistic.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fiap.g5.mslogistic.logistic.domain.CreateRoute;
import com.fiap.g5.mslogistic.logistic.domain.CreateRouteItem;
import com.fiap.g5.mslogistic.logistic.domain.Delivery;
import com.fiap.g5.mslogistic.logistic.domain.Logistic;
import com.fiap.g5.mslogistic.logistic.domain.LogisticOrder;
import com.fiap.g5.mslogistic.logistic.gateway.LogisticGateway;
import com.fiap.g5.mslogistic.logistic.gateway.RouteGateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class DailyTask {
    private RouteGateway routeGateway;
    private LogisticGateway logisticGateway;

    @Scheduled(cron = "0 0 3 * * ?") // Executa às 03:00 AM todos os dias
    public void executeDailyTask() {
        List<Logistic> logistics = logisticGateway.findTaskPayload();
        int totalLogistics = logistics.size();
        
        if (totalLogistics == 0) {
            log.info("No logistics to process");
            return;
        }

        int deleveryIndex = 0;
        int maxDeviveries = Delivery.values().length;

        ArrayList<LogisticOrder> logisticOrders = new ArrayList<>();

        // distribui as entregas entre os entregadores
        for (Logistic logistic : logistics) {
            Delivery delivery = Delivery.values()[deleveryIndex];
            Logistic logisticUpdated = logisticGateway.updateDelivery(logistic.getId(), delivery.getValue());
            logisticOrders.add(new LogisticOrder(logisticUpdated, delivery));
            deleveryIndex = (deleveryIndex + 1) % maxDeviveries;
        }

        for (Delivery delivery : Delivery.values()) {
            List<LogisticOrder> logisticsByDelivery = logisticOrders.stream()
                .filter(logisticOrder -> logisticOrder.getDelivery().getValue().equals(delivery.getValue()))
                .toList();
            List<CreateRouteItem> createRouteItems = new ArrayList<CreateRouteItem>();
            int position = 1;
            for (LogisticOrder logisticOrder : logisticsByDelivery) {
                Logistic currentLogistic = logisticOrder.getLogistic();
                if (currentLogistic.getPostcode() == null) {
                    log.warn("Skipping logistic ID {} due to null postcode", currentLogistic.toString());
                    continue;
                }
                createRouteItems.add(new CreateRouteItem(currentLogistic.getPostcode(), currentLogistic.getNumber(), position, currentLogistic.getId()));
                position++;
            }
            routeGateway.create(new CreateRoute(delivery.getValue(), createRouteItems));
        }
    }
}
