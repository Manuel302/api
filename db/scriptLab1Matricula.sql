-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema matricula
-- -----------------------------------------------------
-- :)
--

-- -----------------------------------------------------
-- Schema matricula
--
-- :)
--
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `matricula` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `matricula` ;

-- -----------------------------------------------------
-- Table `matricula`.`carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `matricula`.`carrera` (
                                                     `idcarrera` INT NOT NULL,
                                                     `nombre` VARCHAR(45) NOT NULL,
                                                     `titulo` VARCHAR(45) NOT NULL,
                                                     PRIMARY KEY (`idcarrera`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matricula`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `matricula`.`curso` (
                                                   `idcurso` INT NOT NULL,
                                                   `nombrecurso` VARCHAR(45) NOT NULL,
                                                   `creditos` INT NOT NULL,
                                                   `horas_semanales` INT NOT NULL,
                                                   `carrera_idcarrera` INT NOT NULL,
                                                   `anio_deseado` INT NOT NULL,
                                                   `ciclo_deseado` VARCHAR(45) NOT NULL,
                                                   PRIMARY KEY (`idcurso`),
                                                   INDEX `fk_curso_carrera1_idx` (`carrera_idcarrera` ASC) VISIBLE,
                                                   CONSTRAINT `fk_curso_carrera1`
                                                       FOREIGN KEY (`carrera_idcarrera`)
                                                           REFERENCES `matricula`.`carrera` (`idcarrera`)
                                                           ON DELETE NO ACTION
                                                           ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `matricula`.`estudiantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `matricula`.`estudiantes` (
                                                         `idestudiante` INT NOT NULL,
                                                         `password_est` VARCHAR(45) NOT NULL,
                                                         `correo_estudiante` VARCHAR(45) NOT NULL,
                                                         `nombre` VARCHAR(45) NOT NULL,
                                                         `telefono_est` VARCHAR(45) NOT NULL,
                                                         `carrera_idcarrera` INT NOT NULL,
                                                         `fecha_nacimiento` DATE NOT NULL,
                                                         `rol_estudiante` INT NOT NULL,
                                                         PRIMARY KEY (`idestudiante`),
                                                         INDEX `fk_estudiantes_carrera1_idx` (`carrera_idcarrera` ASC) VISIBLE,
                                                         CONSTRAINT `fk_estudiantes_carrera1`
                                                             FOREIGN KEY (`carrera_idcarrera`)
                                                                 REFERENCES `matricula`.`carrera` (`idcarrera`)
                                                                 ON DELETE NO ACTION
                                                                 ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `matricula`.`profesores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `matricula`.`profesores` (
                                                        `idprofesores` INT NOT NULL,
                                                        `nombre_profe` VARCHAR(45) NOT NULL,
                                                        `email_profe` VARCHAR(45) NOT NULL,
                                                        `telefono_profe` VARCHAR(45) NOT NULL,
                                                        `password_profe` VARCHAR(45) NOT NULL,
                                                        `rol_profe` INT NOT NULL,
                                                        PRIMARY KEY (`idprofesores`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `matricula`.`ciclo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `matricula`.`ciclo` (
                                                   `idciclo` INT NOT NULL,
                                                   `anio` INT NOT NULL,
                                                   `numero` INT NOT NULL,
                                                   `fecha_inicio` DATE NOT NULL,
                                                   `fecha_fin` DATE NOT NULL,
                                                   PRIMARY KEY (`idciclo`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `matricula`.`grupos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `matricula`.`grupos` (
                                                    `idgrupos` INT NOT NULL AUTO_INCREMENT,
                                                    `id_profe` INT NOT NULL,
                                                    `horario` VARCHAR(45) NOT NULL,
                                                    `ciclo_idciclo` INT NOT NULL,
                                                    `curso_idcurso` INT NOT NULL,
                                                    PRIMARY KEY (`idgrupos`),
                                                    INDEX `fk_id_profe_idx` (`id_profe` ASC) VISIBLE,
                                                    INDEX `fk_grupos_ciclo1_idx` (`ciclo_idciclo` ASC) VISIBLE,
                                                    INDEX `fk_grupos_curso1_idx` (`curso_idcurso` ASC) VISIBLE,
                                                    CONSTRAINT `fk_id_profe`
                                                        FOREIGN KEY (`id_profe`)
                                                            REFERENCES `matricula`.`profesores` (`idprofesores`),
                                                    CONSTRAINT `fk_grupos_ciclo1`
                                                        FOREIGN KEY (`ciclo_idciclo`)
                                                            REFERENCES `matricula`.`ciclo` (`idciclo`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION,
                                                    CONSTRAINT `fk_grupos_curso1`
                                                        FOREIGN KEY (`curso_idcurso`)
                                                            REFERENCES `matricula`.`curso` (`idcurso`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `matricula`.`matriculados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `matricula`.`matriculados` (
                                                          `grupos_idgrupos` INT NOT NULL,
                                                          `estudiantes_idestudiante` INT NOT NULL,
                                                          `nota` VARCHAR(45) NOT NULL,
                                                          PRIMARY KEY (`grupos_idgrupos`, `estudiantes_idestudiante`),
                                                          INDEX `fk_grupos_has_estudiantes_estudiantes1_idx` (`estudiantes_idestudiante` ASC) VISIBLE,
                                                          INDEX `fk_grupos_has_estudiantes_grupos1_idx` (`grupos_idgrupos` ASC) VISIBLE,
                                                          CONSTRAINT `fk_grupos_has_estudiantes_estudiantes1`
                                                              FOREIGN KEY (`estudiantes_idestudiante`)
                                                                  REFERENCES `matricula`.`estudiantes` (`idestudiante`),
                                                          CONSTRAINT `fk_grupos_has_estudiantes_grupos1`
                                                              FOREIGN KEY (`grupos_idgrupos`)
                                                                  REFERENCES `matricula`.`grupos` (`idgrupos`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `matricula`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `matricula`.`usuarios` (
                                                      `idusuarios` INT NOT NULL,
                                                      `nombre_usuario` VARCHAR(45) NOT NULL,
                                                      `password_usuario` VARCHAR(45) NOT NULL,
                                                      `token` VARCHAR(45),
                                                      `tipo` INT NOT NULL,
                                                      PRIMARY KEY (`idusuarios`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO carrera (idcarrera, nombre, titulo)
VALUES (0, 'test', 'test');

INSERT INTO ciclo (idciclo, anio, numero, fecha_inicio, fecha_fin)
VALUES (0, 0, 0, '2000-01-01', '2000-01-01');

INSERT INTO curso (idcurso, nombrecurso, creditos, horas_semanales, carrera_idcarrera, anio_deseado, ciclo_deseado)
VALUES (0, 'test', 10, 5, 0, 4, 'test');

INSERT INTO estudiantes (idestudiante, password_est, correo_estudiante, nombre, telefono_est, carrera_idcarrera, fecha_nacimiento, rol_estudiante)
VALUES (0, 'test', 'test@test', 'test', '12345678', 0, '2000-01-01', 0);

INSERT INTO profesores (idprofesores, nombre_profe, email_profe, telefono_profe, password_profe, rol_profe)
VALUES (0, 'test', 'test@test', '12345678', 'test', 0);

INSERT INTO grupos (id_profe, horario, ciclo_idciclo, curso_idcurso)
VALUES (0, 'test', 0, 0);

INSERT INTO matriculados (grupos_idgrupos, estudiantes_idestudiante, nota)
VALUES (1, 0, 'test');

INSERT INTO  usuarios (idusuarios, password_usuario, tipo)
VALUES (0, 'test', 0);