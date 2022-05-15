CREATE DATABASE  IF NOT EXISTS `epl441` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `epl441`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: epl441
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `Name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Surname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Telephone` int NOT NULL,
  `Address` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `Birthday` date NOT NULL,
  `Allergies` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `ID` int NOT NULL,
  `Dead` bit(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('Vasos','Vasiliou',98989898,'aaa','1999-10-01','milk',1,_binary '\0'),('Maria','Antoniou',1111,'sadf','2002-10-10','milk',2,_binary '\0'),('aaaaaa','aaaaa',99919111,'asdf','2000-10-10','milk',3,_binary '\0'),('vbbb','bbb',99339933,'111','1970-11-03','',4,_binary '\0'),('qqqq','qqqq',12345,'sdfg','2000-01-01','',5,_binary '\0'),('ssss','ssss',1234,'asdfg','2000-01-01','',6,_binary '\0'),('asdfg','asdfg',123,'','2001-10-03','',7,_binary '\0'),('asdf','asdf',12345,'','2000-10-30','',8,_binary '\0'),('asdf','asdf',12345,'','2002-06-10','',9,_binary '\0'),('asd','asdf',12345,'','2000-12-30','',10,_binary '\0'),('asdf','asdf',123,'','2000-10-29','',11,_binary '\0'),('asd','wer',12,'sfe','2000-01-01','fish',12,_binary '\0'),('Vass','dfsdf',1234,'','2002-05-03','',13,_binary '\0'),('as','asd',123,'','2002-04-11','',14,_binary '\0'),('1234','asdfg',1234,'','1999-10-20','',15,_binary '\0'),('Vasi','sdf',99999999,'asdf','2000-10-10','',22,_binary '\0'),('aaas','ssss',123,'asd','2001-10-22','',23,_binary '\0'),('11111','11111',1234,'sadfdgf','2001-10-03','',45,_binary '\0');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15 19:13:22
