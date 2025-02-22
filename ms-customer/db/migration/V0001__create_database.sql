CREATE TABLE `ms_customer`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `phone` VARCHAR(150) NOT NULL,
  `postcode` VARCHAR(150) NOT NULL,
  `number` INT NOT NULL,
  PRIMARY KEY (`id`));