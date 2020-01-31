-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: whereIsMyBand2
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
-- Table structure for table `band`
--

DROP TABLE IF EXISTS `band`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `band` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `band_name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  `style_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr4xh0qxptig557eqo36oyf47y` (`role_id`),
  KEY `FKhn4tk1qoi2xokf4qixy8sbmb7` (`skill_id`),
  KEY `FK9jmwloco3tymh4dcmb7oq9cwi` (`style_id`),
  CONSTRAINT `FK9jmwloco3tymh4dcmb7oq9cwi` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`),
  CONSTRAINT `FKhn4tk1qoi2xokf4qixy8sbmb7` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`),
  CONSTRAINT `FKr4xh0qxptig557eqo36oyf47y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band`
--

LOCK TABLES `band` WRITE;
/*!40000 ALTER TABLE `band` DISABLE KEYS */;
INSERT INTO `band` VALUES (1,'AC/BC','Sydney',3,2,2),(2,'Fettes Broetchen','Hamburg',7,2,1),(3,'Wu-Tang-Gruppe','New-York',8,1,7),(4,'Guns n\' flowers','Boston',10,4,11),(5,'Klausis Schabernack Buben','Darmstadt',11,5,12),(6,'Zeichenkette','Berlin',11,4,13),(7,'RedNecks','Ohio',4,3,10),(8,'Wildecker_Herzdamen','Frankfurt',4,3,7),(9,'Acca','Stockholm',8,3,8),(10,'Bloodhound_Group','Las Vegas',6,3,9),(11,'Beginner','Hamburg',7,3,6),(12,'Dream-Root','Paderborn',4,2,6),(13,'Seven Chicks','Munich',5,2,5),(14,'UguDugu','Seattle',8,2,5),(15,'Lowlands','Portland',10,4,3),(16,'Highlands','Bristol',11,5,2),(17,'Devonshire','Rom',1,1,1),(18,'Sachsen-Anhalt','Mainz',2,1,3),(19,'Kuno','Magdeburg',3,3,2),(20,'Klausurtagung','Füssen',5,2,4),(21,'Unix-Shellac','Kiel',4,2,5),(22,'Öfterreich','Basel',4,2,6),(23,'Killing Cowboys','Hamburg',7,2,7),(24,'Plastik-Bonbon','Berlin',8,1,8),(25,'Julo','Cologne',10,5,8),(26,'Finding Limo','Berlin',6,1,10),(27,'Seek\'Destroy\'Reboot','Cologne',3,4,2),(28,'TZ-489','Paderborn',12,4,2),(29,'Dauner-Remains','Stuttgart',8,2,11),(30,'Desasterhoch3','Stuttgart',7,3,13),(31,'Zollstock','Jülich',7,3,10),(32,'TöchterDeinerStadt','Mannheim',3,2,9),(33,'Klavier mal Vier','Kleve',2,4,7),(34,'Metermaß','Munich',3,5,8),(35,'PaderKiller','Paderborn',1,1,4),(36,'HeinzKuslowski-Quintett','Stuttgart',4,4,6),(43,'Liebes-Aus','Bochum',4,2,5),(44,'Kinderkrim','Düsseldorf',5,2,3),(50,'Kulinarik2000','Saarbrücken',2,3,4),(51,'Jack AB4-Project','Kiel',1,4,3),(52,'The Gungas','Fulda',7,1,8),(53,'Bonobos','Nuremberg',8,5,9),(54,'The Kollers','Heidelberg',8,2,10),(58,'Frozen July','Düsseldorf',8,2,11),(59,'Early Easter','Düsseldorf',10,2,8),(60,'Klingelbeutel','Berlin',11,4,6),(61,'Geldbörse','Fulda',1,3,7),(62,'Gone Gone Gone','Frankfurt/Main',3,5,6),(63,'The Gnadenlos','Frankfurt/Main',7,4,5),(64,'The Devil & The Devil2','Berlin',7,4,2),(65,'The Undercats','Cologne',2,2,1),(66,'The Rheinbows','Berlin',2,3,1),(67,'LachenWeinenTanzen','Hamburg',4,2,1),(70,'GinGinGin','Kassel',6,3,4),(71,'Riesling2019','Oestrich-Winkel',2,3,4),(72,'Käsebrötchen','Hamburg',9,2,7),(73,'Wurstbrot','Dortmund',11,2,8),(74,'3imWeckla','Nuremberg',12,2,9);
/*!40000 ALTER TABLE `band` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  `mail` varchar(80) NOT NULL,
  `phone` int(25) DEFAULT NULL,
  `message` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mail`
--

DROP TABLE IF EXISTS `mail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mail`
--

LOCK TABLES `mail` WRITE;
/*!40000 ALTER TABLE `mail` DISABLE KEYS */;
INSERT INTO `mail` VALUES (23,'bert@bandtown.com','Hallo, gibt es in DA einen ....','Bert',''),(26,'hugo@blasinstrumente-rocken.com','Ich bin auf der Suche nach einem Flügelhorn, hab aber nur ein Budget von ca. 250 Euro. ','Hugo',''),(29,'auke@skiing.nl','Hi, is there anybody?','Auke',''),(30,'black@guns&tulips','Hi, our band is looking for a guitarist...','Axl Black','');
/*!40000 ALTER TABLE `mail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Hornist/in'),(2,'Trompeter/in'),(3,'Bassist/in'),(4,'Drummer/in'),(5,'Keyboarder/in'),(6,'Gitarrist/in'),(7,'Flötist/in'),(8,'Violinist/in'),(9,'Cellist/in'),(10,'Saxofonist/in'),(11,'Bratschist/in'),(12,'Sänger/in'),(13,'Oboist/in'),(14,'Klarinettist/in'),(15,'Posaunist/in');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'Rookie'),(2,'Basic'),(3,'Advanced'),(4,'Expert'),(5,'Genius');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style`
--

DROP TABLE IF EXISTS `style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `style` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `style_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style`
--

LOCK TABLES `style` WRITE;
/*!40000 ALTER TABLE `style` DISABLE KEYS */;
INSERT INTO `style` VALUES (1,'Rock'),(2,'Pop'),(3,'Rap'),(4,'Punk'),(5,'Reggae'),(6,'Schlager'),(7,'Metal'),(8,'Jazz'),(9,'Country'),(10,'Hip Hop'),(11,'Alternative'),(12,'Electro'),(13,'Soul'),(14,'Funk'),(15,'Volksmusik'),(16,'Other');
/*!40000 ALTER TABLE `style` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-31 10:23:02
