-- MySQL dump 10.16  Distrib 10.1.29-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: avatar
-- ------------------------------------------------------
-- Server version	10.1.29-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Actividades`
--

DROP TABLE IF EXISTS `Actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Actividades` (
  `idActividad` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `tipo` varchar(30) DEFAULT NULL,
  `dniResp` int(10) DEFAULT NULL,
  `idSala` int(10) DEFAULT NULL,
  PRIMARY KEY (`idActividad`),
  KEY `dniResp` (`dniResp`),
  KEY `idSala` (`idSala`),
  CONSTRAINT `Actividades_ibfk_1` FOREIGN KEY (`dniResp`) REFERENCES `Responsables` (`dniResp`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `Actividades_ibfk_2` FOREIGN KEY (`idSala`) REFERENCES `Salas` (`idSala`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Actividades`
--

LOCK TABLES `Actividades` WRITE;
/*!40000 ALTER TABLE `Actividades` DISABLE KEYS */;
INSERT INTO `Actividades` VALUES (1,'Yoga','Físico',222,1),(2,'Reiki','Relajación',111,4),(3,'Meditación','Relajación',444,3),(4,'Canto','Miscelánea',555,2),(5,'Yoga Niños','Físico',333,5),(6,'Karate','Artes Marciales',999,1);
/*!40000 ALTER TABLE `Actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ActividadesClientes`
--

DROP TABLE IF EXISTS `ActividadesClientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ActividadesClientes` (
  `idCliente` int(10) NOT NULL,
  `idActividad` int(10) NOT NULL,
  PRIMARY KEY (`idCliente`,`idActividad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ActividadesClientes`
--

LOCK TABLES `ActividadesClientes` WRITE;
/*!40000 ALTER TABLE `ActividadesClientes` DISABLE KEYS */;
INSERT INTO `ActividadesClientes` VALUES (1,1),(1,5),(2,3),(2,5),(3,2),(3,5),(4,5),(5,4),(5,5),(6,5),(7,5),(8,5),(9,6),(10,6),(11,6),(12,6),(13,6),(14,6),(15,6),(16,6),(17,3);
/*!40000 ALTER TABLE `ActividadesClientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ActividadesSocios`
--

DROP TABLE IF EXISTS `ActividadesSocios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ActividadesSocios` (
  `idSocio` int(10) NOT NULL,
  `idActividad` int(10) NOT NULL,
  PRIMARY KEY (`idSocio`,`idActividad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ActividadesSocios`
--

LOCK TABLES `ActividadesSocios` WRITE;
/*!40000 ALTER TABLE `ActividadesSocios` DISABLE KEYS */;
INSERT INTO `ActividadesSocios` VALUES (1,1),(1,2),(2,1),(2,5),(3,1),(3,4),(4,1),(5,1),(5,3),(6,1),(7,1),(8,2),(9,2),(10,2),(11,2),(12,2),(13,3),(14,3),(15,4),(16,4),(17,4),(18,4),(19,1),(19,4),(20,1);
/*!40000 ALTER TABLE `ActividadesSocios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Agenda`
--

DROP TABLE IF EXISTS `Agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Agenda` (
  `idAgenda` int(10) NOT NULL AUTO_INCREMENT,
  `idDia` int(10) DEFAULT NULL,
  `idActividad` int(10) DEFAULT NULL,
  `horaInicio` datetime DEFAULT NULL,
  `horaFin` datetime DEFAULT NULL,
  `anyo` int(4) DEFAULT NULL,
  PRIMARY KEY (`idAgenda`),
  KEY `idDia` (`idDia`),
  KEY `idActividad` (`idActividad`),
  CONSTRAINT `Agenda_ibfk_1` FOREIGN KEY (`idDia`) REFERENCES `Dias` (`idDia`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `Agenda_ibfk_2` FOREIGN KEY (`idActividad`) REFERENCES `Actividades` (`idActividad`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Agenda`
--

LOCK TABLES `Agenda` WRITE;
/*!40000 ALTER TABLE `Agenda` DISABLE KEYS */;
INSERT INTO `Agenda` VALUES (1,1,1,'2018-01-14 10:00:00','2018-01-14 13:00:00',2018),(2,2,2,'2018-01-14 10:00:00','2018-01-14 13:00:00',2018),(3,3,3,'2018-01-14 10:00:00','2018-01-14 13:00:00',2018),(4,4,4,'2018-01-14 10:00:00','2018-01-14 13:00:00',2018),(5,5,5,'2018-01-14 10:00:00','2018-01-14 13:00:00',2018),(8,5,6,'2018-03-11 20:00:00','2018-03-11 21:00:00',2018);
/*!40000 ALTER TABLE `Agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clientes` (
  `idCLiente` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `precio` int(10) DEFAULT NULL,
  PRIMARY KEY (`idCLiente`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (1,'Juanjo Hidalgo',25),(2,'Manoli Orces',25),(3,'Judit Valencia',25),(4,'Benito López',25),(5,'Sara Palma',25),(6,'Reyes Delgado',25),(7,'Jaime Fernández',25),(8,'Javier Mateo',25),(9,'Javier Sánchez',25),(10,'Daniella Mineritti',25),(11,'Sofia Coppola',25),(12,'Benjamín Aguasdulces',25),(13,'Amira Saju',25),(14,'Soulivan Hernándes',25),(15,'Dorotea Manosalvas',25),(16,'Héctor Matamalas',25),(17,'Enríc Xintac',25);
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Dias`
--

DROP TABLE IF EXISTS `Dias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Dias` (
  `idDia` int(10) NOT NULL AUTO_INCREMENT,
  `nombreDia` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idDia`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dias`
--

LOCK TABLES `Dias` WRITE;
/*!40000 ALTER TABLE `Dias` DISABLE KEYS */;
INSERT INTO `Dias` VALUES (1,'Lunes'),(2,'Martes'),(3,'Miércoles'),(4,'Jueves'),(5,'Viernes');
/*!40000 ALTER TABLE `Dias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Responsables`
--

DROP TABLE IF EXISTS `Responsables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Responsables` (
  `dniResp` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `donativo` int(10) DEFAULT NULL,
  PRIMARY KEY (`dniResp`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Responsables`
--

LOCK TABLES `Responsables` WRITE;
/*!40000 ALTER TABLE `Responsables` DISABLE KEYS */;
INSERT INTO `Responsables` VALUES (100,'David Maroto',20),(111,'Paz Ruíz',20),(200,'Joaquín Genovés',15),(222,'Natividad Domínguez',20),(300,'Idoia Zuriña',10),(333,'Miguel Quirós',15),(444,'Holger Schmitz',10),(555,'Rosa Delgado',15),(666,'Kalhid Hassam',10),(777,'Sonia Garrido',15),(888,'Remedios Montero',20),(999,'Zaida Robles',15);
/*!40000 ALTER TABLE `Responsables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Salas`
--

DROP TABLE IF EXISTS `Salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Salas` (
  `idSala` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `numero` int(10) DEFAULT NULL,
  `capacidad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idSala`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Salas`
--

LOCK TABLES `Salas` WRITE;
/*!40000 ALTER TABLE `Salas` DISABLE KEYS */;
INSERT INTO `Salas` VALUES (1,'Sala principal',1,'grande'),(2,'Sala secundaria',2,'mediana'),(3,'Sala meditación',3,'pequeña'),(4,'Sala reiki',4,'grande'),(5,'Sala miscelánea',5,'grande');
/*!40000 ALTER TABLE `Salas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Socios`
--

DROP TABLE IF EXISTS `Socios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Socios` (
  `idSocio` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `cuota` int(10) DEFAULT NULL,
  PRIMARY KEY (`idSocio`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Socios`
--

LOCK TABLES `Socios` WRITE;
/*!40000 ALTER TABLE `Socios` DISABLE KEYS */;
INSERT INTO `Socios` VALUES (1,'Natividad Botella',20),(2,'Lucía Vázquez',20),(3,'Noelia Roche',20),(4,'Pedro Flores',20),(5,'Diego García',20),(6,'María Herrojo',20),(7,'Kiko Pérez',20),(8,'Gregorio García',20),(9,'Francisco Pinto',20),(10,'Francisco Cordero',20),(11,'Antonia Lorenzo',20),(12,'Gema Pinto',20),(13,'Carlota Sardana',20),(14,'Regina Galea',20),(15,'Eva Galea',20),(16,'Berenice Borges',20),(17,'María Borges',20),(18,'Estaban Pozos',20),(19,'Jesús Pazos',20),(20,'Susana Olmedo',20);
/*!40000 ALTER TABLE `Socios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `actividadesxdias`
--

DROP TABLE IF EXISTS `actividadesxdias`;
/*!50001 DROP VIEW IF EXISTS `actividadesxdias`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `actividadesxdias` (
  `nombreDia` tinyint NOT NULL,
  `ActividadesTotales` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!50001 DROP VIEW IF EXISTS `horario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `horario` (
  `nombreDia` tinyint NOT NULL,
  `horaInicio` tinyint NOT NULL,
  `horaFin` tinyint NOT NULL,
  `nombre` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'avatar'
--
/*!50003 DROP PROCEDURE IF EXISTS `agregarAgenda` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregarAgenda`(in idDia int(10), in idActividad int(10), in horaInicio datetime, in horaFin datetime)
BEGIN

	DECLARE anyo int(4);

    

    SET anyo = year(now());

	INSERT INTO `Agenda` (`idDia`,`idActividad`,`horaInicio`,`horaFin`,`anyo`)

	VALUES (idDia,idActividad,horaInicio,horaFin,anyo);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `horarioHoy` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `horarioHoy`(out contador int)
BEGIN

	declare dia int(1);

    

    set dia = dayofweek(now()) - 1;

    

    set contador = (SELECT count(h.nombreDia)

	FROM horario h join Dias d on h.nombreDia = d.nombreDia 

	where d.idDia = dia);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `actividadesxdias`
--

/*!50001 DROP TABLE IF EXISTS `actividadesxdias`*/;
/*!50001 DROP VIEW IF EXISTS `actividadesxdias`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `actividadesxdias` AS select `d`.`nombreDia` AS `nombreDia`,count(`a`.`idActividad`) AS `ActividadesTotales` from (`Agenda` `a` join `Dias` `d` on((`a`.`idDia` = `d`.`idDia`))) group by `d`.`nombreDia` order by `a`.`idDia` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `horario`
--

/*!50001 DROP TABLE IF EXISTS `horario`*/;
/*!50001 DROP VIEW IF EXISTS `horario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `horario` AS (select `d`.`nombreDia` AS `nombreDia`,`ag`.`horaInicio` AS `horaInicio`,`ag`.`horaFin` AS `horaFin`,`ac`.`nombre` AS `nombre` from ((`Agenda` `ag` join `Actividades` `ac` on((`ag`.`idActividad` = `ac`.`idActividad`))) join `Dias` `d` on((`ag`.`idDia` = `d`.`idDia`))) order by `d`.`idDia`,`ag`.`horaInicio`,`ag`.`horaFin`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-11 13:13:12
