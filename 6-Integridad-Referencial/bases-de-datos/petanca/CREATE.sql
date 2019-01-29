DROP SCHEMA IF EXISTS Petanca;

CREATE SCHEMA Petanca;
USE Petanca;

CREATE TABLE Equipos (
   cod INT PRIMARY KEY AUTO_INCREMENT,
   nombre VARCHAR(20),
   localidad VARCHAR(20)
);

CREATE TABLE Jugadores (
	numFed INT PRIMARY KEY,
	nombre VARCHAR(30),
	edad INT,
	equipo INT,
	CONSTRAINT fk FOREIGN KEY (equipo) REFERENCES Equipos(cod)
);
