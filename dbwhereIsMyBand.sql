-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

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
-- Table structure for table `Bands`
--

DROP TABLE IF EXISTS `Bands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bands` (
  `idBands` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `style` varchar(80) NOT NULL,
  `city` varchar(80) NOT NULL,
  `skill_level` int(11) NOT NULL,
  PRIMARY KEY (`idBands`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bands`
--

LOCK TABLES `Bands` WRITE;
/*!40000 ALTER TABLE `Bands` DISABLE KEYS */;
INSERT INTO `Bands` VALUES (1,'AC/BC','Rock','Sydney',5),(2,'Fettes Broetchen','Sprechgesang','Hamburg',4),(3,'Wu-Tang-Gruppe','Hip Hop','New-York',5),(4,'Guns n\' flowers','Rock/Metal','Boston',5),(5,'Klausis Schabernack Buben','Schlager','Darmstadt',2),(6,'ghjkkl','Techno','Berlin',1),(7,'RedNecks','cCountry','Ohio',3),(8,'Wildecker_Herzdamen','Schlager','Frankfurt',4),(9,'Acca','Pop','Stockholm',5),(10,'Bloodhound_Group','Rock','Las Vegas',4),(11,'Beginner','Hip Hop','Hamburg',4);
/*!40000 ALTER TABLE `Bands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Instruments`
--

DROP TABLE IF EXISTS `Instruments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Instruments` (
  `idInstruments` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`idInstruments`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Instruments`
--

LOCK TABLES `Instruments` WRITE;
/*!40000 ALTER TABLE `Instruments` DISABLE KEYS */;
INSERT INTO `Instruments` VALUES (1,'piano'),(2,'violin'),(3,'bass'),(4,'voice'),(5,'mixer'),(6,'trumpet'),(7,'guitar'),(8,'Drums');
/*!40000 ALTER TABLE `Instruments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Musician`
--

DROP TABLE IF EXISTS `Musician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Musician` (
  `idMusician` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `skill_level` int(11) NOT NULL,
  PRIMARY KEY (`idMusician`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Musician`
--

LOCK TABLES `Musician` WRITE;
/*!40000 ALTER TABLE `Musician` DISABLE KEYS */;
INSERT INTO `Musician` VALUES (1,'Berth',3),(2,'Axel',5),(3,'Malte',2),(4,'Denis',4),(5,'Andreas',1),(6,'Sandra',3),(7,'Johanna',5),(8,'Lars',2),(9,'Clara',3),(10,'Phillipp',4),(11,'Hans',3),(12,'Peter',4),(13,'Susanne',5),(14,'Johann',2),(15,'Luisa',3),(16,'Stefan',4),(17,'Robert',2),(18,'Manuel',1),(19,'Martha',4),(20,'Klaudia',3),(21,'Georg',5);
/*!40000 ALTER TABLE `Musician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Musician_has_Instruments`
--

DROP TABLE IF EXISTS `Musician_has_Instruments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Musician_has_Instruments` (
  `Musician_idMusician` int(11) NOT NULL,
  `Instruments_idInstruments` int(11) NOT NULL,
  PRIMARY KEY (`Musician_idMusician`,`Instruments_idInstruments`),
  KEY `fk_Musician_has_Instruments_Instruments1_idx` (`Instruments_idInstruments`),
  KEY `fk_Musician_has_Instruments_Musician_idx` (`Musician_idMusician`),
  CONSTRAINT `fk_Musician_has_Instruments_Instruments1` FOREIGN KEY (`Instruments_idInstruments`) REFERENCES `Instruments` (`idInstruments`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Musician_has_Instruments_Musician` FOREIGN KEY (`Musician_idMusician`) REFERENCES `Musician` (`idMusician`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Musician_has_Instruments`
--

LOCK TABLES `Musician_has_Instruments` WRITE;
/*!40000 ALTER TABLE `Musician_has_Instruments` DISABLE KEYS */;
INSERT INTO `Musician_has_Instruments` VALUES (3,1),(10,1),(5,2),(9,2),(11,2),(4,3),(12,3),(2,4),(7,4),(14,4),(20,4),(6,5),(15,5),(19,5),(1,6),(3,6),(8,6),(16,6),(17,7),(18,8);
/*!40000 ALTER TABLE `Musician_has_Instruments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-15 16:37:44
