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
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place` (
  `placeId` binary(16) NOT NULL,
  `uploadUserId` binary(16) DEFAULT NULL,
  `uploadedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isdeleted` tinyint(1) NOT NULL DEFAULT '0',
  `deletedDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`placeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (_binary '\rܲg\rL�0.\�\�l�',_binary ';w\�\�\�A���b�\�h\�\�','2022-06-24 20:31:26',0,NULL),(_binary '\r\�<�\�@�\�\�O���',_binary 'Jdn�\�\�J:�%�!\�R�\�','2022-06-24 20:37:10',0,NULL),(_binary '�U\�ՔB^�.�<\"���',_binary 'h`�\�aE���=7\�','2022-06-24 20:37:37',0,NULL),(_binary '�\�٨�Hk����\'e,�',_binary '�D�݂tL٧��-\�C\�','2022-06-24 20:15:59',0,NULL),(_binary '{H&~\nB��4Bp�\��',_binary '���2�I���@\�\�m�','2022-06-24 20:19:35',0,NULL),(_binary '���}GBl�^�٘|�',_binary '��Z\�R@鯊\�\'\�l','2022-06-24 20:27:24',0,NULL),(_binary '#`\"\�WJ��0\�0��\�',_binary '\�z\�kD�a\�&F�d','2022-06-24 20:35:40',0,NULL),(_binary ',�6\�1LE��7�N\�[',_binary '�7Jm�I�b\�β','2022-06-24 20:50:39',0,NULL),(_binary '.K�Z\�N���\�\�\�1�',_binary '>\��H��WSa�E','2022-06-24 13:43:54',0,NULL),(_binary 'FM=?ZAV���\�ν�',_binary 'qσ)�J�c\n+��7�','2022-06-24 20:18:44',0,NULL),(_binary 'Gp��-`Dr��\�a�\��',_binary '��G`IR��\�ð�','2022-06-24 20:22:58',0,NULL),(_binary 'N\�\�w��Nq��\�\�iLe�',_binary '�\�\�rݷNڲ�&\r\'nYY','2022-06-24 20:57:32',0,NULL),(_binary 'Z;u;�A�\�?L��\n�',_binary '�	���;F�,A�@','2022-06-24 20:34:12',0,NULL),(_binary '\\\n�\�\�O�{���g\�\�',_binary 'la�\rD<��\'E\�f��','2022-06-24 20:26:03',0,NULL),(_binary 'g�c\�\�gHA�k\�\rZ�\�',_binary '�\�\�jI��\��\�N�','2022-06-24 20:50:55',0,NULL),(_binary 'h\nC��JB�24=�+�n',_binary '�\ZH\�\�O<�H}\0M�\�','2022-06-24 20:15:59',0,NULL),(_binary '�ݥ���I�b���\�M�',_binary '>\��H��WSa�E','2022-06-24 17:18:31',0,NULL),(_binary '�~��}@�@�U%',_binary 'K70(o�K���)�\�*X\�','2022-06-24 20:23:15',0,NULL),(_binary '�	�9H�HM�~6�uc�',_binary '	.�բMĪ+\\\\�\0\�v','2022-06-24 20:58:05',0,NULL),(_binary '�rc���B���u\�\�xO\�',_binary '�m\�tBP�zy�_�}','2022-06-24 20:21:27',0,NULL),(_binary '�\�\�\�vbI�!�T�1\�',_binary '\�\�G\�!FID�\�@�H�x','2022-06-24 20:17:07',0,NULL),(_binary '�<L{�\�@�S>\�Ա\�',_binary '��,��5B��FWѹ','2022-06-24 20:49:51',0,NULL),(_binary '�W\�QB�[�(��\�',_binary ';��pD\�I(���iQȳ�','2022-06-24 20:39:09',0,NULL),(_binary '�\�*\�>XLO�\�j\�0�\\�',_binary '\�f��?N3��VKg\�','2022-06-24 20:58:28',0,NULL),(_binary '\�\�킓\�K\r��K\�kgu',_binary '�o\"z��G\��\�U\�B\�','2022-06-24 20:30:28',0,NULL),(_binary '\�\�f4,Hͫ\�~�\�',_binary '�c\��WL�7kW��`','2022-06-24 19:59:47',0,NULL),(_binary '\��\�k\�K3�؏�-\�f4',_binary '�\�~1ieI��\�\�Y�\�\�','2022-06-24 20:29:13',0,NULL),(_binary '\�d\�i�4@c�,�\"���',_binary '���I��\�\��(��','2022-06-24 20:17:54',0,NULL),(_binary '\�\�ϕ\�O�����]q�',_binary ':ظ�\"�EҤȮ&�|\�','2022-06-24 20:00:05',0,NULL);
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
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
