-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: centraldb
-- ------------------------------------------------------
-- Server version	5.6.24-log

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
-- Table structure for table `club`
--
create database if not exists centraldb;

use centraldb;

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `club` (
  `ClubId` varchar(10) NOT NULL,
  `ClubName` varchar(100) NOT NULL,
  `TeacherIncharge` varchar(500) DEFAULT NULL,
  `Advisor` varchar(500) DEFAULT NULL,
  `PresidentId` varchar(10) DEFAULT NULL,
  `VisePresidentId` varchar(10) DEFAULT NULL,
  `SecretaryId` varchar(10) DEFAULT NULL,
  `AssSecretaryId` varchar(10) DEFAULT NULL,
  `TreasurerId` varchar(10) DEFAULT NULL,
  `Task` varchar(1000) DEFAULT NULL,
  `Suggestions` varchar(1000) DEFAULT NULL,
  `DateOfEstablish` date DEFAULT NULL,
  `MemberIdList` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ClubId`),
  UNIQUE KEY `ClubId_UNIQUE` (`ClubId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` (`ClubId`, `ClubName`, `TeacherIncharge`, `Advisor`, `PresidentId`, `VisePresidentId`, `SecretaryId`, `AssSecretaryId`, `TreasurerId`, `Task`, `Suggestions`, `DateOfEstablish`, `MemberIdList`) VALUES ('','','','','','','','','','','',NULL,''),('123','leo','danith','sarath','12312','123123','2131','13221','123','mke','casdf','2012-11-20',NULL),('123123','sun','darika','','','','','','','','',NULL,''),('123123234','sun','darika\n','saman','','','','','','a\nsdf\na\nsd\ns\nf\na\nf\nas\nfa\nd\na\ns\nf\n\nff\naa\ndf','',NULL,''),('12342','fad','adf','','','','','','','','','2015-08-05','');
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'centraldb'
--

--
-- Dumping routines for database 'centraldb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-14 14:10:02
