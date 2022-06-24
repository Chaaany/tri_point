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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `reviewId` binary(16) NOT NULL,
  `placeId` binary(16) NOT NULL,
  `userId` binary(16) NOT NULL,
  `content` longtext,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `uploadedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NULL DEFAULT NULL,
  `deletedDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `idx_review_placeId_userId` (`placeId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (_binary 'LkUR@b�!`O;\�@,',_binary '�\�٨�Hk����\'e,�',_binary '�D�݂tL٧��-\�C\�','좋아요!!!0',0,'2022-06-24 20:15:59',NULL,NULL),(_binary '�䛄mE҄��C�O�Q',_binary 'Z;u;�A�\�?L��\n�',_binary '�	���;F�,A�@','좋아요!!!0',0,'2022-06-24 20:34:12',NULL,NULL),(_binary ' kv\�l$M����K�EG',_binary '\r\�<�\�@�\�\�O���',_binary 'Jdn�\�\�J:�%�!\�R�\�','좋아요!!!0',1,'2022-06-24 20:37:10',NULL,'2022-06-24 20:37:10'),(_binary ' �rHd\�C��\�z�+!\�k',_binary '.K�Z\�N���\�\�\�1�',_binary '>\��H��WSa�E','0',0,'2022-06-24 18:57:43',NULL,NULL),(_binary ' \�̓�C��a\\ӿ�zS',_binary '\�\�f4,Hͫ\�~�\�',_binary '�c\��WL�7kW��`','좋아요!!!0',0,'2022-06-24 19:59:47',NULL,NULL),(_binary '$\nX\�_Hx��뷲fwr',_binary '.K�Z\�N���\�\�\�1�',_binary '>\��H��WSa�E','좋아요!',0,'2022-06-24 13:43:54',NULL,NULL),(_binary '&h\Z�,�Ou�Jr\�$\�',_binary '�	�9H�HM�~6�uc�',_binary '	.�բMĪ+\\\\�\0\�v','',0,'2022-06-24 20:58:05','2022-06-24 20:58:05',NULL),(_binary ')��_Ĺ\�\�.(\�d4',_binary ',�6\�1LE��7�N\�[',_binary '�7Jm�I�b\�β','좋아요!!!0',1,'2022-06-24 20:50:39',NULL,'2022-06-24 20:50:39'),(_binary '*܄�1\�N��3C�ox}z',_binary '�W\�QB�[�(��\�',_binary ';��pD\�I(���iQȳ�','좋아요!!!0',1,'2022-06-24 20:39:09',NULL,'2022-06-24 20:39:09'),(_binary '+�?f��B���\�\�\�+\�',_binary 'Gp��-`Dr��\�a�\��',_binary '��G`IR��\�ð�','',0,'2022-06-24 20:22:58','2022-06-24 20:22:58',NULL),(_binary '5&(>\�D��`���S�',_binary 'FM=?ZAV���\�ν�',_binary 'qσ)�J�c\n+��7�','',0,'2022-06-24 20:18:44','2022-06-24 20:18:44',NULL),(_binary '5w:��eH�Qy�\�p�',_binary 'g�c\�\�gHA�k\�\rZ�\�',_binary '�\�\�jI��\��\�N�','좋아요!!!0',1,'2022-06-24 20:50:55',NULL,'2022-06-24 20:50:55'),(_binary '?\�\�\�5Oɚ\�\�&w�',_binary '\�d\�i�4@c�,�\"���',_binary '���I��\�\��(��','',0,'2022-06-24 20:17:54','2022-06-24 20:17:54',NULL),(_binary 'C0�\�\�A\��\�\�;��',_binary '\�\�킓\�K\r��K\�kgu',_binary '�o\"z��G\��\�U\�B\�','',0,'2022-06-24 20:30:28','2022-06-24 20:30:28',NULL),(_binary 'F��\�&.D+�\r�\�\�0',_binary '\rܲg\rL�0.\�\�l�',_binary ';w\�\�\�A���b�\�h\�\�','',0,'2022-06-24 20:31:26','2022-06-24 20:31:26',NULL),(_binary 'Q�R�^�K.��ʸ�\�\r',_binary '\��\�k\�K3�؏�-\�f4',_binary '�\�~1ieI��\�\�Y�\�\�','',0,'2022-06-24 20:29:13','2022-06-24 20:29:13',NULL),(_binary '\\�gk\�D����\�\�N��',_binary '���}GBl�^�٘|�',_binary '��Z\�R@鯊\�\'\�l','',0,'2022-06-24 20:27:24','2022-06-24 20:27:24',NULL),(_binary '`X~�U\�F\�r8̆�ٕ',_binary 'h\nC��JB�24=�+�n',_binary '�\ZH\�\�O<�H}\0M�\�','좋아요!!!0',0,'2022-06-24 20:15:59',NULL,NULL),(_binary 'h\�7ƧF<��-r\�\�-�',_binary '�\�\�\�vbI�!�T�1\�',_binary '\�\�G\�!FID�\�@�H�x','좋아요!!!0',0,'2022-06-24 20:17:07',NULL,NULL),(_binary 'x�ψ\��A\\�r9b6�(',_binary '�U\�ՔB^�.�<\"���',_binary 'h`�\�aE���=7\�','좋아요!!!0',1,'2022-06-24 20:37:37',NULL,'2022-06-24 20:37:37'),(_binary '��\�(z�D���KX	�\�',_binary '\�\�ϕ\�O�����]q�',_binary ':ظ�\"�EҤȮ&�|\�','좋아요!!!0',0,'2022-06-24 20:00:05',NULL,NULL),(_binary '���\�:L,�\��Br!\�',_binary '�<L{�\�@�S>\�Ա\�',_binary '��,��5B��FWѹ','좋아요!!!0',1,'2022-06-24 20:49:51',NULL,'2022-06-24 20:49:51'),(_binary '\�\�k�O}�8m',_binary '\\\n�\�\�O�{���g\�\�',_binary 'la�\rD<��\'E\�f��','',0,'2022-06-24 20:26:03','2022-06-24 20:26:03',NULL),(_binary 'ȫL\�\�$B��(\�\�\n��',_binary '�~��}@�@�U%',_binary 'K70(o�K���)�\�*X\�','',0,'2022-06-24 20:23:15','2022-06-24 20:23:15',NULL),(_binary '\�,�	�sLL��^�S�',_binary '#`\"\�WJ��0\�0��\�',_binary '\�z\�kD�a\�&F�d','좋아요!!!0',1,'2022-06-24 20:35:40',NULL,'2022-06-24 20:35:40'),(_binary '\�#\�6\� Am���\n\�4<',_binary '{H&~\nB��4Bp�\��',_binary '���2�I���@\�\�m�','',0,'2022-06-24 20:19:35','2022-06-24 20:19:35',NULL),(_binary '\�?�u�\�M��\�*��',_binary '.K�Z\�N���\�\�\�1�',_binary '>\��H��WSa�E','0',0,'2022-06-24 18:56:18',NULL,NULL),(_binary '\�kPA\'�ٽx�\�\�',_binary '�rc���B���u\�\�xO\�',_binary '�m\�tBP�zy�_�}','',0,'2022-06-24 20:21:27','2022-06-24 20:21:27',NULL),(_binary '�\�X�|I��3UE\�\�',_binary 'N\�\�w��Nq��\�\�iLe�',_binary '�\�\�rݷNڲ�&\r\'nYY','좋아요!!!4896',0,'2022-06-24 20:57:32',NULL,NULL),(_binary '�\"\�D�J3��\�|A�2\�',_binary '�\�*\�>XLO�\�j\�0�\\�',_binary '\�f��?N3��VKg\�','좋아요!!!998',1,'2022-06-24 20:58:28',NULL,'2022-06-24 20:58:28');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-25  6:18:52
