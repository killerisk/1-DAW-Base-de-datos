DROP DATABASE IF EXISTS Libreria;
CREATE DATABASE Libreria;

USE Libreria;

CREATE TABLE Editorial(
	nombre VARCHAR(50),
	telefono VARCHAR(9),
	PRIMARY KEY (nombre)
) ENGINE=InnoDB;

CREATE TABLE Autor(
	nombre VARCHAR(50),
	añoNacimiento INT(4),
	PRIMARY KEY (nombre)
) ENGINE=InnoDB;


CREATE TABLE Libro(
	isbn VARCHAR(13),
	titulo VARCHAR(50),
	editorial VARCHAR(50),
	autor VARCHAR(50),
	PRIMARY KEY (isbn),
	FOREIGN KEY (editorial) REFERENCES Editorial(nombre)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
	FOREIGN KEY (autor) REFERENCES Autor(nombre)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE Stock(
	isbn VARCHAR(13),
	cantidad INT(3),
	PRIMARY KEY (isbn),
	FOREIGN KEY (isbn) REFERENCES Libro(isbn)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;
