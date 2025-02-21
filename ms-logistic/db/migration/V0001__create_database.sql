CREATE TABLE `ms_logistic`.`logistic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `postcode` VARCHAR(150) NOT NULL,
  `number` INT NOT NULL,
  `order_id` INT NOT NULL,
  `status` VARCHAR(150) NOT NULL,
  `delivery` VARCHAR(150) NULL,
  `created_at` DATETIME(6) NOT NULL,
  `estimated_date` DATETIME(6) NOT NULL,
  `delivery_date` DATETIME(6) NULL,
  PRIMARY KEY (`id`)
);
