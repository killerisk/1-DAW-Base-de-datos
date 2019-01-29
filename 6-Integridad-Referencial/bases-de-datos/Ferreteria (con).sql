DROP DATABASE IF EXISTS Ferreteria;
CREATE schema Ferreteria;
USE Ferreteria;

CREATE table Tipo(
	tipo varchar (10),
	descripcion varchar(10),
	primary key (tipo)
) ENGINE = InnoDB;

CREATE table Producto (
	tipo varchar (10),
	nombre varchar(10),
	precio double,
	primary key (tipo,nombre),
	constraint fk1 foreign key (tipo) references Tipo(tipo) 
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
)ENGINE = InnoDB;

CREATE table Venta(
	id int,
	tipo varchar(10),
	nombre varchar(10),
	fecha date,
	cantidad int,
	primary key(id),
	constraint fk2 foreign key (tipo, nombre) references Producto(tipo, nombre)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) engine = InnoDB;

CREATE table Tienda(
	id int,
	nombre varchar(10),
	primary key (id)
)ENGINE = InnoDB;

CREATE table Vende(
	tipo varchar(10),
	nombre varchar(10),
	idTienda int,
	primary key(tipo,nombre,idTienda),
	constraint fk4 foreign key (tipo, nombre) references Producto(tipo, nombre)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
	constraint fk6 foreign key (idTienda) references Tienda(id) 
    ON UPDATE CASCADE
)ENGINE = InnoDB;

