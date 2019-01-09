-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema diginamicproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema diginamicproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `diginamicproject` DEFAULT CHARACTER SET utf8 ;
USE `diginamicproject` ;

-- -----------------------------------------------------
-- Table `diginamicproject`.`absencetype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`absencetype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(105) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `diginamicproject`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(105) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `diginamicproject`.`departement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`departement` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `diginamicproject`.`function`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`function` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `diginamicproject`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `firstname` VARCHAR(100) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `nbrDaysOfLeave` INT(11) NULL DEFAULT NULL,
  `nbrRTT` INT(11) NULL DEFAULT NULL,
  `idDepartement` INT(11) NULL DEFAULT NULL,
  `idFunction` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `idDepartement_idx` (`idDepartement` ASC),
  INDEX `idFunction_idx` (`idFunction` ASC),
  CONSTRAINT `idDepartement`
    FOREIGN KEY (`idDepartement`)
    REFERENCES `diginamicproject`.`departement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idFunction`
    FOREIGN KEY (`idFunction`)
    REFERENCES `diginamicproject`.`function` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `diginamicproject`.`absence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`absence` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `reason` VARCHAR(100) NULL DEFAULT NULL,
  `idAbsenceType` INT(11) NOT NULL,
  `idStatus` INT(11) NOT NULL,
  `idUser` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idAbsenceType_idx` (`idAbsenceType` ASC),
  INDEX `idStatus_idx` (`idStatus` ASC),
  INDEX `idUser` (`idUser` ASC),
  CONSTRAINT `idAbsenceType`
    FOREIGN KEY (`idAbsenceType`)
    REFERENCES `diginamicproject`.`absencetype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idStatus`
    FOREIGN KEY (`idStatus`)
    REFERENCES `diginamicproject`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idUser`
    FOREIGN KEY (`idUser`)
    REFERENCES `diginamicproject`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `diginamicproject`.`typedayoff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`typedayoff` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `diginamicproject`.`dayoff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`dayoff` (
  `id` INT(11) NOT NULL,
  `idTypeDayOff` INT(11) NOT NULL,
  `date` DATE NOT NULL,
  `comment` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `idTypeDayoff_idx` (`idTypeDayOff` ASC),
  INDEX `idTypeDayoff` (`idTypeDayOff` ASC),
  INDEX `idTypeDay_off` (`idTypeDayOff` ASC),
  INDEX `idTypeDayof` (`idTypeDayOff` ASC),
  CONSTRAINT `Fk_idtypedayoff`
    FOREIGN KEY (`idTypeDayOff`)
    REFERENCES `diginamicproject`.`typedayoff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `diginamicproject`.`departement_dayoff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `diginamicproject`.`departement_dayoff` (
  `departement_id` INT(11) NOT NULL,
  `dayoff_id` INT(11) NOT NULL,
  PRIMARY KEY (`departement_id`, `dayoff_id`),
  INDEX `fk_departement_has_dayoff_dayoff1_idx` (`dayoff_id` ASC),
  INDEX `fk_departement_has_dayoff_departement1_idx` (`departement_id` ASC),
  CONSTRAINT `fk_departement_has_dayoff_departement1`
    FOREIGN KEY (`departement_id`)
    REFERENCES `diginamicproject`.`departement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_departement_has_dayoff_dayoff1`
    FOREIGN KEY (`dayoff_id`)
    REFERENCES `diginamicproject`.`dayoff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
