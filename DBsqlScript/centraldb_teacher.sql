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
-- Table structure for table `teacher`
--
create database if not exists centraldb;

use centraldb;

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `NIC` varchar(10) NOT NULL,
  `RNo` varchar(11) NOT NULL,
  `NameWithIn` varchar(50) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Dob` date NOT NULL,
  `CivilStatus` varchar(10) DEFAULT NULL,
  `Address` varchar(150) DEFAULT NULL,
  `TelNoMobile` varchar(20) DEFAULT NULL,
  `TelNoRecident` varchar(20) DEFAULT NULL,
  `DateOfAssignmentAsTeacher` date DEFAULT NULL,
  `DateOfAssignmentToSchool` date DEFAULT NULL,
  `EducationQual` varchar(1000) DEFAULT NULL,
  `ProffessionalQual` varchar(1000) DEFAULT NULL,
  `SubjectsAndClasses` varchar(1000) DEFAULT NULL,
  `SubjectsWishToTeach` varchar(100) DEFAULT NULL,
  `GradesWishToTeach` varchar(40) DEFAULT NULL,
  `NatureOfPresentPost` varchar(20) DEFAULT NULL,
  `GradeOfService` varchar(5) DEFAULT NULL,
  `DateOfPromotion` date DEFAULT NULL,
  `SectionTaught` varchar(10) DEFAULT NULL,
  `ServiceRecord` varchar(1000) DEFAULT NULL,
  `PositionInSchool` varchar(20) DEFAULT NULL,
  `AccessPriviledge` int(11) NOT NULL,
  `ClubIncharge` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`NIC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
