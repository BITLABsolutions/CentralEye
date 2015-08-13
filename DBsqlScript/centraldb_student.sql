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
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `AdmissionNumber` varchar(10) NOT NULL,
  `FullNameEnglish` varchar(100) NOT NULL,
  `FullNameSinhala` varchar(100) DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
  `House` varchar(20) DEFAULT NULL,
  `Religion` varchar(25) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `TelephoneNumber` varchar(20) DEFAULT NULL,
  `DateOfAdmission` date DEFAULT NULL,
  `ClassOfAdmission` varchar(5) DEFAULT NULL,
  `Gender` varchar(20) NOT NULL,
  PRIMARY KEY (`AdmissionNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('130238X','Sachithra Dilini Jayasiri','සචිත්‍රා දිලිනි ජයසිරි','1992-05-26','පරාක්‍රම','Buddism','12, Ranaviru Chathurasraya, Dencil Kobbakaduwa Mawatha, Galle Road, Thangalle.','0711234578','2004-03-02','6A','Female'),('130274U','Charuni kaushalya Karunanayake','චාරුනී කෞශල්‍යා කරුණානායක','1993-07-19','ගැමුණු','Buddism','Bulath kela paara, Padikkama, Gampaha.','0712324256','2014-03-03','6C','Female'),('130281M','Karunarathne Mudiyanselage karunarathne','කරුණාරත්න මුදියන්සේලාගේ චානක මධුරංග කරුණාරත්න','1993-10-26','Sura','Buddhism','29/A, \"Sumadura\" Bandaranayaka mawatha, Maththumagala, Ragama.','0717899366','2014-03-03','6J','Male');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-13  9:07:26
