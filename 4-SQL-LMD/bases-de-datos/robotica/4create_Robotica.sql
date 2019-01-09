SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS `Robotica`
  CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `Robotica`;

DROP TABLE IF EXISTS `Robotica`.`Departamentos`;
CREATE TABLE `Robotica`.`Departamentos` (
  `nombred` VARCHAR(50) NULL,
  `numd` INT(10) NOT NULL,
  `dnigte` INT(10) NULL,
  `inicgte` DATETIME NULL,
  PRIMARY KEY (`numd`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `Robotica`.`Dependientes`;
CREATE TABLE `Robotica`.`Dependientes` (
  `dniempl` INT(10) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `sexo` VARCHAR(1) NULL,
  `fechanac` DATETIME NULL,
  `parentesco` VARCHAR(50) NULL,
  PRIMARY KEY (`dniempl`,`nombre`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `Robotica`.`Empleados`;
CREATE TABLE `Robotica`.`Empleados` (
  `dni` INT(10) NOT NULL,
  `nombre` VARCHAR(50) NULL,
  `tratamiento` VARCHAR(5) NULL,
  `apellidos` VARCHAR(50) NULL,
  `fechanac` DATETIME NULL,
  `direccion` VARCHAR(50) NULL,
  `sexo` VARCHAR(1) NULL,
  `salario` INT(10) NULL,
  `dnisuper` INT(10) NULL,
  `numd` INT(10) NULL,
  PRIMARY KEY (`dni`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `Robotica`.`Lugares_dptos`;
CREATE TABLE `Robotica`.`Lugares_dptos` (
  `numd` INT(10) NOT NULL,
  `lugar` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`numd`, `lugar`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `Robotica`.`Proyectos`;
CREATE TABLE `Robotica`.`Proyectos` (
  `nombrep` VARCHAR(50) NULL,
  `nump` INT(10) NOT NULL,
  `lugarp` VARCHAR(50) NULL,
  `numd` INT(10) NULL,
  PRIMARY KEY (`nump`)
)
ENGINE = INNODB;

DROP TABLE IF EXISTS `Robotica`.`Trabaja_en`;
CREATE TABLE `Robotica`.`Trabaja_en` (
  `dni` INT(10) NOT NULL,
  `nump` INT(10) NOT NULL,
  `horas` DOUBLE(7, 2) NULL,
  PRIMARY KEY (`dni`, `nump`)
)
ENGINE = INNODB;



SET FOREIGN_KEY_CHECKS = 1;
