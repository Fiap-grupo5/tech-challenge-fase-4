package com.fiap.g5.mslogistic.controller;

import com.fiap.g5.mslogistic.controller.json.LogisticJson;
import com.fiap.g5.mslogistic.domain.Logistic;
import com.fiap.g5.mslogistic.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logistics")
@RequiredArgsConstructor
public class LogisticController {

    private final FindAllLogisticsUseCase findAllLogisticsUseCase;
    private final FindLogisticByIdUseCase findLogisticByIdUseCase;
    private final CreateLogisticUseCase createLogisticUseCase;
    private final UpdateLogisticUseCase updateLogisticUseCase;
    private final DeleteLogisticUseCase deleteLogisticUseCase;

    @GetMapping
    public List<LogisticJson> listAll() {
        return findAllLogisticsUseCase.execute()
                .stream()
                .map(LogisticJson::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogisticJson> getById(@PathVariable Long id) {
        Logistic logistic = findLogisticByIdUseCase.execute(id);
        return ResponseEntity.ok(new LogisticJson(logistic));
    }

    @PostMapping
    public ResponseEntity<LogisticJson> create(@RequestBody Logistic logistic) {
        Logistic created = createLogisticUseCase.execute(logistic);
        return ResponseEntity.ok(new LogisticJson(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogisticJson> update(
            @PathVariable Long id,
            @RequestBody Logistic logistic
    ) {
        Logistic updated = updateLogisticUseCase.execute(id, logistic);
        return ResponseEntity.ok(new LogisticJson(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteLogisticUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
