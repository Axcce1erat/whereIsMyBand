-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: band_db
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
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bands`
--

LOCK TABLES `Bands` WRITE;
/*!40000 ALTER TABLE `Bands` DISABLE KEYS */;
INSERT INTO `Bands` VALUES (1,'AC/BC','Rock','Sydney',5),(2,'Fettes Broetchen','Rap','Hamburg',4),(3,'Wu-Tang-Gruppe','Hip Hop','New-York',5),(4,'Guns n\' flowers','Metal','Boston',5),(5,'Klausis Schabernack Buben','Schlager','Darmstadt',2),(6,'Zeichenkette','Techno','Berlin',1),(7,'RedNecks','Country','Ohio',3),(8,'Wildecker_Herzdamen','Schlager','Frankfurt',4),(9,'Acca','Pop','Stockholm',5),(10,'Bloodhound_Group','Rock','Las Vegas',4),(11,'Beginner','Hip Hop','Hamburg',4),(12,'Dream-Root','Jazz','Paderborn',2),(13,'Seven Chicks','Punk','Munich',2),(14,'UguDugu','Alternative','Seattle',4),(15,'Lowlands','Rock','Portland',3),(16,'Highlands','Pop','Bristol',5),(17,'Devonshire','Metal','Rom',1),(18,'Sachsen-Anhalt','Hip Hop','Mainz',2),(19,'Kuno','Alternative','Magdeburg',5),(20,'Klausurtagung','Country','Füssen',2),(21,'Unix-Shellac','Jazz','Kiel',3),(22,'Öfterreich','Punk','Basel',4),(23,'Killing Cowboys','Country','Hamburg',2),(24,'Plastik-Bonbon','Pop','Berlin',2),(25,'Julo','Pop','Cologne',4),(26,'Finding Limo','Rock','Berlin',3),(27,'Seek\'Destroy\'Reboot','Metal','Cologne',3),(28,'TZ-489','Metal','Paderborn',4),(29,'Dauner-Remains','Jazz','Stuttgart',5),(30,'Desasterhoch3','Hip Hop','Stuttgart',3),(31,'Zollstock','Pop','Jülich',2),(32,'TöchterDeinerStadt','Hip Hop','Mannheim',2),(33,'Klavier mal Vier','Metal','Kleve',4),(34,'Metermaß','Rock','Munich',3),(35,'PaderKiller','Metal','Paderborn',5),(36,'HeinzKuslowski-Quintett','Jazz','Stuttgart',2),(37,'Cloud9+1','Alternative','Hamburg',1),(38,'Turkey + Cow','Country','Pirmasens',5),(39,'Spätzle','Country','Stuttgart',3),(40,'Klaus','Rock','Berlin',2),(41,'juxi','Pop','Cologne',4),(42,'Schlachthof','Punk','Wiesbaden',4),(43,'Liebes-Aus','Punk','Bochum',2),(44,'Kinderkrim','Hip Hop','Düsseldorf',4),(45,'Genial4You','Pop','Düsseldorf',2),(46,'Fritz und seine Freunde','Alternative','Berlin',3),(47,'Hug Me','Jazz','Hamburg',1),(48,'lame','Metal','Cologne',2),(49,'Vollaufdie12','Rock','Ulm',4),(50,'Kulinarik2000','Pop','Saarbrücken',5),(51,'Jack AB4-Project','Hip Hop','Kiel',3),(52,'The Gungas','Rock','Fulda',1),(53,'Bonobos','Jazz','Nuremberg',4),(54,'The Kollers','Rock','Heidelberg',4),(55,'Jena and the Jenas','Rock','Stuttgart',3),(56,'Bärinator','Rock','Berlin',2),(57,'JuluJulu','Pop','Cologne',1),(58,'Frozen July','Pop','Düsseldorf',5),(59,'Early Easter','Pop','Düsseldorf',2),(60,'Klingelbeutel','Punk','Berlin',3),(61,'Geldbörse','Country','Fulda',3),(62,'Gone Gone Gone','Alternative','Frankfurt/Main',4),(63,'The Gnadenlos','Metal','Frankfurt/Main',2),(64,'The Devil & The Devil2','Rock','Berlin',2),(65,'The Undercats','Punk','Cologne',3),(66,'The Rheinbows','Pop','Berlin',4),(67,'LachenWeinenTanzen','Schlager','Hamburg',2),(68,'Die Fledders','Schlager','Stuttgart',3),(69,'Gut und Besser','Pop','Ulm',5),(70,'GinGinGin','Country','Kassel',5),(71,'Riesling2019','Jazz','Oestrich-Winkel',4),(72,'Käsebrötchen','Rap','Hamburg',2),(73,'Wurstbrot','Rap','Dortmund',4),(74,'3imWeckla','Pop','Nuremberg',3);
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Instruments`
--

LOCK TABLES `Instruments` WRITE;
/*!40000 ALTER TABLE `Instruments` DISABLE KEYS */;
INSERT INTO `Instruments` VALUES (1,'piano'),(2,'violin'),(3,'bass'),(4,'voice'),(5,'mixer'),(6,'trumpet'),(7,'guitar'),(8,'drums'),(9,'cello'),(10,'viola'),(11,'flugelhorn'),(12,'clarinet'),(13,'flute'),(14,'keyboard'),(15,'oboe'),(16,'saxophon'),(17,'banjo');
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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Musician`
--

LOCK TABLES `Musician` WRITE;
/*!40000 ALTER TABLE `Musician` DISABLE KEYS */;
INSERT INTO `Musician` VALUES (1,'Berth',3),(2,'Axel',5),(3,'Malte',2),(4,'Denis',4),(5,'Andreas',1),(6,'Sandra',3),(7,'Johanna',5),(8,'Lars',2),(9,'Clara',3),(10,'Phillipp',4),(11,'Hans',3),(12,'Peter',4),(13,'Susanne',5),(14,'Johann',2),(15,'Luisa',3),(16,'Stefan',4),(17,'Robert',2),(18,'Manuel',1),(19,'Martha',4),(20,'Klaudia',3),(21,'Georg',5),(22,'Horst',4),(23,'Kuno',3),(24,'Iris',5),(25,'Hildegard',3),(26,'Matze',2),(27,'Ulf',3),(28,'Inga',3),(29,'Sophia',3),(30,'Helen',4),(31,'Jill',2),(32,'Drew',4),(33,'Hans',3),(34,'Oskar',2),(35,'Merlin',3),(36,'Laura',4),(37,'Hilmar',2),(38,'Jonathan',3),(39,'David',4),(40,'Sebastian',1),(41,'Gundula',4),(42,'Gudrun',2),(43,'Gennifer',3),(44,'River',1),(45,'Keira',3),(46,'Lou',2),(47,'Phoebe',4),(48,'Jana',3),(49,'Leo',4),(50,'Luna',3),(51,'Kate',2),(52,'Karin',3);
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
INSERT INTO `Musician_has_Instruments` VALUES (3,1),(10,1),(25,1),(45,1),(5,2),(9,2),(11,2),(31,2),(36,2),(4,3),(12,3),(21,3),(28,3),(33,3),(39,3),(41,3),(46,3),(2,4),(7,4),(14,4),(20,4),(47,4),(6,5),(15,5),(19,5),(1,6),(3,6),(8,6),(16,6),(29,6),(17,7),(30,7),(37,7),(38,7),(49,7),(18,8),(32,8),(40,8),(44,8),(34,10),(35,10),(23,11),(26,11),(27,13),(48,14),(50,14),(51,14),(22,15),(24,15),(43,15),(42,16);
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

-- Dump completed on 2020-01-16 14:39:34
