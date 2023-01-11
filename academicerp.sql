-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: academicerp
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `department` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `UK_2y5g3ij0kgtvrlp3rtmjlabj4` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'Administration','bhargav@gmail.com','Bhargav','Mehta','000','Admin'),(2,'Accounts','jayesh@gmail.com','Jayesh','Patel','000','Admin'),(3,'Teaching','Namita@gmail.com','Namita','Patel','000','Professor'),(4,'Teaching','Sagar@gmail.com','Sagar','Dhagia','000','Professor'),(5,'Accounts','Purav@gmail.com','Purav','Shah','000','Admin'),(6,'Teaching','rajendra@gmail.com','Rajendra','Mehta','000','Professor'),(7,'Accounts','Pooja@iiitb.org','Pooja','Mehra','000','Admin'),(8,'Accounts','Jeff@gmail.com','Jeff','Bezos','000','Admin'),(9,'Security','kajal@iiitb.ac.in','kajal','Bist','000','Registrar'),(10,'Administration','Deena@gmail.com','Deena','Shah','000','Registrar'),(11,'Security','jay@gmail.com','kajal','Mehra','000','Manager');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EmployeeSalary`
--

DROP TABLE IF EXISTS `EmployeeSalary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EmployeeSalary` (
  `id` int NOT NULL,
  `amount` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `type` char(1) NOT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmnulmlh74edoh0uwwjjafivty` (`employee_id`),
  CONSTRAINT `FKmnulmlh74edoh0uwwjjafivty` FOREIGN KEY (`employee_id`) REFERENCES `Employee` (`employee_id`),
  CONSTRAINT `EmployeeSalary_chk_1` CHECK ((`amount` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EmployeeSalary`
--

LOCK TABLES `EmployeeSalary` WRITE;
/*!40000 ALTER TABLE `EmployeeSalary` DISABLE KEYS */;
INSERT INTO `EmployeeSalary` VALUES (9,9999,'Medical Expenses','2021-12-24','D',1),(10,8000,'Medical Expenses','2021-11-02','R',2),(11,9000,'Medical Expenses','2021-11-02','R',3),(12,11000,'Medical Expenses','2021-11-02','R',4),(13,4000,'Medical Expenses','2021-11-02','R',5),(14,5000,'Medical Expenses','2021-11-02','R',6),(15,16000,'Medical Expenses','2021-11-02','R',8),(16,19000,'Onsite work - Hotel and Flight Charges','2021-11-02','R',1),(17,91000,'Onsite work - Hotel and Flight Charges','2021-11-02','R',2),(18,89000,'Onsite work - Hotel and Flight Charges','2021-11-02','R',3),(19,230000,'Onsite work - Hotel and Flight Charges','2021-11-02','R',4),(20,44000,'Onsite work - Hotel and Flight Charges','2021-11-02','R',5),(21,7000,'Onsite work - Hotel and Flight Charges','2021-11-02','R',6),(22,55000,'Monthly salary','2021-11-02','R',1),(23,68000,'Monthly salary','2021-11-02','R',3),(24,78000,'Monthly salary','2021-11-02','R',4),(25,57000,'Onsite work - Hotel and Flight Charges','2021-11-02','R',5),(26,33000,'Onsite work - Hotel and Flight Charges','2021-11-02','R',1),(29,9999,'Christmas Bonus','2021-12-24','R',6),(30,9999,'Christmas Bonus','2021-12-24','R',8),(31,5000,'Christmas Bonus','2021-12-24','D',2),(32,5000,'Christmas Bonus','2021-12-24','D',3);
/*!40000 ALTER TABLE `EmployeeSalary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (33);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-01 19:05:48
