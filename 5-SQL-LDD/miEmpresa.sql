DROP SCHEMA IF EXISTS empresa;

CREATE SCHEMA empresa;

use empresa;

CREATE TABLE productos (
	idfab INT(10) PRIMARY KEY,
    idproducto INT(10) NOT NULL,
    descripcion TEXT,
    precio DECIMAL (6, 2),
    existencias INT
);

CREATE TABLE empleados (
	numemp INT(10) AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL DEFAULT "Nombre",
    edad TINYINT NOT NULL DEFAULT 18,
    oficina INT(10),
    puesto VARCHAR(20),
    contrato DATE,
    jefe INT(10),
    cuota DECIMAL(6, 2) NOT NULL DEFAULT 0.0,
    ventas DECIMAL(6,2),
    CONSTRAINT pk_numemp PRIMARY KEY (numemp)
);

CREATE TABLE oficinas (
    oficina INT(10) PRIMARY KEY AUTO_INCREMENT,
    ciudad VARCHAR(30),
    region VARCHAR(10),
    dir INT(10),
    objetivo DECIMAL(6 , 2 ),
    ventas DECIMAL(6 , 2 ),
    CONSTRAINT fk_dir FOREIGN KEY (dir)
		REFERENCES empleados (numemp)
);

CREATE TABLE clientes (
	numclie INT(10) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    resp INT(10) REFERENCES empleados (numemp),
    limitecredito DECIMAL(6, 2) 
);

CREATE TABLE pedidos (
	numpedido INT(10) PRIMARY KEY AUTO_INCREMENT,
    fechapedido DATE,
    clie INT(10) REFERENCES clientes (numclie),
    resp INT(10) REFERENCES empleados (numemp),
    fab VARCHAR(20) REFERENCES productos (idfab),
    producto VARCHAR(20) NOT NULL,
    cant INT,
    importe DECIMAL(6, 2)
);