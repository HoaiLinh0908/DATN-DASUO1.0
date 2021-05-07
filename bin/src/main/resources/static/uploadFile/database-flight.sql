CREATE DATABASE  IF NOT EXISTS `flightticketmanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `flightticketmanagement`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: flightticketmanagement
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane` (
  `Airplane_Id` varchar(5) NOT NULL,
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Airplane_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES ('ATOM1','ATOM1'),('ATOM2','ATOM2'),('ATOM3','ATOM3');
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `Airport_Id` varchar(5) NOT NULL,
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `City_Id` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Airport_Id`),
  KEY `City_Id` (`City_Id`),
  CONSTRAINT `airport_ibfk_1` FOREIGN KEY (`City_Id`) REFERENCES `city` (`City_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES ('BMV','Buon Ma Thuot','262'),('CAH','Ca Mau','290'),('CXR','Cam Ranh','258'),('DAD','Da Nang','236'),('DIN','Dien Bien Phu','215'),('DLI','Lien Khuong','263'),('HAN','Noi Bai','24'),('HPH','Cat Bi','225'),('HUI','Phu Bai','234'),('PQC','Phu Quoc','297'),('PXU','Pleiku','269'),('SGN','Tan Son Nhat','28'),('TBB','Tuy Hoa','257'),('THD','Tho Xuan','237'),('UIH','Phu Cat','256'),('VCA','Can Tho','292'),('VCL','Chu Lai','235'),('VCS','Con Dao','254'),('VDH','Dong Hoi','232'),('VDO','Van Don','203'),('VII','Vinh','238'),('VKG','Rach Gia','297');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `Booking_Id` int(10) NOT NULL AUTO_INCREMENT,
  `PaymentMethod` varchar(100) DEFAULT NULL,
  `User_Id` int(10) DEFAULT NULL,
  `BookingDate` datetime DEFAULT NULL,
  `Phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Booking_Id`),
  KEY `User_Id` (`User_Id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `user` (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'ONLINE',94,'2022-01-01 00:00:00','011111','thuana@gmail.com'),(2,'ONLINE',94,'2022-01-01 00:00:00','022222','bbbbbbb@gmail.com'),(5,'ONLINE',NULL,'2021-03-12 14:33:01','0775461753','thuanbasto113@gmail.com'),(6,'ONLINE',NULL,'2021-03-12 14:33:01','0775461753','thuanbasto113@gmail.com'),(7,'ONLINE',NULL,'2021-03-12 14:33:01','0775461753','thuanbasto113@gmail.com'),(8,'ONLINE',NULL,'2021-03-12 14:50:27','0775461753','thuanbasto113@gmail.com'),(9,'ONLINE',NULL,'2021-03-12 16:38:26','0775461753','thuanbasto113@gmail.com'),(10,'ONLINE',NULL,'2021-01-12 16:38:26','0775461753','thuanbasto113@gmail.com'),(11,NULL,NULL,'2021-03-14 18:13:45','0775461753','thuanbasto113@gmail.com'),(12,NULL,NULL,'2021-03-14 18:50:04','0775461753','thuanbasto113@gmail.com'),(13,NULL,NULL,'2021-03-14 18:59:22','0775461753','thuanbasto113@gmail.com'),(14,'ONLINE',NULL,'2021-03-14 20:07:21','0775461753','thuanbasto113@gmail.com'),(15,'ONLINE',NULL,'2021-03-14 20:39:20','0775461753','thuanbasto113@gmail.com'),(16,'ONLINE',NULL,'2021-03-14 20:43:49','0775461753','thuanbasto113@gmail.com'),(17,'ONLINE',NULL,'2021-03-14 20:44:54','0775461753','thuanbasto113@gmail.com'),(18,'Offline',NULL,'2021-03-15 08:37:14','0775461753','thuanbasto113@gmail.com');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `City_Id` varchar(5) NOT NULL,
  `Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`City_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('203','Quang Ninh'),('215','Dien Bien'),('225','Hai Phong'),('232','Quang Binh'),('234','Thua Thien - Hue'),('235','Quang Nam'),('236','Da Nang'),('237','Thanh Hoa'),('238','Nghe An'),('24','Ha Noi'),('254','Ba Ria - Vung Tau'),('256','Binh Dinh'),('257','Phu Yen'),('258','Khanh Hoa'),('262','Dak Lak'),('263','Lam Dong'),('269','Gia Lai'),('28','Ho Chi Minh'),('290','Ca Mau'),('292','Can Tho'),('297','Kien Giang');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `Customer_Id` int(10) NOT NULL AUTO_INCREMENT,
  `IdentityNumber` varchar(15) DEFAULT NULL,
  `LastName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `FirstName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `BirthDay` date DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Customer_Id`),
  UNIQUE KEY `IdentityNumber` (`IdentityNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,NULL,'tran','thuan 1','1111-11-11','20 abc'),(2,NULL,'tran','thuan 2','9999-12-31','20 abc'),(6,NULL,'tran','thuan 3','1111-11-11','20 abc'),(7,NULL,'Thuan','Tran','2021-02-16','20 Nguyễn Huy Lượng'),(8,NULL,'tran ','thuan 4','1111-12-14','1'),(9,NULL,'tran','thuan','1111-11-11','20 Nguyễn Huy Lượng'),(10,NULL,'tran','thuan','1111-11-11','20 Nguyễn Huy Lượng'),(11,NULL,'tran','hoa','1111-11-11','123'),(12,NULL,'tran','tien','1111-11-11',''),(13,NULL,'thuan ne','thuan','1111-11-11',NULL),(14,NULL,'thuan ne 2','thuan ne 2','1111-11-11',NULL),(15,NULL,'thuan ne','thuan ne','1111-11-11',NULL),(16,NULL,'thuan ne 2','thuan ne 2','1111-11-11',NULL),(19,NULL,'Thuan','Tran','3123-12-31',NULL),(20,NULL,'Thuan','Tran','3123-12-31',NULL),(21,NULL,'Thuan','Tran','3123-12-13',NULL),(22,NULL,'Tien','Tran','0023-12-31',NULL),(23,NULL,'Thuan','Tran','3123-12-31',NULL),(24,NULL,'Thuan','Tran','2311-12-31',NULL),(25,NULL,'Thuan','Tran','2311-12-31',NULL),(26,NULL,'Thuan','Tran','3123-12-31',NULL),(27,NULL,'Thuan','Tran','3123-12-31',NULL),(28,NULL,'Thuan','Tran','3123-12-31',NULL),(29,NULL,'Hoa','Tran','3123-12-31',NULL),(30,NULL,'Tien','Tran ','3123-12-31',NULL),(31,NULL,'Thuan','Tran','3123-12-31',NULL),(32,NULL,'Thuan','Tran','3213-12-31',NULL),(33,NULL,'Thuan','Tran','3123-12-31',NULL),(34,NULL,'Thuan','Tran','3123-12-31',NULL),(35,NULL,'12313','thuyanmmmmm','3123-12-31',NULL),(36,NULL,'Thuan','Tran','0023-12-31',NULL),(37,NULL,'123123','123123','3123-12-31',NULL),(38,NULL,'Thuan','Tran','1231-12-31',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `Flight_Id` int(10) NOT NULL AUTO_INCREMENT,
  `From_Airport_Id` varchar(5) DEFAULT NULL,
  `To_Airport_Id` varchar(5) DEFAULT NULL,
  `DepartureDate` datetime DEFAULT NULL,
  `ArrivalDate` datetime DEFAULT NULL,
  `Flight_Price` double DEFAULT NULL,
  `Airplane_Id` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`Flight_Id`),
  KEY `Airplane_Id` (`Airplane_Id`),
  KEY `flight_ibfk_1` (`From_Airport_Id`),
  KEY `flight_ibfk_2` (`To_Airport_Id`),
  CONSTRAINT `flight_ibfk_1` FOREIGN KEY (`From_Airport_Id`) REFERENCES `airport` (`Airport_Id`),
  CONSTRAINT `flight_ibfk_2` FOREIGN KEY (`To_Airport_Id`) REFERENCES `airport` (`Airport_Id`),
  CONSTRAINT `flight_ibfk_3` FOREIGN KEY (`Airplane_Id`) REFERENCES `airplane` (`Airplane_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (4,'DAD','HAN','2021-09-03 00:00:00','2021-09-04 00:00:00',1000,'ATOM1'),(5,'DAD','HAN','2021-09-03 00:00:00','2021-09-04 00:00:00',1000,'ATOM2');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `Role_Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Role_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_STAFF');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_user`
--

DROP TABLE IF EXISTS `role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_user` (
  `Role_Id` int(10) NOT NULL,
  `User_Id` int(10) NOT NULL,
  PRIMARY KEY (`Role_Id`,`User_Id`),
  KEY `role_user_ibfk_1` (`User_Id`),
  CONSTRAINT `role_user_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `user` (`User_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_user_ibfk_2` FOREIGN KEY (`Role_Id`) REFERENCES `role` (`Role_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_user`
--

LOCK TABLES `role_user` WRITE;
/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
INSERT INTO `role_user` VALUES (1,94),(2,94),(1,96),(2,96);
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `Seat_Id` varchar(5) NOT NULL,
  `TravelClass_Id` int(10) DEFAULT NULL,
  PRIMARY KEY (`Seat_Id`),
  KEY `TravelClass_Id` (`TravelClass_Id`),
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`TravelClass_Id`) REFERENCES `travelclass` (`TravelClass_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES ('A001',1),('A002',1),('A003',1),('A004',1),('A005',1),('A006',1),('A007',1),('A008',1),('A009',1),('A010',1),('A011',1),('A012',1),('A013',1),('A014',1),('A015',1),('A016',1),('A017',1),('A018',1),('A019',1),('A020',1),('A021',1),('A022',1),('A023',1),('A024',1),('A025',1),('A026',1),('A027',1),('A028',1),('A029',1),('A030',1),('A031',1),('A032',1),('A033',1),('A034',1),('A035',1),('A036',1),('A037',1),('A038',1),('A039',1),('A040',1),('A041',1),('A042',1),('A043',1),('A044',1),('A045',1),('A046',1),('A047',1),('A048',1),('A049',1),('A050',1),('A051',1),('A052',1),('A053',1),('A054',1),('A055',1),('A056',1),('A057',1),('A058',1),('A059',1),('A060',1),('B001',2),('B002',2),('B003',2),('B004',2),('B005',2),('B006',2),('B007',2),('B008',2),('B009',2),('B010',2),('B011',2),('B012',2),('B013',2),('B014',2),('B015',2),('B016',2),('B017',2),('B018',2),('B019',2),('B020',2),('B021',2),('B022',2),('B023',2),('B024',2),('B025',2),('B026',2),('B027',2),('B028',2),('B029',2),('B030',2),('B031',2),('B032',2),('B033',2),('B034',2),('B035',2),('B036',2),('B037',2),('B038',2),('B039',2),('B040',2),('B041',2),('B042',2),('B043',2),('B044',2),('B045',2),('B046',2),('B047',2),('B048',2),('B049',2),('B050',2),('B051',2),('B052',2),('B053',2),('B054',2),('B055',2),('B056',2),('B057',2),('B058',2),('B059',2),('B060',2),('B061',2),('B062',2),('B063',2),('B064',2),('B065',2),('B066',2),('B067',2),('B068',2),('B069',2),('B070',2),('B071',2),('B072',2),('B073',2),('B074',2),('B075',2),('B076',2),('B077',2),('B078',2),('B079',2),('B080',2),('B081',2),('B082',2),('B083',2),('B084',2),('B085',2),('B086',2),('B087',2),('B088',2),('B089',2),('B090',2),('B091',2),('B092',2),('B093',2),('B094',2),('B095',2),('B096',2),('B097',2),('B098',2),('B099',2),('B100',2),('B101',2),('B102',2),('B103',2),('B104',2),('B105',2),('B106',2),('B107',2),('B108',2),('B109',2),('B110',2),('B111',2),('B112',2),('B113',2),('B114',2),('B115',2),('B116',2),('B117',2),('B118',2),('B119',2),('B120',2);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signedluggage`
--

DROP TABLE IF EXISTS `signedluggage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signedluggage` (
  `SignedLuggage_Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Weight` double DEFAULT NULL,
  PRIMARY KEY (`SignedLuggage_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signedluggage`
--

LOCK TABLES `signedluggage` WRITE;
/*!40000 ALTER TABLE `signedluggage` DISABLE KEYS */;
INSERT INTO `signedluggage` VALUES (1,'Package 1',15),(2,'Package 2',20),(6,'Package 3',25),(7,'Package 4',30),(8,'Package 5',35),(9,'Package 6',40);
/*!40000 ALTER TABLE `signedluggage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signedluggage_price`
--

DROP TABLE IF EXISTS `signedluggage_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signedluggage_price` (
  `Price_Id` int(10) NOT NULL AUTO_INCREMENT,
  `Price` double DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `SignedLuggage_Id` int(10) DEFAULT NULL,
  PRIMARY KEY (`Price_Id`),
  KEY `SignedLuggage_Id` (`SignedLuggage_Id`),
  CONSTRAINT `signedluggage_price_ibfk_1` FOREIGN KEY (`SignedLuggage_Id`) REFERENCES `signedluggage` (`SignedLuggage_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signedluggage_price`
--

LOCK TABLES `signedluggage_price` WRITE;
/*!40000 ALTER TABLE `signedluggage_price` DISABLE KEYS */;
INSERT INTO `signedluggage_price` VALUES (3,175000,'1999-01-01 00:00:00',1),(4,200000,'1999-01-01 00:00:00',2),(5,260000,'2021-03-12 08:30:56',6),(6,370000,'1999-01-01 00:00:00',7),(7,430000,'1999-01-01 00:00:00',8),(8,480000,'1999-01-01 00:00:00',9);
/*!40000 ALTER TABLE `signedluggage_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax`
--

DROP TABLE IF EXISTS `tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax` (
  `Tax_Id` int(10) NOT NULL AUTO_INCREMENT,
  `TaxName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Tax_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax`
--

LOCK TABLES `tax` WRITE;
/*!40000 ALTER TABLE `tax` DISABLE KEYS */;
INSERT INTO `tax` VALUES (1,'Thuế giá trị gia tăng'),(8,'Phí an ninh soi chiếu'),(11,'Phí sân bay'),(13,'Phí quản trị'),(14,'Phí thanh toán hay phí phụ thu dịch vụ xuất vé'),(16,'Phí thanh toán');
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax_price`
--

DROP TABLE IF EXISTS `tax_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax_price` (
  `Tax_Price_Id` int(10) NOT NULL AUTO_INCREMENT,
  `Price` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `Tax_Id` int(10) DEFAULT NULL,
  PRIMARY KEY (`Tax_Price_Id`),
  KEY `Tax_Id` (`Tax_Id`),
  CONSTRAINT `tax_price_ibfk_1` FOREIGN KEY (`Tax_Id`) REFERENCES `tax` (`Tax_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax_price`
--

LOCK TABLES `tax_price` WRITE;
/*!40000 ALTER TABLE `tax_price` DISABLE KEYS */;
INSERT INTO `tax_price` VALUES (1,'10000','2020-01-01 00:00:00',1),(3,'20000','2020-01-01 00:00:00',8),(8,'70000','2020-01-01 00:00:00',11),(9,'100000','2020-01-01 00:00:00',13),(15,'10000','2020-01-01 00:00:00',14),(20,'55000','2020-01-01 00:00:00',16);
/*!40000 ALTER TABLE `tax_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `Ticket_Id` int(10) NOT NULL AUTO_INCREMENT,
  `Booking_Id` int(10) DEFAULT NULL,
  `Flight_Id` int(10) DEFAULT NULL,
  `Customer_Id` int(10) DEFAULT NULL,
  `Seat_Id` varchar(5) DEFAULT NULL,
  `SignedLuggage_Id` int(10) DEFAULT NULL,
  PRIMARY KEY (`Ticket_Id`),
  KEY `Booking_Id` (`Booking_Id`),
  KEY `Flight_Id` (`Flight_Id`),
  KEY `SignedLuggage_Id` (`SignedLuggage_Id`),
  KEY `Seat_Id` (`Seat_Id`),
  KEY `Customer_Id` (`Customer_Id`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`Booking_Id`) REFERENCES `booking` (`Booking_Id`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`Flight_Id`) REFERENCES `flight` (`Flight_Id`),
  CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`SignedLuggage_Id`) REFERENCES `signedluggage` (`SignedLuggage_Id`),
  CONSTRAINT `ticket_ibfk_4` FOREIGN KEY (`Seat_Id`) REFERENCES `seat` (`Seat_Id`),
  CONSTRAINT `ticket_ibfk_5` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Customer_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (3,1,4,1,'A001',1),(4,1,4,2,'A002',2),(5,2,4,1,'A003',2),(6,2,5,1,'A001',1),(13,5,4,19,'A006',1),(14,6,4,20,'A005',2),(15,7,4,21,'A007',NULL),(16,7,4,22,'A008',2),(17,8,4,23,'A004',NULL),(18,9,5,24,'A004',2),(19,10,4,24,'A059',2),(20,11,4,25,'A010',1),(21,12,4,26,'A011',2),(22,13,4,27,'A011',2),(23,14,4,28,'A022',NULL),(24,14,4,29,'A023',2),(25,14,4,30,'A024',1),(26,15,4,31,'A020',6),(27,15,4,32,'A026',2),(28,15,4,33,'A032',2),(29,16,4,34,'A046',NULL),(30,16,4,35,'A041',2),(31,17,4,36,'B002',NULL),(32,17,4,37,'B003',NULL),(33,18,4,38,'A029',2);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_tax`
--

DROP TABLE IF EXISTS `ticket_tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_tax` (
  `Tax_Id` int(10) NOT NULL,
  `Ticket_Id` int(10) NOT NULL,
  PRIMARY KEY (`Tax_Id`,`Ticket_Id`),
  KEY `Ticket_Id` (`Ticket_Id`),
  CONSTRAINT `ticket_tax_ibfk_1` FOREIGN KEY (`Ticket_Id`) REFERENCES `ticket` (`Ticket_Id`),
  CONSTRAINT `ticket_tax_ibfk_2` FOREIGN KEY (`Tax_Id`) REFERENCES `tax` (`Tax_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_tax`
--

LOCK TABLES `ticket_tax` WRITE;
/*!40000 ALTER TABLE `ticket_tax` DISABLE KEYS */;
INSERT INTO `ticket_tax` VALUES (1,3),(8,3),(1,5),(1,15),(8,15),(11,15),(13,15),(14,15),(16,15),(1,16),(8,16),(11,16),(13,16),(14,16),(16,16),(1,17),(8,17),(11,17),(13,17),(14,17),(16,17),(1,18),(8,18),(11,18),(13,18),(14,18),(16,18),(1,19),(8,19),(11,19),(13,19),(14,19),(16,19),(1,20),(8,20),(11,20),(13,20),(14,20),(16,20),(1,21),(8,21),(11,21),(13,21),(14,21),(16,21),(1,22),(8,22),(11,22),(13,22),(14,22),(16,22),(1,23),(8,23),(11,23),(13,23),(14,23),(16,23),(1,24),(8,24),(11,24),(13,24),(14,24),(16,24),(1,25),(8,25),(11,25),(13,25),(14,25),(16,25),(1,26),(8,26),(11,26),(13,26),(14,26),(16,26),(1,27),(8,27),(11,27),(13,27),(14,27),(16,27),(1,28),(8,28),(11,28),(13,28),(14,28),(16,28),(1,29),(8,29),(11,29),(13,29),(14,29),(16,29),(1,30),(8,30),(11,30),(13,30),(14,30),(16,30),(1,31),(8,31),(11,31),(13,31),(14,31),(16,31),(1,32),(8,32),(11,32),(13,32),(14,32),(16,32),(1,33),(8,33),(11,33),(13,33),(14,33),(16,33);
/*!40000 ALTER TABLE `ticket_tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travelclass`
--

DROP TABLE IF EXISTS `travelclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travelclass` (
  `TravelClass_Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Quantity` int(10) DEFAULT NULL,
  PRIMARY KEY (`TravelClass_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travelclass`
--

LOCK TABLES `travelclass` WRITE;
/*!40000 ALTER TABLE `travelclass` DISABLE KEYS */;
INSERT INTO `travelclass` VALUES (1,'Economy',120),(2,'Business',60);
/*!40000 ALTER TABLE `travelclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travelclass_price`
--

DROP TABLE IF EXISTS `travelclass_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travelclass_price` (
  `Price_Id` int(10) NOT NULL AUTO_INCREMENT,
  `Price` double DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `TravelClass_Id` int(10) DEFAULT NULL,
  PRIMARY KEY (`Price_Id`),
  KEY `TravelClass_Id` (`TravelClass_Id`),
  CONSTRAINT `travelclass_price_ibfk_1` FOREIGN KEY (`TravelClass_Id`) REFERENCES `travelclass` (`TravelClass_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travelclass_price`
--

LOCK TABLES `travelclass_price` WRITE;
/*!40000 ALTER TABLE `travelclass_price` DISABLE KEYS */;
INSERT INTO `travelclass_price` VALUES (1,1000,'1999-01-01 00:00:00',1),(2,1100,'1999-01-01 00:00:00',1),(3,2000,'1999-01-01 00:00:00',2),(4,2200,'1999-01-01 00:00:00',2),(6,3000,'1999-01-01 00:00:00',1),(7,4000,'1999-01-01 00:00:00',2),(8,5000,'1999-01-01 00:00:00',1),(10,6000,'1999-01-01 00:00:00',2),(11,1,'1999-01-01 00:00:00',2),(15,3000,'2021-03-12 14:28:59',2);
/*!40000 ALTER TABLE `travelclass_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `User_Id` int(10) NOT NULL AUTO_INCREMENT,
  `LastName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `FirstName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `BirthDay` date DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Username` varchar(200) DEFAULT NULL,
  `Password` varchar(200) DEFAULT NULL,
  `Enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (94,'Tran','Thuan','2021-02-26','20 Nguyễn Huy Lượng','0775461753','1231233@gmail.com','thuan1','$2a$10$thYWYmLgk4qgz5G/j8s4ZuB4yIuRQ5fwCw8wIuPC/JHG3VRoeXDOG',1),(96,NULL,NULL,NULL,NULL,NULL,NULL,'admin','$2a$10$ZeVVX/uuney5DmBOmXHmL.gDiX4Yr4g5ilEUh7nxhkMvRRV3eZI5u',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-15  9:32:04
