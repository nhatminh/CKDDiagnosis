-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: ckd
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `medical_record`
--

DROP TABLE IF EXISTS `medical_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medical_record` (
  `id` int(2) DEFAULT NULL,
  `bp` varchar(3) DEFAULT NULL,
  `sg` varchar(4) DEFAULT NULL,
  `al` varchar(1) DEFAULT NULL,
  `su` varchar(1) DEFAULT NULL,
  `rbc` varchar(8) DEFAULT NULL,
  `pc` varchar(8) DEFAULT NULL,
  `pcc` varchar(10) DEFAULT NULL,
  `ba` varchar(10) DEFAULT NULL,
  `bgr` varchar(3) DEFAULT NULL,
  `bu` varchar(3) DEFAULT NULL,
  `sc` varchar(3) DEFAULT NULL,
  `sod` varchar(3) DEFAULT NULL,
  `pot` varchar(2) DEFAULT NULL,
  `hemo` varchar(3) DEFAULT NULL,
  `pcv` varchar(2) DEFAULT NULL,
  `wc` varchar(5) DEFAULT NULL,
  `rc` varchar(2) DEFAULT NULL,
  `htn` varchar(3) DEFAULT NULL,
  `dm` varchar(3) DEFAULT NULL,
  `cad` varchar(3) DEFAULT NULL,
  `appet` varchar(4) DEFAULT NULL,
  `pe` varchar(3) DEFAULT NULL,
  `ane` varchar(3) DEFAULT NULL,
  `is_ckd` varchar(10) DEFAULT NULL,
  `diagnostic_recommendation` varchar(10) DEFAULT NULL,
  `physican_recommendation` varchar(10) DEFAULT NULL,
  KEY `id_idx` (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `personal_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_record`
--

LOCK TABLES `medical_record` WRITE;
/*!40000 ALTER TABLE `medical_record` DISABLE KEYS */;
INSERT INTO `medical_record` VALUES (1,'80','1.02','1','0','?','normal','notpresent','notpresent','121','36','1.2','?','?','15.','44','7800','5.','yes','yes','no','good','no','no','ckd','ckd','ckd'),(2,'50','1.02','4','0','?','normal','notpresent','notpresent','?','18','0.8','?','?','11.','38','6000','?','no','no','no','good','no','no','ckd','ckd','notckd'),(3,'80','1.01','2','3','normal','normal','notpresent','notpresent','423','53','1.8','?','?','9.6','31','7500','?','no','yes','no','poor','no','yes','ckd','',''),(4,'70','1.00','4','0','normal','abnormal','present','notpresent','117','56','3.8','111','2.','11.','32','6700','3.','yes','no','no','poor','yes','yes','notckd','',''),(5,'80','1.01','2','0','normal','normal','notpresent','notpresent','106','26','1.4','?','?','11.','35','7300','4.','no','no','no','good','no','no','ckd','',''),(6,'90','1.01','3','0','?','?','notpresent','notpresent','74','25','1.1','142','3.','12.','39','7800','4.','yes','yes','no','good','yes','no','ckd','',''),(7,'70','1.01','0','0','?','normal','notpresent','notpresent','100','54','24','104','4','12.','36','?','?','no','no','no','good','no','no','ckd','',''),(8,'?','1.01','2','4','normal','abnormal','notpresent','notpresent','410','31','1.1','?','?','12.','44','6900','5','no','yes','no','good','yes','no','ckd','',''),(9,'100','1.01','3','0','normal','abnormal','present','notpresent','138','60','1.9','?','?','10.','33','9600','4','yes','yes','no','good','no','yes','notckd','',''),(10,'90','1.02','2','0','abnormal','abnormal','present','notpresent','70','107','7.2','114','3.','9.5','29','12100','3.','yes','yes','no','poor','no','yes','notckd','','');
/*!40000 ALTER TABLE `medical_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_info`
--

DROP TABLE IF EXISTS `personal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personal_info` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(15) DEFAULT NULL,
  `address` varchar(49) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dob` varchar(100) DEFAULT NULL,
  `age` varchar(3) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `marriage` varchar(20) DEFAULT NULL,
  `blood_type` varchar(2) DEFAULT NULL,
  `height` varchar(5) DEFAULT NULL,
  `note` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_info`
--

LOCK TABLES `personal_info` WRITE;
/*!40000 ALTER TABLE `personal_info` DISABLE KEYS */;
INSERT INTO `personal_info` VALUES (1,'Fields Azeri','97 West Rose Ave. Tuckerton, NJ 08087','New York','123456789','abc@gmail.com','12/31/1995','48','Male','Married','O','1.6','This is patient note'),(2,'Yoona','392 Williams Ave. Norwalk, CT 06851','New York','123456789','abc@gmail.com','3/4/1967','7','Female','Married','A','1.6',''),(3,'Adan Dawkins','9772 Church Drive Nashua, NH 03060','New York','123456789','abc@gmail.com','4/6/1985','62','Male','Married','B','1.6',''),(4,'Goraud Mijovic','741 South Griffin Drive Charlottesville, VA 22901','New York','123456789','abc@gmail.com','3/11/1977','48','Male','Unmarried','AB','1.6',''),(5,'Rupert Gladden','40 Lower River St. Fort Walton Beach, FL 32547','New York','123456789','abc@gmail.com','9/13/1981','51','Male','Married','O','1.6',''),(6,'Ky Samson','71 North Victory Drive East Haven, CT 06512','New York','123456789','abc@gmail.com','11/24/1965','60','Male','Unmarried','A','1.6',''),(7,'Victoria Ali','626 Valley View Dr. Lebanon, PA 17042','New York','123456789','abc@gmail.com','7/28/1992','68','Female','Unmarried','B','1.6',''),(8,'Jody Acus','26 Tallwood St. Carrollton, GA 30117','New York','123456789','abc@gmail.com','1/26/1987','24','Male','Married','AB','1.6',''),(9,'Ernestine Smith','8596 Franklin Street Muskogee, OK 74403','New York','123456789','abc@gmail.com','12/11/1993','52','Female','Unmarried','O','1.6',''),(10,'Minh1','123','123','123','123','2016-06-21','2','Male','Single','A','123','123');
/*!40000 ALTER TABLE `personal_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-07 15:25:23
