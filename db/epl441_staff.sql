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
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `ID` int NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Telephone` int NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Job` int NOT NULL,
  `ClinicID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClinicID` (`ClinicID`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`ClinicID`) REFERENCES `clinic` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Andreas','Andreou',99999999,'and@some.com','user1','pass1','Makariou 7, lLefkosia',1,1),(2,'Maria','Antoniou',97979797,'mand@some.com','user2','pass2','Kolokotroni 10 ,Lefkosia',2,1),(3,'Marios','Iakovou',91919191,'mar@some.com','user3','pass3','Aristotelous 44, Paralimni',3,1),(4,'Ilias','Argyrou',90909090,'ilias@some.com','user4','pass4','Eleftheria 22, Lefkosia',4,1),(5,'Vasilis','Panagiotou',98727272,'vasil@some.com','user5','pass5','Eirinis 15, Lefkosia',1,2),(6,'Alili','Hadjinikolaou',91929394,'aliki@some.com','user6','pass6','Kyprianou 19, Lefkosia',2,2),(7,'Andreas','Nikolaou',91919191,'an@some.com','user7','pass7','Makariou 77, Lefkosia',3,2),(8,'Maria','Andreou',90934843,'maria@some.com','user8','pass8','Paligenesias 2, Lefkosia',4,2);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-15 19:13:21
