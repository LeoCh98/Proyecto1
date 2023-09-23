-- MySQL Script generated by MySQL Workbench
-- Wed Sep  6 164220 2023
-- Model New Model    Version 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd_grupos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bd_grupos` ;

-- -----------------------------------------------------
-- Schema bd_grupos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_grupos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci ;
USE `bd_grupos` ;

-- -----------------------------------------------------
-- Table `bd_grupos`.`grupo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_grupos`.`grupo` ;

CREATE TABLE IF NOT EXISTS `bd_grupos`.`grupo` (
  `id` INT(6) NOT NULL AUTO_INCREMENT,
  `secuencia` INT(6) NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `cupo` INT(2) NOT NULL DEFAULT 5,
  `activo` BIT(1) NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `secuencia_UNIQUE` (`secuencia` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_grupos`.`estudiante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_grupos`.`estudiante` ;

CREATE TABLE IF NOT EXISTS `bd_grupos`.`estudiante` (
  `id` VARCHAR(15) NOT NULL,
  `nrc` INT(6) NOT NULL,
  `apellidos` VARCHAR(60) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `secuencia` INT(6) NOT NULL,
  `clave` VARCHAR(20) NOT NULL,
  `ultimo_acceso` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `grupo_id` INT(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_estudiante_grupo_idx` (`grupo_id` ASC) VISIBLE,
  CONSTRAINT `fk_estudiante_grupo`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `bd_grupos`.`grupo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `bd_grupos` ;

-- -----------------------------------------------------
-- Placeholder table for view `bd_grupos`.`general_estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_grupos`.`general_estudiante` (`nrc` INT, `secuencia` INT, `id` INT, `apellidos` INT, `nombre` INT, `ultimo_acceso` INT, `grupo_id` INT);

-- -----------------------------------------------------
-- View `bd_grupos`.`general_estudiante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_grupos`.`general_estudiante`;
DROP VIEW IF EXISTS `bd_grupos`.`general_estudiante` ;
USE `bd_grupos`;
CREATE  OR REPLACE VIEW `general_estudiante` AS 
	SELECT  `nrc`, `secuencia`, `id`, `apellidos`, `nombre`, `ultimo_acceso`, `grupo_id`
    FROM estudiante
    ORDER BY `nrc`, `secuencia`
    ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


TRUNCATE `bd_grupos`.`estudiante`;
-- TRUNCATE `bd_grupos`.`grupo`;

INSERT INTO `bd_grupos`.`estudiante`
	(`id`, `nrc`, `apellidos`, `nombre`, `secuencia`, `clave`)
	VALUES
	('118150438', '53326', 'Barquero Torres', 'Jeffry Alexander', '1', '118150438'),
	('118610371', '53326', 'Calderón Navarro', 'Isaac José', '2', '118610371'),
	('208110230', '53326', 'Campos Artavia', 'Luis Elías', '3', '208110230'),
	('117410706', '53326', 'Cárdenas Sandoval', 'Aslie Dayan', '4', '117410706'),
	('118240782', '53326', 'Castillo Badilla', 'Brandon Natanael', '5', '118240782'),
	('117210130', '53326', 'Castillo Vives', 'Jean Paul', '6', '117210130'),
	('402480221', '53326', 'Chanto Chavarría', 'Cristopher Alonso', '7', '402480221'),
	('117780366', '53326', 'Chavarría Venegas', 'Ariadna Natalia', '8', '117780366'),
	('402390410', '53326', 'Chaves Hernández', 'Leonardo Jesús', '9', '402390410'),
	('116960599', '53326', 'Chinchilla Alvarado', 'Daniel Alfonso', '10', '116960599'),
	('402410236', '53326', 'Cortés Quiñones', 'Adrián Alejandro', '11', '402410236'),
	('118430731', '53326', 'Durán Campos', 'Jorge Andrés', '12', '118430731'),
	('112340621', '53326', 'Granados Rodríguez', 'Paul ', '13', '112340621'),
	('208020417', '53326', 'Lobo Vásquez', 'Jennifer María', '14', '208020417'),
	('117530126', '53326', 'Madrigal Morales', 'Daniela Sofía', '15', '117530126'),
	('402480505', '53326', 'Mejías Garita', 'Diana María', '16', '402480505'),
	('504450002', '53326', 'Mejías Salazar', 'Jennifer ', '17', '504450002'),
	('402260566', '53326', 'Méndez Agüero', 'Johan Antonio', '18', '402260566'),
	('702750378', '53326', 'Mendoza Arroyo', 'Jordy Magdiel', '19', '702750378'),
	('118000270', '53326', 'Montes De Oca Ruiz', 'Luis Antonio', '20', '118000270'),
	('118290260', '53326', 'Morales González', 'Andre Fabricio', '21', '118290260'),
	('801030118', '53326', 'Orellana Rivas', 'Eduardo Esteban', '22', '801030118'),
	('118900308', '53326', 'Piñar Baltodano', 'Joseph Jassdany', '23', '118900308'),
	('A00148155', '53326', 'Quintana Hernández', 'Joseph Franchesco', '24', 'A00148155'),
	('402470836', '53326', 'Quirós Rodríguez', 'Sebastián ', '25', '402470836'),
	('402450657', '53326', 'Ramírez Calderón', 'Gilberto Alexander', '26', '402450657'),
	('402460155', '53326', 'Tencio Paniagua', 'Kendall ', '27', '402460155'),
	('208310449', '53326', 'Valverde Solís', 'José Luis', '28', '208310449'),
	('402610333', '53326', 'Vargas Camacho', 'Gerick Joel', '29', '402610333'),
	('208200529', '53326', 'Vargas Ramírez', 'José Andrés', '30', '208200529')
	;
    
    select * from general_estudiante;