-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: triple
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` binary(16) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `registrationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nicknameModifiedDate` timestamp NULL DEFAULT NULL,
  `isUnsigned` tinyint(1) NOT NULL DEFAULT '0',
  `unsignedDate` timestamp NULL DEFAULT NULL,
  `isRecommendated` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (_binary '�\ZH\�\�O<�H}\0M�\�','triple0','0','2022-06-24 20:15:59',NULL,0,NULL,0),(_binary '�7Jm�I�b\�β','triple0','0','2022-06-24 20:50:39',NULL,0,NULL,0),(_binary '	.�բMĪ+\\\\�\0\�v','triple5337','8185','2022-06-24 20:58:05',NULL,0,NULL,1),(_binary 'h`�\�aE���=7\�','triple0','0','2022-06-24 20:37:37',NULL,0,NULL,0),(_binary '���I��\�\��(��','triple0','0','2022-06-24 20:17:54',NULL,0,NULL,0),(_binary '�c\��WL�7kW��`','triple0','0','2022-06-24 19:59:47',NULL,0,NULL,0),(_binary '/�b\�\�A<�J&\�Z�','triple','333','2022-06-24 17:33:35',NULL,0,NULL,0),(_binary ':ظ�\"�EҤȮ&�|\�','triple0','0','2022-06-24 20:00:05',NULL,0,NULL,0),(_binary ';w\�\�\�A���b�\�h\�\�','triple0','0','2022-06-24 20:31:26',NULL,0,NULL,0),(_binary ';��pD\�I(���iQȳ�','triple0','0','2022-06-24 20:39:09',NULL,0,NULL,0),(_binary '>\��H��WSa�E','Ben','1111','2022-06-24 13:43:54',NULL,0,NULL,0),(_binary 'Jdn�\�\�J:�%�!\�R�\�','triple0','0','2022-06-24 20:37:10',NULL,0,NULL,0),(_binary 'K70(o�K���)�\�*X\�','triple0','0','2022-06-24 20:23:15',NULL,0,NULL,0),(_binary 'b��&�rH܎%�G\�5','triple0','0','2022-06-24 17:36:32',NULL,0,NULL,0),(_binary 'la�\rD<��\'E\�f��','triple0','0','2022-06-24 20:26:03',NULL,0,NULL,0),(_binary 'qσ)�J�c\n+��7�','triple0','0','2022-06-24 20:18:44',NULL,0,NULL,0),(_binary '�o\"z��G\��\�U\�B\�','triple0','0','2022-06-24 20:30:28',NULL,0,NULL,0),(_binary '�D�݂tL٧��-\�C\�','triple0','0','2022-06-24 20:15:59',NULL,0,NULL,0),(_binary '��G`IR��\�ð�','triple0','0','2022-06-24 20:22:58',NULL,0,NULL,0),(_binary '�\�\�jI��\��\�N�','triple0','0','2022-06-24 20:50:55',NULL,0,NULL,0),(_binary '��Z\�R@鯊\�\'\�l','triple0','0','2022-06-24 20:27:24',NULL,0,NULL,0),(_binary '��,��5B��FWѹ','triple0','0','2022-06-24 20:49:51',NULL,0,NULL,0),(_binary '���2�I���@\�\�m�','triple0','0','2022-06-24 20:19:35',NULL,0,NULL,0),(_binary '�m\�tBP�zy�_�}','triple0','0','2022-06-24 20:21:27',NULL,0,NULL,0),(_binary '�\�~1ieI��\�\�Y�\�\�','triple0','0','2022-06-24 20:29:13',NULL,0,NULL,0),(_binary '�	���;F�,A�@','triple0','0','2022-06-24 20:34:12',NULL,0,NULL,0),(_binary '\�z\�kD�a\�&F�d','triple0','0','2022-06-24 20:35:40',NULL,0,NULL,0),(_binary '\�\�G\�!FID�\�@�H�x','triple0','0','2022-06-24 20:17:07',NULL,0,NULL,0),(_binary '\�9\�B\�\�L�|\Z<V�IO','triple0','0','2022-06-24 18:55:58',NULL,0,NULL,0),(_binary '\�8Z�%�BL� �\�`���','triple0','0','2022-06-24 18:23:29',NULL,0,NULL,0),(_binary '\�f��?N3��VKg\�','triple3150','7659','2022-06-24 20:58:28',NULL,0,NULL,0),(_binary '�\�\�rݷNڲ�&\r\'nYY','triple5782','7079','2022-06-24 20:57:32',NULL,0,NULL,0);
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

-- Dump completed on 2022-06-25  6:18:54
