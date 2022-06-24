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
-- Table structure for table `point`
--

DROP TABLE IF EXISTS `point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `point` (
  `pointId` bigint NOT NULL AUTO_INCREMENT,
  `userId` binary(16) NOT NULL,
  `activityType` int NOT NULL,
  `activityId` binary(16) NOT NULL,
  `pointScore` int NOT NULL,
  `pointType` int DEFAULT NULL,
  `createdDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pointId`),
  KEY `idx_point_userId_activityId` (`userId`,`activityId`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `point`
--

LOCK TABLES `point` WRITE;
/*!40000 ALTER TABLE `point` DISABLE KEYS */;
INSERT INTO `point` VALUES (18,_binary '>\��H��WSa�E',1,_binary '$\nX\�_Hx��뷲fwr',1,2,'2022-06-24 13:44:06'),(19,_binary '>\��H��WSa�E',2,_binary '$\nX\�_Hx��뷲fwr',1,1,'2022-06-24 13:44:06'),(20,_binary '>\��H��WSa�E',3,_binary '$\nX\�_Hx��뷲fwr',1,1,'2022-06-24 13:44:06'),(21,_binary '�c\��WL�7kW��`',1,_binary ' \�̓�C��a\\ӿ�zS',1,2,'2022-06-24 19:59:47'),(22,_binary '�c\��WL�7kW��`',2,_binary ' \�̓�C��a\\ӿ�zS',1,1,'2022-06-24 19:59:47'),(23,_binary '�c\��WL�7kW��`',3,_binary ' \�̓�C��a\\ӿ�zS',1,1,'2022-06-24 19:59:47'),(24,_binary ':ظ�\"�EҤȮ&�|\�',1,_binary '��\�(z�D���KX	�\�',1,2,'2022-06-24 20:00:06'),(25,_binary ':ظ�\"�EҤȮ&�|\�',2,_binary '��\�(z�D���KX	�\�',1,1,'2022-06-24 20:00:06'),(26,_binary ':ظ�\"�EҤȮ&�|\�',3,_binary '��\�(z�D���KX	�\�',1,1,'2022-06-24 20:00:06'),(27,_binary '�D�݂tL٧��-\�C\�',1,_binary 'LkUR@b�!`O;\�@,',1,2,'2022-06-24 20:15:59'),(28,_binary '�D�݂tL٧��-\�C\�',2,_binary 'LkUR@b�!`O;\�@,',1,1,'2022-06-24 20:15:59'),(29,_binary '�D�݂tL٧��-\�C\�',3,_binary 'LkUR@b�!`O;\�@,',1,1,'2022-06-24 20:15:59'),(30,_binary '\�\�G\�!FID�\�@�H�x',1,_binary 'h\�7ƧF<��-r\�\�-�',1,2,'2022-06-24 20:17:07'),(31,_binary '\�\�G\�!FID�\�@�H�x',2,_binary 'h\�7ƧF<��-r\�\�-�',1,1,'2022-06-24 20:17:07'),(32,_binary '\�\�G\�!FID�\�@�H�x',3,_binary 'h\�7ƧF<��-r\�\�-�',1,1,'2022-06-24 20:17:07'),(33,_binary '���I��\�\��(��',1,_binary '?\�\�\�5Oɚ\�\�&w�',1,2,'2022-06-24 20:17:54'),(34,_binary '���I��\�\��(��',2,_binary '?\�\�\�5Oɚ\�\�&w�',1,1,'2022-06-24 20:17:54'),(35,_binary '���I��\�\��(��',3,_binary '?\�\�\�5Oɚ\�\�&w�',1,1,'2022-06-24 20:17:54'),(36,_binary 'qσ)�J�c\n+��7�',1,_binary '5&(>\�D��`���S�',1,2,'2022-06-24 20:18:44'),(37,_binary 'qσ)�J�c\n+��7�',2,_binary '5&(>\�D��`���S�',1,1,'2022-06-24 20:18:44'),(38,_binary 'qσ)�J�c\n+��7�',3,_binary '5&(>\�D��`���S�',1,1,'2022-06-24 20:18:44'),(39,_binary '���2�I���@\�\�m�',1,_binary '\�#\�6\� Am���\n\�4<',1,2,'2022-06-24 20:19:35'),(40,_binary '���2�I���@\�\�m�',2,_binary '\�#\�6\� Am���\n\�4<',1,1,'2022-06-24 20:19:35'),(41,_binary '���2�I���@\�\�m�',3,_binary '\�#\�6\� Am���\n\�4<',1,1,'2022-06-24 20:19:35'),(42,_binary '�m\�tBP�zy�_�}',1,_binary '\�kPA\'�ٽx�\�\�',1,2,'2022-06-24 20:21:27'),(43,_binary '�m\�tBP�zy�_�}',2,_binary '\�kPA\'�ٽx�\�\�',1,1,'2022-06-24 20:21:27'),(44,_binary '�m\�tBP�zy�_�}',3,_binary '\�kPA\'�ٽx�\�\�',1,1,'2022-06-24 20:21:27'),(45,_binary '��G`IR��\�ð�',1,_binary '+�?f��B���\�\�\�+\�',1,2,'2022-06-24 20:22:58'),(46,_binary '��G`IR��\�ð�',2,_binary '+�?f��B���\�\�\�+\�',1,1,'2022-06-24 20:22:58'),(47,_binary '��G`IR��\�ð�',3,_binary '+�?f��B���\�\�\�+\�',1,1,'2022-06-24 20:22:58'),(48,_binary '��G`IR��\�ð�',5,_binary '+�?f��B���\�\�\�+\�',-1,1,'2022-06-24 20:22:58'),(49,_binary 'K70(o�K���)�\�*X\�',1,_binary 'ȫL\�\�$B��(\�\�\n��',1,2,'2022-06-24 20:23:15'),(50,_binary 'K70(o�K���)�\�*X\�',2,_binary 'ȫL\�\�$B��(\�\�\n��',1,1,'2022-06-24 20:23:15'),(51,_binary 'K70(o�K���)�\�*X\�',3,_binary 'ȫL\�\�$B��(\�\�\n��',1,1,'2022-06-24 20:23:15'),(52,_binary 'K70(o�K���)�\�*X\�',5,_binary 'ȫL\�\�$B��(\�\�\n��',-1,1,'2022-06-24 20:23:15'),(53,_binary 'la�\rD<��\'E\�f��',1,_binary '\�\�k�O}�8m',1,2,'2022-06-24 20:26:03'),(54,_binary 'la�\rD<��\'E\�f��',2,_binary '\�\�k�O}�8m',1,1,'2022-06-24 20:26:03'),(55,_binary 'la�\rD<��\'E\�f��',3,_binary '\�\�k�O}�8m',1,1,'2022-06-24 20:26:03'),(56,_binary 'la�\rD<��\'E\�f��',5,_binary '\�\�k�O}�8m',-1,1,'2022-06-24 20:26:03'),(57,_binary '��Z\�R@鯊\�\'\�l',1,_binary '\\�gk\�D����\�\�N��',1,2,'2022-06-24 20:27:24'),(58,_binary '��Z\�R@鯊\�\'\�l',2,_binary '\\�gk\�D����\�\�N��',1,1,'2022-06-24 20:27:24'),(59,_binary '��Z\�R@鯊\�\'\�l',3,_binary '\\�gk\�D����\�\�N��',1,1,'2022-06-24 20:27:24'),(60,_binary '��Z\�R@鯊\�\'\�l',5,_binary '\\�gk\�D����\�\�N��',-1,1,'2022-06-24 20:27:24'),(61,_binary '�\�~1ieI��\�\�Y�\�\�',1,_binary 'Q�R�^�K.��ʸ�\�\r',1,2,'2022-06-24 20:29:13'),(62,_binary '�\�~1ieI��\�\�Y�\�\�',2,_binary 'Q�R�^�K.��ʸ�\�\r',1,1,'2022-06-24 20:29:13'),(63,_binary '�\�~1ieI��\�\�Y�\�\�',3,_binary 'Q�R�^�K.��ʸ�\�\r',1,1,'2022-06-24 20:29:13'),(64,_binary '�\�~1ieI��\�\�Y�\�\�',5,_binary 'Q�R�^�K.��ʸ�\�\r',-1,1,'2022-06-24 20:29:13'),(65,_binary '�o\"z��G\��\�U\�B\�',1,_binary 'C0�\�\�A\��\�\�;��',1,2,'2022-06-24 20:30:28'),(66,_binary '�o\"z��G\��\�U\�B\�',2,_binary 'C0�\�\�A\��\�\�;��',1,1,'2022-06-24 20:30:28'),(67,_binary '�o\"z��G\��\�U\�B\�',3,_binary 'C0�\�\�A\��\�\�;��',1,1,'2022-06-24 20:30:28'),(68,_binary '�o\"z��G\��\�U\�B\�',5,_binary 'C0�\�\�A\��\�\�;��',-1,1,'2022-06-24 20:30:28'),(69,_binary ';w\�\�\�A���b�\�h\�\�',1,_binary 'F��\�&.D+�\r�\�\�0',1,2,'2022-06-24 20:31:26'),(70,_binary ';w\�\�\�A���b�\�h\�\�',2,_binary 'F��\�&.D+�\r�\�\�0',1,1,'2022-06-24 20:31:26'),(71,_binary ';w\�\�\�A���b�\�h\�\�',3,_binary 'F��\�&.D+�\r�\�\�0',1,1,'2022-06-24 20:31:26'),(72,_binary ';w\�\�\�A���b�\�h\�\�',5,_binary 'F��\�&.D+�\r�\�\�0',-1,1,'2022-06-24 20:31:26'),(73,_binary ';w\�\�\�A���b�\�h\�\�',6,_binary 'F��\�&.D+�\r�\�\�0',-1,1,'2022-06-24 20:31:26'),(74,_binary '�	���;F�,A�@',1,_binary '�䛄mE҄��C�O�Q',1,2,'2022-06-24 20:34:12'),(75,_binary '�	���;F�,A�@',2,_binary '�䛄mE҄��C�O�Q',1,1,'2022-06-24 20:34:12'),(76,_binary '�	���;F�,A�@',3,_binary '�䛄mE҄��C�O�Q',1,1,'2022-06-24 20:34:12'),(77,_binary '\�z\�kD�a\�&F�d',1,_binary '\�,�	�sLL��^�S�',1,2,'2022-06-24 20:35:40'),(78,_binary '\�z\�kD�a\�&F�d',2,_binary '\�,�	�sLL��^�S�',1,1,'2022-06-24 20:35:40'),(79,_binary '\�z\�kD�a\�&F�d',3,_binary '\�,�	�sLL��^�S�',1,1,'2022-06-24 20:35:40'),(80,_binary 'Jdn�\�\�J:�%�!\�R�\�',1,_binary ' kv\�l$M����K�EG',1,2,'2022-06-24 20:37:10'),(81,_binary 'Jdn�\�\�J:�%�!\�R�\�',2,_binary ' kv\�l$M����K�EG',1,1,'2022-06-24 20:37:10'),(82,_binary 'Jdn�\�\�J:�%�!\�R�\�',3,_binary ' kv\�l$M����K�EG',1,1,'2022-06-24 20:37:10'),(83,_binary 'h`�\�aE���=7\�',1,_binary 'x�ψ\��A\\�r9b6�(',1,2,'2022-06-24 20:37:37'),(84,_binary 'h`�\�aE���=7\�',2,_binary 'x�ψ\��A\\�r9b6�(',1,1,'2022-06-24 20:37:37'),(85,_binary 'h`�\�aE���=7\�',3,_binary 'x�ψ\��A\\�r9b6�(',1,1,'2022-06-24 20:37:37'),(86,_binary ';��pD\�I(���iQȳ�',1,_binary '*܄�1\�N��3C�ox}z',1,2,'2022-06-24 20:39:09'),(87,_binary ';��pD\�I(���iQȳ�',2,_binary '*܄�1\�N��3C�ox}z',1,1,'2022-06-24 20:39:09'),(88,_binary ';��pD\�I(���iQȳ�',3,_binary '*܄�1\�N��3C�ox}z',1,1,'2022-06-24 20:39:09'),(89,_binary '��,��5B��FWѹ',1,_binary '���\�:L,�\��Br!\�',1,2,'2022-06-24 20:49:51'),(90,_binary '��,��5B��FWѹ',2,_binary '���\�:L,�\��Br!\�',1,1,'2022-06-24 20:49:51'),(91,_binary '��,��5B��FWѹ',3,_binary '���\�:L,�\��Br!\�',1,1,'2022-06-24 20:49:51'),(92,_binary '�7Jm�I�b\�β',1,_binary ')��_Ĺ\�\�.(\�d4',1,2,'2022-06-24 20:50:39'),(93,_binary '�7Jm�I�b\�β',2,_binary ')��_Ĺ\�\�.(\�d4',1,1,'2022-06-24 20:50:39'),(94,_binary '�7Jm�I�b\�β',3,_binary ')��_Ĺ\�\�.(\�d4',1,1,'2022-06-24 20:50:39'),(95,_binary '�\�\�jI��\��\�N�',1,_binary '5w:��eH�Qy�\�p�',1,2,'2022-06-24 20:50:55'),(96,_binary '�\�\�jI��\��\�N�',2,_binary '5w:��eH�Qy�\�p�',1,1,'2022-06-24 20:50:55'),(97,_binary '�\�\�jI��\��\�N�',3,_binary '5w:��eH�Qy�\�p�',1,1,'2022-06-24 20:50:55'),(98,_binary '�\�\�jI��\��\�N�',4,_binary '5w:��eH�Qy�\�p�',-1,2,'2022-06-24 20:50:55'),(99,_binary '�\�\�jI��\��\�N�',5,_binary '5w:��eH�Qy�\�p�',-1,1,'2022-06-24 20:50:55'),(100,_binary '�\�\�jI��\��\�N�',6,_binary '5w:��eH�Qy�\�p�',-1,1,'2022-06-24 20:50:55'),(101,_binary '�\�\�rݷNڲ�&\r\'nYY',1,_binary '�\�X�|I��3UE\�\�',1,2,'2022-06-24 20:57:32'),(102,_binary '�\�\�rݷNڲ�&\r\'nYY',2,_binary '�\�X�|I��3UE\�\�',1,1,'2022-06-24 20:57:32'),(103,_binary '�\�\�rݷNڲ�&\r\'nYY',3,_binary '�\�X�|I��3UE\�\�',1,1,'2022-06-24 20:57:32'),(104,_binary '	.�բMĪ+\\\\�\0\�v',1,_binary '&h\Z�,�Ou�Jr\�$\�',1,2,'2022-06-24 20:58:05'),(105,_binary '	.�բMĪ+\\\\�\0\�v',2,_binary '&h\Z�,�Ou�Jr\�$\�',1,1,'2022-06-24 20:58:05'),(106,_binary '	.�բMĪ+\\\\�\0\�v',3,_binary '&h\Z�,�Ou�Jr\�$\�',1,1,'2022-06-24 20:58:05'),(107,_binary '	.�բMĪ+\\\\�\0\�v',5,_binary '&h\Z�,�Ou�Jr\�$\�',-1,1,'2022-06-24 20:58:05'),(108,_binary '	.�բMĪ+\\\\�\0\�v',6,_binary '&h\Z�,�Ou�Jr\�$\�',-1,1,'2022-06-24 20:58:05'),(109,_binary '\�f��?N3��VKg\�',1,_binary '�\"\�D�J3��\�|A�2\�',1,2,'2022-06-24 20:58:28'),(110,_binary '\�f��?N3��VKg\�',2,_binary '�\"\�D�J3��\�|A�2\�',1,1,'2022-06-24 20:58:28'),(111,_binary '\�f��?N3��VKg\�',3,_binary '�\"\�D�J3��\�|A�2\�',1,1,'2022-06-24 20:58:28'),(112,_binary '\�f��?N3��VKg\�',4,_binary '�\"\�D�J3��\�|A�2\�',-1,2,'2022-06-24 20:58:28'),(113,_binary '\�f��?N3��VKg\�',5,_binary '�\"\�D�J3��\�|A�2\�',-1,1,'2022-06-24 20:58:28'),(114,_binary '\�f��?N3��VKg\�',6,_binary '�\"\�D�J3��\�|A�2\�',-1,1,'2022-06-24 20:58:28');
/*!40000 ALTER TABLE `point` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-25  6:18:53
