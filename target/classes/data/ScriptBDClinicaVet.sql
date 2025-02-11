-- MySQL Script generated by MySQL Workbench
-- Wed Aug 14 15:19:49 2024
-- Model: New Model    Version: 1.0
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
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Pet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pet` (
  `idPet` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `especie` VARCHAR(45) NOT NULL,
  `raca` VARCHAR(45) NOT NULL,
  `peso` DECIMAL(2,1) NOT NULL,
  `idade` INT NOT NULL,
  `vacinas` VARCHAR(300) NOT NULL,
  `tutor` INT NOT NULL,
  PRIMARY KEY (`idPet`),
  INDEX `idtutor_idx` (`tutor` ASC) VISIBLE,
  CONSTRAINT `idtutor`
    FOREIGN KEY (`tutor`)
    REFERENCES `mydb`.`Tutor` (`idTutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tutor` (
  `idTutor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `data_nasc` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `pet` INT NOT NULL,
  PRIMARY KEY (`idTutor`),
  INDEX `fkreferenciapet_idx` (`pet` ASC) VISIBLE,
  CONSTRAINT `fkreferenciapet`
    FOREIGN KEY (`pet`)
    REFERENCES `mydb`.`Pet` (`idPet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `quantidade` VARCHAR(45) NOT NULL,
  `valor_unitario` DECIMAL(5,1) NOT NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cep` INT NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `funcao` VARCHAR(45) NOT NULL,
  `especialidade` VARCHAR(45) NULL,
  `crm` VARCHAR(45) NULL,
  `contato` VARCHAR(45) NOT NULL,
  `endereco` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  INDEX `fkendereco_idx` (`endereco` ASC) VISIBLE,
  CONSTRAINT `fkendereco`
    FOREIGN KEY (`endereco`)
    REFERENCES `mydb`.`Endereco` (`cep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
