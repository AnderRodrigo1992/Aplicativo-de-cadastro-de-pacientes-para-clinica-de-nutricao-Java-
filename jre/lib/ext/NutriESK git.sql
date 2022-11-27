-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`agenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`agenda` (
  `idAgenda` INT NOT NULL AUTO_INCREMENT,
  `Paciente` VARCHAR(45) NULL DEFAULT NULL,
  `Nutricionista` VARCHAR(45) NULL DEFAULT NULL,
  `Dia` VARCHAR(45) NULL DEFAULT NULL,
  `hora` VARCHAR(45) NULL DEFAULT NULL,
  `notas` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idAgenda`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`paciente` (
  `idPaciente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `uf` VARCHAR(45) NOT NULL,
  `endereço` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`idPaciente`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`medidas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`medidas` (
  `idMedidas` INT NOT NULL AUTO_INCREMENT,
  `DataDaMedição` VARCHAR(45) NULL DEFAULT NULL,
  `altura` DECIMAL(5,2) NULL DEFAULT NULL,
  `peso` DECIMAL(5,2) NULL DEFAULT NULL,
  `peitoral` DECIMAL(5,2) NULL DEFAULT NULL,
  `quadril` DECIMAL(5,2) NULL DEFAULT NULL,
  `barriga` DECIMAL(5,2) NULL DEFAULT NULL,
  `bracoDir` DECIMAL(5,2) NULL DEFAULT NULL,
  `bracoEsq` DECIMAL(5,2) NULL DEFAULT NULL,
  `coxaDir` DECIMAL(5,2) NULL DEFAULT NULL,
  `coxaEsq` DECIMAL(5,2) NULL DEFAULT NULL,
  `panturrilhaDir` DECIMAL(5,2) NULL DEFAULT NULL,
  `panturrilhaEsq` DECIMAL(5,2) NULL DEFAULT NULL,
  `Paciente_idPaciente` INT NOT NULL,
  `atividade` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idMedidas`),
  INDEX `Paciente_idPaciente` (`Paciente_idPaciente` ASC) VISIBLE,
  CONSTRAINT `medidas_ibfk_1`
    FOREIGN KEY (`Paciente_idPaciente`)
    REFERENCES `mydb`.`paciente` (`idPaciente`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`nutricionista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`nutricionista` (
  `idNutricionista` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `uf` VARCHAR(45) NOT NULL,
  `endereço` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `Login` VARCHAR(45) NOT NULL,
  `Senha` VARCHAR(45) NOT NULL,
  `Perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idNutricionista`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idUsuario` INT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `Senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
