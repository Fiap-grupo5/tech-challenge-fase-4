CREATE TABLE `ms_order`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `postcode` VARCHAR(150) NOT NULL,
  `number` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `status` VARCHAR(150) NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`)
);
