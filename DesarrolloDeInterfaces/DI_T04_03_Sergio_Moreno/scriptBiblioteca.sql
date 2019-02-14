CREATE SCHEMA `biblioteca` ;

CREATE TABLE `biblioteca`.`libro` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `autor` VARCHAR(45) NULL,
  `editorial` VARCHAR(45) NULL,
  `numPag` INT NULL,
  PRIMARY KEY (`codigo`));
