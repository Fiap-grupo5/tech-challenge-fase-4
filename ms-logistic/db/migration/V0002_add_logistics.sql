INSERT INTO `ms_logistic`.`logistic` (`postcode`, `number`, `order_id`, `status`, `delivery`, `estimated_date`, `delivery_date`) 
VALUES
('01001-000', 100, 1, 'PENDING', 'Entregador 1', '2025-02-22 10:00:00.000000', NULL),
('02002-000', 200, 2, 'IN_TRANSIT', 'Entregador 2', '2025-02-23 12:00:00.000000', NULL),
('03003-000', 300, 3, 'DELIVERED', 'Entregador 3', '2025-02-20 15:00:00.000000', '2025-02-20 14:30:00.000000'),
('04004-000', 400, 4, 'CANCELED', 'Entregador 4', '2025-02-25 18:00:00.000000', NULL);
