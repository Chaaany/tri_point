-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema triple
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema triple
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `triple` DEFAULT CHARACTER SET utf8 ;
USE `triple` ;

-- -----------------------------------------------------
-- Table `triple`.`attachedphoto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triple`.`attachedphoto` (
  `attachedPhotoId` BINARY(16) NOT NULL,
  `attachedActivityType` INT NOT NULL,
  `attachedActivityId` BINARY(16) NOT NULL,
  `uploadUserId` BINARY(16) NOT NULL,
  `uploadedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` TINYINT(1) NOT NULL DEFAULT '0',
  `deletedDate` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`attachedPhotoId`),
  INDEX `idx_attachedphoto_attachedActivityId` (`attachedActivityId` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `triple`.`place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triple`.`place` (
  `placeId` BINARY(16) NOT NULL,
  `uploadUserId` BINARY(16) NULL DEFAULT NULL,
  `uploadedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isdeleted` TINYINT(1) NOT NULL DEFAULT '0',
  `deletedDate` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`placeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `triple`.`point`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triple`.`point` (
  `pointId` BIGINT NOT NULL AUTO_INCREMENT,
  `userId` BINARY(16) NOT NULL,
  `activityType` INT NOT NULL,
  `activityId` BINARY(16) NOT NULL,
  `pointScore` INT NOT NULL,
  `pointType` INT NULL DEFAULT NULL,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pointId`),
  INDEX `idx_point_userId_activityId` (`userId` ASC, `activityId` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 115
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `triple`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triple`.`review` (
  `reviewId` BINARY(16) NOT NULL,
  `placeId` BINARY(16) NOT NULL,
  `userId` BINARY(16) NOT NULL,
  `content` LONGTEXT NULL DEFAULT NULL,
  `isDeleted` TINYINT(1) NOT NULL DEFAULT '0',
  `uploadedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `deletedDate` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  INDEX `idx_review_placeId_userId` (`placeId` ASC, `userId` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `triple`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triple`.`user` (
  `userId` BINARY(16) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `registrationDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nicknameModifiedDate` TIMESTAMP NULL DEFAULT NULL,
  `isUnsigned` TINYINT(1) NOT NULL DEFAULT '0',
  `unsignedDate` TIMESTAMP NULL DEFAULT NULL,
  `isRecommendated` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
