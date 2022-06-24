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
-- Table structure for table `attachedphoto`
--

DROP TABLE IF EXISTS `attachedphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attachedphoto` (
  `attachedPhotoId` binary(16) NOT NULL,
  `attachedActivityType` int NOT NULL,
  `attachedActivityId` binary(16) NOT NULL,
  `uploadUserId` binary(16) NOT NULL,
  `uploadedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `deletedDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`attachedPhotoId`),
  KEY `idx` (`attachedActivityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachedphoto`
--

LOCK TABLES `attachedphoto` WRITE;
/*!40000 ALTER TABLE `attachedphoto` DISABLE KEYS */;
INSERT INTO `attachedphoto` VALUES (_binary '�( zO|�\�[\�Ø8z',1,_binary '�( zO|�\�[\�Ø8z',_binary '�( zO|�\�[\�Ø8z','2022-06-24 13:42:45',0,NULL),(_binary '�( zO|�\�[\�Ø8�',1,_binary '�( zO|�\�[\�Ø8�',_binary '�( zO|�\�[\�Ø8�','2022-06-24 13:42:45',0,NULL),(_binary '����O\�\�[/�',1,_binary '����O\�\�[/�',_binary '����O\�\�[/�','2022-06-24 16:37:11',0,NULL),(_binary '\rM�\�/@��Y-�����',1,_binary 'LkUR@b�!`O;\�@,',_binary '�D�݂tL٧��-\�C\�','2022-06-24 20:15:59',0,NULL),(_binary '`f�\\E��|�Ū�',1,_binary '���\�:L,�\��Br!\�',_binary '��,��5B��FWѹ','2022-06-24 20:49:51',1,'2022-06-24 20:49:51'),(_binary '-XB$�I��l\��rD�',1,_binary '�f]Z�C0�����',_binary '>\��H��WSa�E','2022-06-24 17:36:39',0,NULL),(_binary '0\�\�WyI3�֯F\"V�',1,_binary 'ȫL\�\�$B��(\�\�\n��',_binary 'K70(o�K���)�\�*X\�','2022-06-24 20:23:15',1,'2022-06-24 20:23:15'),(_binary '5\�%�`J,�>\�9dl��',1,_binary '\\�gk\�D����\�\�N��',_binary '��Z\�R@鯊\�\'\�l','2022-06-24 20:27:24',1,'2022-06-24 20:27:24'),(_binary '6egvY�DT�\r\�>�f�',1,_binary ')��_Ĺ\�\�.(\�d4',_binary '�7Jm�I�b\�β','2022-06-24 20:50:39',1,'2022-06-24 20:50:39'),(_binary 'I)�n��D��$Y\� ӛ',1,_binary '&��2\�O4��\Z�]�\�',_binary '>\��H��WSa�E','2022-06-24 17:42:26',0,NULL),(_binary 'V\����BX�֘�؇\�\�',1,_binary 'h\�7ƧF<��-r\�\�-�',_binary '\�\�G\�!FID�\�@�H�x','2022-06-24 20:17:07',0,NULL),(_binary 'W��\��#BS�W�ӆ\�\�',1,_binary 'C0�\�\�A\��\�\�;��',_binary '�o\"z��G\��\�U\�B\�','2022-06-24 20:30:28',1,'2022-06-24 20:30:28'),(_binary 'W\�kY\�\rOi����\�\�\�',1,_binary '+�?f��B���\�\�\�+\�',_binary '��G`IR��\�ð�','2022-06-24 20:22:58',1,'2022-06-24 20:22:58'),(_binary 'Z�QOF�48�\�w�',1,_binary ' \�̓�C��a\\ӿ�zS',_binary '�c\��WL�7kW��`','2022-06-24 19:59:47',0,NULL),(_binary 'f��M&K���\�\� ��',1,_binary 'F��\�&.D+�\r�\�\�0',_binary ';w\�\�\�A���b�\�h\�\�','2022-06-24 20:31:26',1,'2022-06-24 20:31:26'),(_binary 'mA`p�O\�cjA\�c�;',1,_binary '*܄�1\�N��3C�ox}z',_binary ';��pD\�I(���iQȳ�','2022-06-24 20:39:09',1,'2022-06-24 20:39:09'),(_binary 'p�WIIAԼe\�!�\n�',1,_binary ' kv\�l$M����K�EG',_binary 'Jdn�\�\�J:�%�!\�R�\�','2022-06-24 20:37:10',1,'2022-06-24 20:37:10'),(_binary 'u3(6�Ca�[]�\"U\��',1,_binary 'Q�R�^�K.��ʸ�\�\r',_binary '�\�~1ieI��\�\�Y�\�\�','2022-06-24 20:29:13',1,'2022-06-24 20:29:13'),(_binary 'wfT\�N���� \�\0�H',1,_binary '\�\�k�O}�8m',_binary 'la�\rD<��\'E\�f��','2022-06-24 20:26:03',1,'2022-06-24 20:26:03'),(_binary '{;3\�U\rL��X\�\�K\�J',1,_binary '5&(>\�D��`���S�',_binary 'qσ)�J�c\n+��7�','2022-06-24 20:18:44',1,'2022-06-24 20:18:44'),(_binary '��y\�bB֧��/]\�\�',1,_binary '\�#\�6\� Am���\n\�4<',_binary '���2�I���@\�\�m�','2022-06-24 20:19:35',1,'2022-06-24 20:19:35'),(_binary '�\�[\�xHN��f\�*Q\�\'�',1,_binary '\�,�	�sLL��^�S�',_binary '\�z\�kD�a\�&F�d','2022-06-24 20:35:40',1,'2022-06-24 20:35:40'),(_binary '��\�}�I�臱�mQ.',1,_binary '?\�\�\�5Oɚ\�\�&w�',_binary '���I��\�\��(��','2022-06-24 20:17:54',0,NULL),(_binary '��8�C[�\�\�l�<�\�',1,_binary '&h\Z�,�Ou�Jr\�$\�',_binary '	.�բMĪ+\\\\�\0\�v','2022-06-24 20:58:05',1,'2022-06-24 20:58:05'),(_binary '��\�\0\�N-��T^�\n�',1,_binary '5w:��eH�Qy�\�p�',_binary '�\�\�jI��\��\�N�','2022-06-24 20:50:55',1,'2022-06-24 20:50:55'),(_binary '��\��JP���\\�\�2',1,_binary '$\nX\�_Hx��뷲fwr',_binary '>\��H��WSa�E','2022-06-24 13:43:54',0,NULL),(_binary '��,U� H����[\�2\0�',1,_binary '��\�(z�D���KX	�\�',_binary ':ظ�\"�EҤȮ&�|\�','2022-06-24 20:00:06',0,NULL),(_binary '���<\�HJ���\���=aQ',1,_binary '\�kPA\'�ٽx�\�\�',_binary '�m\�tBP�zy�_�}','2022-06-24 20:21:27',1,'2022-06-24 20:21:27'),(_binary '��\Z\�+\�B]�sPPd\�',1,_binary '�\"\�D�J3��\�|A�2\�',_binary '\�f��?N3��VKg\�','2022-06-24 20:58:28',1,'2022-06-24 20:58:28'),(_binary '\�ni�.!E��j��Jqˍ',1,_binary '`X~�U\�F\�r8̆�ٕ',_binary '�\ZH\�\�O<�H}\0M�\�','2022-06-24 20:15:59',0,NULL),(_binary '\�\�HY�*@Z����\�2o�',1,_binary '�䛄mE҄��C�O�Q',_binary '�	���;F�,A�@','2022-06-24 20:34:12',0,NULL),(_binary '\�ѦN�1Fވ\��\��',1,_binary '$\nX\�_Hx��뷲fwr',_binary '>\��H��WSa�E','2022-06-24 13:43:54',0,NULL),(_binary '\�\���3�E~fX2',1,_binary '�\�X�|I��3UE\�\�',_binary '�\�\�rݷNڲ�&\r\'nYY','2022-06-24 20:57:32',0,NULL),(_binary '\�\rK�A�N-��G�߄',1,_binary 'x�ψ\��A\\�r9b6�(',_binary 'h`�\�aE���=7\�','2022-06-24 20:37:37',1,'2022-06-24 20:37:37'),(_binary '\��\�x`IZ��X�aa�	',1,_binary '\��\�x`IZ��X�aa�	',_binary '\��\�x`IZ��X�aa�	','2022-06-24 16:35:13',0,NULL);
/*!40000 ALTER TABLE `attachedphoto` ENABLE KEYS */;
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
