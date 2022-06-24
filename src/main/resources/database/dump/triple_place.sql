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
INSERT INTO `place` VALUES (_binary '\r‹≤g\rLó0.\Ó\—lÙ',_binary ';w\ƒ\ﬁ\ŒAª®¨b§\ƒh\»\¬','2022-06-24 20:31:26',0,NULL),(_binary '\r\ÍÑ<ú\‚@Òí\Í\‡Oê°¢',_binary 'Jdnã\Ã\∆J:©%≠!\ÊR¯\–','2022-06-24 20:37:10',0,NULL),(_binary '¶U\◊’îB^ó.Ü<\"ßßı',_binary 'h`´\√aE£ùÑ=7\«','2022-06-24 20:37:37',0,NULL),(_binary 'è\ÊŸ®ˆHk≠æ¯≥\'e,Ù',_binary 'çDÜ›ÇtLŸßÜì-\ËC\›','2022-06-24 20:15:59',0,NULL),(_binary '{H&~\nBıè4Bpª\ƒ™',_binary '°†ä2éIØóë@\Ô\–mÛ','2022-06-24 20:19:35',0,NULL),(_binary 'ôπˇ}GBlΩ^ÚŸò|ç',_binary 'ôáZ\ÿR@ÈØä\Á\'\∆l','2022-06-24 20:27:24',0,NULL),(_binary '#`\"\ﬁWJØÄ0\Â0óà\Ÿ',_binary '\∆z\ÔkDäa\‘&Fãd','2022-06-24 20:35:40',0,NULL),(_binary ',¥6\Îê1LEíÜ7ùN\ÿ[',_binary 'Ø7JmÑIîb\÷Œ≤','2022-06-24 20:50:39',0,NULL),(_binary '.KØZ\ÀN˚°Ø\Ì\⁄\⁄1∞',_binary '>\ﬁÚí∑H•ÛWSa˜E','2022-06-24 13:43:54',0,NULL),(_binary 'FM=?ZAVé´É\‹ŒΩé',_binary 'qœÉ)áJác\n+ì7Æ','2022-06-24 20:18:44',0,NULL),(_binary 'GpüÛ-`DrÇ†\‰aÙ\‰¶',_binary 'ñºG`IRÑà\À√∞˜','2022-06-24 20:22:58',0,NULL),(_binary 'N\÷\Êwü™NqΩ∏\◊\ iLe˘',_binary '˚\Ÿ\ƒr›∑N⁄≤è&\r\'nYY','2022-06-24 20:57:32',0,NULL),(_binary 'Z;u;•Aü\«?L¡¡\nü',_binary '¿	≥•º;Fñ,A™@','2022-06-24 20:34:12',0,NULL),(_binary '\\\nº\Ë\ŒOÚÑ{ˆæØg\—\ﬂ',_binary 'laÚΩ§\rD<Äí\'E\Áf´ó','2022-06-24 20:26:03',0,NULL),(_binary 'g¢c\Í\ŸgHA∏k\Ô\rZé\Ó£',_binary 'ó\‡\ÓjIäß\Õ¸\ N®','2022-06-24 20:50:55',0,NULL),(_binary 'h\nCØ¨JBí24=Ö+Òn',_binary 'ì\ZH\Î\∆O<ÇH}\0Mâ\√','2022-06-24 20:15:59',0,NULL),(_binary 'à›•∑êßIØbûÇÄ\›M˚',_binary '>\ﬁÚí∑H•ÛWSa˜E','2022-06-24 17:18:31',0,NULL),(_binary 'ã~†ó}@å@˙U%',_binary 'K70(oöK∑óØ)Ù\‹*X\⁄','2022-06-24 20:23:15',0,NULL),(_binary 'ñ	°9HˆHMª~6¥ucÆ',_binary '	.˛’¢Mƒ™+\\\\à\0\·v','2022-06-24 20:58:05',0,NULL),(_binary 'órcßø´Bä≤çu\Ê\–xO\ﬂ',_binary 'æm\›tBPñzyí_∑}','2022-06-24 20:21:27',0,NULL),(_binary 'ú\—\Á\·vbI∂!íT˜1\‚',_binary '\–\ÍG\‘!FIDú\È≠@õHñx','2022-06-24 20:17:07',0,NULL),(_binary '®<L{¯\—@øS>\‹‘±\Î',_binary 'ùâ,¥¿5BàÉFW—π','2022-06-24 20:49:51',0,NULL),(_binary 'ØW\‚QBª[˜(ºó\ƒ',_binary ';á˘pD\…I(òâ˘iQ»≥©','2022-06-24 20:39:09',0,NULL),(_binary '¡\‡*\€>XLOæ\Ãj\›0ª\\¯',_binary '\Èfû¯?N3ä¥VKg\Ô','2022-06-24 20:58:28',0,NULL),(_binary '\À\„ÌÇì\„K\rß¥K\Œkgu',_binary 'áo\"zûìG\‡ñ\€U\◊B\ƒ','2022-06-24 20:30:28',0,NULL),(_binary '\Ÿ\“f4,HÕ´\Ê~ˇ\Ó',_binary 'ˇc\⁄ˆWLÚ≠7kWõµ`','2022-06-24 19:59:47',0,NULL),(_binary '\‡§\›k\€K3íÿè˘-\‚f4',_binary 'ø\œ~1ieIóó\‚\ÔYå\Ã\œ','2022-06-24 20:29:13',0,NULL),(_binary '\Îd\‹iˇ4@c§,Ú\"ºØå',_binary '´¿üIùÆ\Œ\Ÿ¡(˛å','2022-06-24 20:17:54',0,NULL),(_binary '\Ï\Ïœï\ÃO£∂Ú˚ë]q˛',_binary ':ÿ∏É\"ãE“§»Æ&∏|\·','2022-06-24 20:00:05',0,NULL);
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
