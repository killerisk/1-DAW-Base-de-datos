USE Instituto;

INSERT INTO Asignatura (cod, nombre, horas) VALUES 
  (1, "Matemáticas", 4),
  (2, "Lengua", 4),
  (3, "Naturales", 3),
  (4, "Inglés", 3),
  (10, "Programación", 8),
  (11, "EDD", 3),
  (12, "Base de datos", 6),
  (13, "Sistemas", 6),
  (14, "FOL", 2),
  (15, "LM", 4),
  (20, "Ofimática", 5),
  (21, "Redes", 4)
  ;

INSERT INTO Profesor (nombre, dni, jefeDpto) VALUES 
  ("Alberto Arenas", 	"11111111A", FALSE),
  ("Carlos Coronilla", 	"33333333C", FALSE),
  ("Beatriz Bueno", 	"22222222B", TRUE),
  ("Daniel Dinosaurio", "44444444D", TRUE),
  ("Enrique Espacio", 	"55555555E", FALSE),
  ("Fátima Feo", 	"66666666F", FALSE),
  ("Gerardo Gañan", 	"77777777G", FALSE),
  ("Hector Hidalgo", 	"88888888H", TRUE)
  ;



INSERT INTO Alumno VALUES 
  ("Zacarias Zorro", 	"09999999Z", "2000-01-01", "11111111A"),
  ("Yolanda Ybarra", 	"08888888Y", "1999-01-01", "22222222B"),
  ("Xavier Xenón", 	"07777777X", "1998-01-01", "22222222B"),
  ("Wenceslao White", 	"06666666W", "1997-01-01", "22222222B"),
  ("Urraca Urticaria", 	"05555555U", "1996-01-01", "11111111A"),
  ("Toribio Tea", 	"04444444T", "1995-01-01", NULL),
  ("Susana Simio", 	"03333333S", "1994-01-01", "44444444D"),
  ("Quillo Querubín", 	"02222222Q", "1993-01-01", "11111111A"),
  ("Paco Pérez", 	"01111111P", "1992-01-01", "44444444D"),
  ("Olivia Oro", 	"00000000O", "1991-01-01", "11111111A")
  ;


INSERT INTO Imparte (dni, cod, turno) VALUES 
  ("11111111A", 1, "Mañana"),
  ("11111111A", 2, "Mañana"),
  ("11111111A", 10, "Mañana"),
  ("33333333C", 15, "Mañana"),
  ("33333333C", 1, "Mañana"),
  ("22222222B", 12, "Tarde"),
  ("22222222B", 4, "Tarde"),
  ("22222222B", 13, "Tarde"),
  ("44444444D", 12, "Tarde"),
  ("44444444D", 20, "Tarde"),
  ("55555555E", 3, "Tarde"),
  ("55555555E", 21, "Noche"),
  ("66666666F", 11, "Noche"),
  ("88888888H", 12, "Noche"),
  ("88888888H", 10, "Noche")
  ;

INSERT INTO Matriculado (dni, cod, repe, nota, curso) VALUES 
  ("09999999Z",  1, FALSE, 5, "2011-2012"),
  ("09999999Z",  2, FALSE, 6, "2011-2012"),
  ("09999999Z",  3, FALSE, 7, "2011-2012"),
  ("09999999Z",  4, FALSE, NULL, "2011-2012"),
  ("08888888Y",  1, FALSE, 5, "2011-2012"),
  ("08888888Y",  2, TRUE, 5, "2011-2012"),
  ("07777777X", 10, FALSE, 5, "2011-2012"),
  ("07777777X", 11, TRUE, 5, "2011-2012"),
  ("07777777X", 12, FALSE, 5, "2010-2011"),
  ("06666666W", 10, FALSE, NULL, "2010-2011"),
  ("06666666W", 11, FALSE, 9, "2010-2011"),
  ("06666666W", 12, FALSE, NULL, "2010-2011"),
  ("05555555U", 10, FALSE, 5, "2010-2011"),
  ("05555555U", 11, TRUE, 5, "2010-2011"),
  ("03333333S", 12, FALSE, NULL, "2010-2011"),
  ("03333333S", 13, FALSE, 8, "2010-2011"),
  ("03333333S", 14, FALSE, 5, "2010-2011"),
  ("02222222Q",  1, FALSE, NULL, "2009-2010"),
  ("01111111P",  1, TRUE, 6, "2009-2010"),
  ("01111111P",  2, FALSE, 6, "2009-2010"),
  ("01111111P",  3, FALSE, NULL, "2009-2010"),
  ("01111111P",  4, FALSE, 7, "2009-2010"),
  ("00000000O", 10, TRUE, 6, "2009-2010"),
  ("00000000O", 11, FALSE, 8, "2009-2010"),
  ("00000000O", 20, FALSE, NULL, "2009-2010"),
  ("00000000O", 21, FALSE, 7, "2009-2010")
  ;

