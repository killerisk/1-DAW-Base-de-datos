SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

INSERT INTO `Robotica`.`Departamentos`(`nombred`, `numd`, `dnigte`, `inicgte`)
VALUES ('Dirección', 1, 88866555, '2011-06-16 00:00:00'),
       ('Administración', 4, 98765432, '2010-01-01 00:00:00'),
       ('Investigación', 5, 33344555, '2009-05-22 00:00:00'),
       ('Ventas', 2, 33344555, '2012-06-01 00:00:00'),
       ('I+D', 9, 90908077, '2009-08-08 00:00:00'),
       ('RRHH', 10, 90908077, '2010-10-08 00:00:00');
 
INSERT INTO `Robotica`.`Dependientes`(`dniempl`, `nombre`, `sexo`, `fechanac`, `parentesco`)
VALUES (98765432, 'Manuel', 'M', '1980-02-29 00:00:00', 'Cónyuge'),
  (33344555, 'Alicia', 'F', '2012-04-05 00:00:00', 'Hija'),
  (12345678, 'Alicia', 'F', '2008-12-31 00:00:00', 'Hija'),
  (12345678, 'Elizabeth', 'F', '1975-05-05 00:00:00', 'Cónyuge'),
  (33344555, 'Nobita', 'M', '1984-05-03 00:00:00', 'Cónyuge'),
  (33344555, 'Federico', 'M', '2008-07-03 00:00:00', 'Hijo'),
  (12345678, 'Miguel', 'M', '2010-01-01 00:00:00', 'Hijo'),
  (33344555, 'Teodoro', 'M', '2010-10-25 00:00:00', 'Hijo');

INSERT INTO `Robotica`.`Empleados`(`dni`, `nombre`, `tratamiento`, `apellidos`, `fechanac`, `direccion`, `sexo`, `salario`, `dnisuper`, `numd`)
VALUES (12345678, 'Belén', 'Srta.', 'Silva', '1975-01-09 00:00:00', 'c/Larga 731, Cádiz', 'F', 3000, 33344555, 5),
  (33344555, 'Federico', 'Sr.', 'Vizcarra', '1955-12-06 00:00:00', 'c/Corta 1638, Mairena', 'M', 1400, 88866555, 5),
  (45345345, 'Josefa', 'Sra.', 'Esparza', '1992-07-31 00:00:00', 'c/Rosas 1, Sevilla', 'F', 2500, 33344555, 5),
  (66688444, 'Ramón', 'D.', 'Nieto', '1990-09-15 00:00:00', 'avd. Espiga 85, Carmona', 'M', 1800, 33344555, 5),
  (88866555, 'Jaime', 'D.', 'Botello', '1989-11-10 00:00:00', 'c/Sierpes 50, Sevilla', 'M', 1550, NULL, 1),
  (98765432, 'Sonia', 'Sra.', 'Valdés', '1970-06-20 00:00:00', 'c/Cervantes 29, Tomares', 'F', 2400, 88866555, 4),
  (98798798, 'Victor', 'Sr.', 'Hernández', '1974-03-29 00:00:00', 'Paseo de las Encinas 63, Valencina', 'M', 2150, 98765432, 4),
  (99988777, 'Alicia', 'Dr.', 'Zapata', '1993-07-19 00:00:00', 'c/Castillo 21, Huelva', 'F', 1250, 98765432, 4),
  (90908077, 'Narcisa', 'Exc.', 'Aspiradora', '1973-07-19 00:00:00', 'c/Cocodrilo 12, Sevilla', 'F', 1500, 98765432, 4),
  (91918177, 'Claudia', 'Dª.', 'Pérez', '2000-07-19 00:00:00', 'c/Procrastinador 99, Santiponce', 'F', 1950, 98765432, 9);

INSERT INTO `Robotica`.`Lugares_dptos`(`numd`, `lugar`)
VALUES (1, 'Sevilla'),
  (4, 'Santiago'),
  (5, 'Huelva'),
  (5, 'Sevilla'),
  (5, 'Camas'),
  (2, 'Santiponce'),
  (9, 'Valencina');

INSERT INTO `Robotica`.`Proyectos`(`nombrep`, `nump`, `lugarp`, `numd`)
VALUES ('ProductoX', 1, 'Madrid', 5),
  ('ProductoY', 2, 'Soria', 5),
  ('ProductoZ', 3, 'Huelva', 5),
  ('Automatización', 10, 'Sevilla', 4),
  ('Reorganización', 20, 'Huelva', 1),
  ('Nuevas prestaciones', 30, 'Santiago', 4),
  ('Nave espacial', 4, 'Camas', 2),
  ('Buscaminas', 99, 'Valencina', 9);

INSERT INTO `Robotica`.`Trabaja_en`(`dni`, `nump`, `horas`)
VALUES (12345678, 1, 32.5),
  (12345678, 2, 7.5),
  (33344555, 2, 10.0),
  (33344555, 3, 10.0),
  (33344555, 10, 10.0),
  (33344555, 20, 10.0),
  (45345345, 1, 20.0),
  (45345345, 2, 20.0),
  (66688444, 3, 40.0),
  (88866555, 20, NULL),
  (98765432, 20, 15.0),
  (98765432, 30, 20.0),
  (98798798, 10, 35.0),
  (98798798, 30, 5.0),
  (99988777, 10, 10.0),
  (99988777, 30, 30.0),
  (99988777, 4, 10.0),
  (12345678, 4, 10.0),
  (91918177, 99, 40.0);

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
