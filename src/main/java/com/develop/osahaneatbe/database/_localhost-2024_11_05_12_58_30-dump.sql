-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: osahan-eat
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `faceboo_account_id` varchar(255) DEFAULT NULL,
  `google_account_id` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(10) NOT NULL,
  `role_id` int DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKk8h1bgqoplx0rkngj01pm1rgp` (`username`),
  KEY `FKt3wava8ssfdspnh3hg4col3m1` (`role_id`),
  CONSTRAINT `FKt3wava8ssfdspnh3hg4col3m1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('347d00fa-8899-4a58-986a-519169c2ac5e','2024-10-31 10:16:56.255531','2024-10-31 10:16:56.255531',NULL,NULL,_binary '','$2a$10$gNKxXnvoPXjChxUEU73P1eSSg1tnhUtQsYAVvGDMi.GHtN7HdDKlW','0869885512',4,NULL,NULL),('3880bc26-cc66-42d3-b22d-d63fe1699c98','2024-11-01 22:31:22.318473','2024-11-01 22:31:22.320475',NULL,NULL,_binary '','$2a$10$QQOEnTViWTlzvdq0dD8hvezxDRQAly50HK9uDvP5CVRRulHwk9gc2','0869885514',1,NULL,NULL),('88066095-3cf5-4b61-a884-28955eaae5b3','2024-10-31 10:44:34.837128','2024-10-31 10:44:34.837128',NULL,NULL,_binary '','$2a$10$vJR0nVoNeRviCPRpon2mB.xzB6Fu.rukBxImROOPJCxghvWFZ5fHm','0869885513',1,NULL,NULL);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKt8o6pivur7nn124jehx7cygw5` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES ('04b64dfd-d02c-4447-b410-b4281f5ae998','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:02:45.010826','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:04:57.114225','Các món thịt nướng thường được ướp gia vị và nướng trên lửa trực tiếp hoặc than hoa để tạo ra hương vị thơm ngon đặc trưng','480ff1b9-b669-4e4c-8b09-e316024c1ebd_barbecue.png','Thịt nướng'),('0b7d2b17-7f0e-4423-aa2f-c73872b90cf8','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:45:30.124176','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:17:21.870168','Các loại súp nóng hoặc lạnh, như súp gà, súp rau củ, hoặc súp hải sản','e92a4a30-903d-4857-8970-63d5f7ca87d3_9296635.png','Súp'),('45095590-e4f0-4837-855b-66048a95d64b','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:08:17.491281','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:24:40.255190','Phở là một trong những món ăn đặc trưng và nổi tiếng nhất của ẩm thực Việt Nam','a1b3a824-84dc-4a9a-b7ec-890ba00572b4_ramen.png','Phở'),('5b923767-b769-46cb-9cc0-4ae379fedbbf','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:46:23.115912','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:44:16.370477','Các món ăn phụ như khoai tây chiên, cơm, hoặc rau xào','e33a6e74-c6d7-4e4d-94fd-a1ccaf0e903b_6571044.png','Món Phụ'),('63455435-5e16-4761-83c3-0c136296bfd6','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:01:48.006744','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:01:48.006744','Danh mục dành cho lẩu gà với nước dùng thơm ngon và thịt gà mềm.',NULL,'Lẩu Gà'),('6e2e99bc-8222-4055-9e34-c4d03f85e6a2','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:01:40.728152','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:01:40.728152','Danh mục cho các món lẩu Thái nổi bật với hương vị cay nồng và nhiều loại nguyên liệu.',NULL,'Lẩu Thái'),('7ac12914-c253-49b5-8871-12a8ac440685','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:00:10.705551','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:01:14.032514','Mì sợi là một thực phẩm thường dùng trong nhiều nền văn hóa làm từ bột không men','69d5895f-b17e-4d6c-9b30-e19062a69fab_8775447.png','Mì sợi'),('86bab1aa-51ff-4a1b-b5e9-349c5386bcdb','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:28:57.373162','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:46:36.091728','Các món ăn nhẹ thường được phục vụ trước bữa chính, chẳng hạn như salad, súp, hoặc các món chiên','3f8fe62d-d31a-4e6b-9766-128912a20a5b_4465282.png','Món Khai Vị'),('a5c05607-4e78-40ee-be47-21eda0741232','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:46:39.680425','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:46:39.680425','Các món ăn từ các nền văn hóa khác nhau, chẳng hạn như món ăn Trung Quốc, Nhật Bản, Hàn Quốc, hoặc Ấn Độ',NULL,'Ẩm Thực Quốc Tế'),('a5ee0118-16e1-481e-b1fc-6a6ddeb08a5c','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:02:01.771707','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:02:01.771707','Danh mục kết hợp giữa lẩu và đồ nướng, cho phép thực khách thưởng thức cả hai.',NULL,'Lẩu Đồ Nướng'),('b189bcbb-8e0e-4ec5-8482-872b37e618f5','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:01:32.447899','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:01:32.447899','Danh mục dành cho các loại lẩu hải sản tươi ngon, bao gồm tôm, cá, và mực.',NULL,'Lẩu Hải Sản'),('b6237f8c-bca6-4c0b-ba89-7e922a0e26b8','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:44:49.215214','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:51:43.216173','Nước giải khát, rượu, cocktail, trà và cà phê.','5d6b83c9-e95d-4444-b0a6-cfe57de6543b_6190582.png','Đồ Uống'),('b66ac07a-a59f-4a22-bd96-29373b4e543a','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:45:43.888013','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:53:39.488453','Các món ăn đặc biệt theo mùa hoặc theo ngày, thường được thay đổi thường xuyên','114e8b78-91a0-46dd-8efa-aac4e951afb0_9418698.png','Món Đặc Biệt'),('bcf417ba-4280-48a1-8e0f-76ec620eb239','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:01:54.307703','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:01:54.307703','Danh mục cho các món lẩu nấm, sử dụng nhiều loại nấm tươi ngon.',NULL,'Lẩu Nấm'),('c2e78dc3-ff30-401e-b556-27f809fbcd1f','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:46:07.381368','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:55:30.454044','Các món ăn dành cho trẻ em, như pizza nhỏ, bánh mì kẹp, hoặc món tráng miệng.','7798cb25-f850-4858-bb3f-8d33bba13ec9_baby.png','Thực Đơn Trẻ Em'),('d879f89d-97bd-46ea-9368-f3dc6a2a6a7e','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:45:14.910602','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:59:16.689755','Các loại salad khác nhau, có thể là salad rau xanh, salad trái cây, hoặc salad mì.','8536068e-cab2-4158-be0f-55da641bc4cc_2515183.png','Salad'),('e3c6cccf-add7-4495-9953-64f8d4403c1a','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:06:34.391034','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:07:12.352720','Cơm chiên thường được phục vụ nóng và có thể kèm theo các món ăn khác như dưa chua, salad hoặc nước sốt','fdec21b7-4ae5-4442-a3f6-b28d5d2ad104_fried-rice.png','Cơm chiên'),('e6879e39-b1be-46c0-8a3a-d687badaacde','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:43:38.277807','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:43:38.278815','Các món ăn ngọt phục vụ sau bữa chính, như bánh ngọt, kem, hoặc trái cây.',NULL,'Món Tráng Miệng');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dishes`
--

DROP TABLE IF EXISTS `dishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dishes` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_free_ship` bit(1) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `time_ship` varchar(255) DEFAULT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKg9v3f8f18je2t2ou8fvwse3kq` (`name`),
  KEY `FKgbu6erefir17660qutbbjnma7` (`category_id`),
  CONSTRAINT `FKgbu6erefir17660qutbbjnma7` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishes`
--

LOCK TABLES `dishes` WRITE;
/*!40000 ALTER TABLE `dishes` DISABLE KEYS */;
INSERT INTO `dishes` VALUES ('64768584-e4d1-4b8f-9fd9-a149483c1aac','Sườn bò hoặc sườn heo nướng sốt xì dầu ngọt mặn.','937f9a0d-678a-4918-967b-0e9a06c1f90c_quan-thit-suon-nuong-seoul.jpg',NULL,'Sườn bò nướng Hàn Quốc',30.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 02:56:25.617938'),('95601ce6-987c-11ef-9798-0242ac110002','Súp gà thơm ngon với gia vị đặc trưng.','b671ee30-4d6c-44f9-b728-5e5670e07f13_Thanh-pham-3-3-8670-1650018610.jpg',_binary '','Súp gà',25.00,NULL,'0b7d2b17-7f0e-4423-aa2f-c73872b90cf8',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 03:05:26.612475'),('9563fc61-987c-11ef-9798-0242ac110002','Súp nấm tươi ngon, phù hợp cho bữa ăn nhẹ.','sup-nam-hai-san-chua-cay-500 (1).jpg',_binary '','Súp nấm',20.00,NULL,'0b7d2b17-7f0e-4423-aa2f-c73872b90cf8',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000'),('9564083a-987c-11ef-9798-0242ac110002','Súp bí đỏ ngọt ngào và bổ dưỡng.','cach-lam-sup-bi-do-kem-tuoi-beo-ngay-chuan-vi-au-tai-nha-202208251727590660.jpg',_binary '','Súp bí đỏ',30.00,NULL,'0b7d2b17-7f0e-4423-aa2f-c73872b90cf8',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000'),('95640f46-987c-11ef-9798-0242ac110002','Súp hải sản tươi sống với các loại hải sản.','sup-bap-cua.jpg',_binary '','Súp hải sản',35.00,NULL,'0b7d2b17-7f0e-4423-aa2f-c73872b90cf8',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000'),('956411dc-987c-11ef-9798-0242ac110002','Súp miso truyền thống của Nhật Bản.','GL.jpg',_binary '','Súp miso',15.00,NULL,'0b7d2b17-7f0e-4423-aa2f-c73872b90cf8',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:10:32.000000'),('a5219fb8-987b-11ef-9798-0242ac110002','Thịt nướng BBQ kiểu Mỹ với nước sốt đậm đà','thit-ba-chi-bo-my.jpg',_binary '','Thịt nướng BBQ Mỹ',18.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a52383ef-987b-11ef-9798-0242ac110002','Thịt xiên nướng với gia vị, tỏi, và sả','2-cach-lam-thit-xien-nuong-cuc-ngon-voi-avt-1200x676.jpg',_binary '\0','Thịt xiên nướng',4.50,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a523a6a9-987b-11ef-9798-0242ac110002','Thịt bò nướng tẩm ướp xì dầu, tỏi, gừng','Bulgogi2.png',_binary '','Bulgogi Hàn Quốc',12.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a523a9eb-987b-11ef-9798-0242ac110002','Sườn bò nướng Hàn Quốc. Sườn bò nướng sốt xì dầu ngọt mặn','k_Photo_Recipes_2023-10-galbi_galbi-216.jpg',_binary '','Galbi',25.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a523aaf5-987b-11ef-9798-0242ac110002','Xiên gà nướng với sốt tare Nhật Bản','images.jpg',_binary '\0','Yakitori Nhật Bản',3.50,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a523abf1-987b-11ef-9798-0242ac110002','Thịt lợn ướp ngũ vị hương và mật ong','thit-nuong-ngu-vi-01-1638850696.jpg',_binary '','Thịt nướng ngũ vị Việt Nam',9.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a523b08d-987b-11ef-9798-0242ac110002','Thịt heo nướng với lá mắc mật thơm','thit-lon-nuong-la-moc-amt.jpg',_binary '\0','Thịt heo nướng lá mắc mật',12.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a523b1a7-987b-11ef-9798-0242ac110002','Thịt nướng Đông Nam Á. Xiên thịt nướng với sốt đậu phộng','Chicken-Satay.jpg',_binary '','Satay ',6.50,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a523b261-987b-11ef-9798-0242ac110002','Sườn heo nướng với muối ớt cay','suon-nuong-001-20221130.jpg',_binary '\0','Sườn nướng muối ớt',15.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('a523b321-987b-11ef-9798-0242ac110002','Thịt bò nướng nguyên tảng lớn','bo-nuong-tang-3.jpg',_binary '','Thịt bò nướng tảng',22.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 18:03:49.000000'),('b1d0c0f1-71e9-4524-9a65-280d772d4340','Thịt nướng BBQ kiểu Mỹ, thường dùng thịt sườn heo hoặc bò, với nước sốt BBQ đậm đà.','bo-nuong-bbq-1.jpg',NULL,'Thịt nướng BBQ',25.00,NULL,'04b64dfd-d02c-4447-b410-b4281f5ae998',_binary '',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_restaurants`
--

DROP TABLE IF EXISTS `menu_restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_restaurants` (
  `id` varchar(255) NOT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `restaurant_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4h6shuoa4ggeq4s618tfccy46` (`category_id`),
  KEY `FK8b26ws9nf0gla81930g7ha6xw` (`restaurant_id`),
  CONSTRAINT `FK4h6shuoa4ggeq4s618tfccy46` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `FK8b26ws9nf0gla81930g7ha6xw` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_restaurants`
--

LOCK TABLES `menu_restaurants` WRITE;
/*!40000 ALTER TABLE `menu_restaurants` DISABLE KEYS */;
INSERT INTO `menu_restaurants` VALUES ('99959847-98cf-11ef-a8dc-0242ac110002','04b64dfd-d02c-4447-b410-b4281f5ae998','2f486405-28bb-416f-9e9a-73333c1bf48f'),('99966146-98cf-11ef-a8dc-0242ac110002','04b64dfd-d02c-4447-b410-b4281f5ae998','4ab3eba6-19c2-41f8-932a-d8a0f48cc436'),('9996770a-98cf-11ef-a8dc-0242ac110002','04b64dfd-d02c-4447-b410-b4281f5ae998','5fd3aa8e-e64c-4881-90a1-22fa0d37d514'),('999678ca-98cf-11ef-a8dc-0242ac110002','04b64dfd-d02c-4447-b410-b4281f5ae998','edb94931-a52f-4b03-b901-1d63ca855e96'),('99967952-98cf-11ef-a8dc-0242ac110002','04b64dfd-d02c-4447-b410-b4281f5ae998','f5ef9792-022a-4ec0-afcd-f48d3a58e988'),('999679c7-98cf-11ef-a8dc-0242ac110002','04b64dfd-d02c-4447-b410-b4281f5ae998','f5ef9792-022a-4ec0-afcd-f48d3a58e988'),('99967a30-98cf-11ef-a8dc-0242ac110002','a5ee0118-16e1-481e-b1fc-6a6ddeb08a5c','5fd3aa8e-e64c-4881-90a1-22fa0d37d514'),('99967aa7-98cf-11ef-a8dc-0242ac110002','a5ee0118-16e1-481e-b1fc-6a6ddeb08a5c','edb94931-a52f-4b03-b901-1d63ca855e96'),('99967beb-98cf-11ef-a8dc-0242ac110002','a5ee0118-16e1-481e-b1fc-6a6ddeb08a5c','f5ef9792-022a-4ec0-afcd-f48d3a58e988'),('99967c78-98cf-11ef-a8dc-0242ac110002','b6237f8c-bca6-4c0b-ba89-7e922a0e26b8','f5ef9792-022a-4ec0-afcd-f48d3a58e988'),('99967da2-98cf-11ef-a8dc-0242ac110002','b6237f8c-bca6-4c0b-ba89-7e922a0e26b8','4ab3eba6-19c2-41f8-932a-d8a0f48cc436'),('99967e26-98cf-11ef-a8dc-0242ac110002','b6237f8c-bca6-4c0b-ba89-7e922a0e26b8','5fd3aa8e-e64c-4881-90a1-22fa0d37d514'),('99967e94-98cf-11ef-a8dc-0242ac110002','b6237f8c-bca6-4c0b-ba89-7e922a0e26b8','edb94931-a52f-4b03-b901-1d63ca855e96');
/*!40000 ALTER TABLE `menu_restaurants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `price` decimal(38,2) NOT NULL,
  `quantity` bigint NOT NULL,
  `dish_id` varchar(255) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1f9qgvn9fugqkk40bxkgy6g7p` (`dish_id`),
  KEY `FKjyu2qbqt8gnvno9oe9j2s2ldk` (`order_id`),
  CONSTRAINT `FK1f9qgvn9fugqkk40bxkgy6g7p` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`id`),
  CONSTRAINT `FKjyu2qbqt8gnvno9oe9j2s2ldk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `restaurant_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKagh5svlor3slbay6tq5wqor1o` (`account_id`),
  KEY `FK2m9qulf12xm537bku3jnrrbup` (`restaurant_id`),
  CONSTRAINT `FK2m9qulf12xm537bku3jnrrbup` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`),
  CONSTRAINT `FKagh5svlor3slbay6tq5wqor1o` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profiles`
--

DROP TABLE IF EXISTS `profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profiles` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `data_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(100) NOT NULL,
  `gender` bit(1) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKlnk8iosvsrn5614xw3lgnybgk` (`email`),
  CONSTRAINT `FKph94xatq3eb421xema3y7p7b8` FOREIGN KEY (`id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles`
--

LOCK TABLES `profiles` WRITE;
/*!40000 ALTER TABLE `profiles` DISABLE KEYS */;
INSERT INTO `profiles` VALUES ('347d00fa-8899-4a58-986a-519169c2ac5e','Tân Thành - Vụ Bản - Nam Định','b400a9fa-8842-4e8c-8c68-a9682db64668_Tư duy.png','2024-10-31',NULL,'Nguyễn Văn Hưng',_binary '',NULL,NULL,NULL,NULL),('3880bc26-cc66-42d3-b22d-d63fe1699c98','Thành phố Thái Bình',NULL,'2024-11-01',NULL,'Nguyễn Hương Giang',_binary '\0',NULL,NULL,NULL,NULL),('88066095-3cf5-4b61-a884-28955eaae5b3','Thành phố Thái Bình',NULL,'2024-10-31',NULL,'Nguyễn Hương Giang',_binary '\0',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promos`
--

DROP TABLE IF EXISTS `promos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promos` (
  `id` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount` decimal(38,2) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `restaurant_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8ph6ycfbv7bv2phf3lgtykico` (`code`),
  KEY `FKc68qc2yuwtf89171mjeepi89l` (`restaurant_id`),
  CONSTRAINT `FKc68qc2yuwtf89171mjeepi89l` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promos`
--

LOCK TABLES `promos` WRITE;
/*!40000 ALTER TABLE `promos` DISABLE KEYS */;
/*!40000 ALTER TABLE `promos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating_dishes`
--

DROP TABLE IF EXISTS `rating_dishes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating_dishes` (
  `id` varchar(255) NOT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `rating` decimal(38,2) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `dish_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt70rjq6b9d2fs5dydptyi5es5` (`account_id`),
  KEY `FK30wnd0m2tsk9j70nmtb5m9w1j` (`dish_id`),
  CONSTRAINT `FK30wnd0m2tsk9j70nmtb5m9w1j` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`id`),
  CONSTRAINT `FKt70rjq6b9d2fs5dydptyi5es5` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating_dishes`
--

LOCK TABLES `rating_dishes` WRITE;
/*!40000 ALTER TABLE `rating_dishes` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating_dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating_restaurants`
--

DROP TABLE IF EXISTS `rating_restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating_restaurants` (
  `id` varchar(255) NOT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `rating` decimal(38,2) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `restaurant_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg8nndxvbo0ifu8vo8gv1ru7p2` (`account_id`),
  KEY `FKw23adt5sxrracgyuul8gj8ey` (`restaurant_id`),
  CONSTRAINT `FKg8nndxvbo0ifu8vo8gv1ru7p2` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  CONSTRAINT `FKw23adt5sxrracgyuul8gj8ey` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating_restaurants`
--

LOCK TABLES `rating_restaurants` WRITE;
/*!40000 ALTER TABLE `rating_restaurants` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating_restaurants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurants`
--

DROP TABLE IF EXISTS `restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurants` (
  `id` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `close_time` time(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `is_free_ship` bit(1) DEFAULT NULL,
  `open_time` time(6) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK649xu8el35c5um9x7q7pxkhx` (`address`),
  UNIQUE KEY `UKpm32sqdemjifotja5iqvaeqeg` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurants`
--

LOCK TABLES `restaurants` WRITE;
/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;
INSERT INTO `restaurants` VALUES ('20b3db47-9afa-45cb-adbc-7236229b1e92','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:54:07.245977','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 11:44:51.687048','50 Đường Hòa Mã, Hai Bà Trưng, Hà Nội','22:00:00.000000','Lẩu gà sả tắc, chua chua, cay cay, rất thơm ngon.','4150eac6-f7d9-43db-ade3-9c25ae4a1d15_x75gifdtwjyp1zid9y6w.jpg',_binary '',_binary '\0','10:00:00.000000','Lẩu với hương vị độc đáo','Lẩu Gà Sả Tắc',21.016391,105.846142),('2f486405-28bb-416f-9e9a-73333c1bf48f','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:23.439860','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:23.440418','20 Phố Trần Xuân Soạn, Hai Bà Trưng, Hà Nội','23:00:00.000000','BBQ với nhiều loại thịt nướng và sốt hấp dẫn.','King-BBQ.jpg',_binary '',_binary '','17:00:00.000000','Nướng kiểu Mỹ','Quán Nướng BBQ',20.99366,105.843),('4ab3eba6-19c2-41f8-932a-d8a0f48cc436','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:51.458648','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:51.458648','12 Trần Đăng Ninh, Cầu Giấy, Hà Nội','22:30:00.000000','Món nướng trên ngói giúp giữ nguyên hương vị của thực phẩm.','tong-hop-10-quan-do-nuong-han-quoc-noi-tieng-o-sai-gon-ma-ban-can-phai-biet-202108281532058402.jpeg',_binary '',_binary '','16:00:00.000000','Sự kết hợp hoàn hảo','Nướng Ngói Hàn Quốc',20.998194,105.788971),('5fd3aa8e-e64c-4881-90a1-22fa0d37d514','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:48:43.657766','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:48:43.658882','15 Đường Tôn Đức Thắng, Đống Đa, Hà Nội','22:00:00.000000','Kết hợp giữa lẩu và nướng với nguyên liệu tươi ngon.','886c9b75a1614af7aae0b0bcb8ac3b8f.jpg',_binary '',_binary '\0','11:00:00.000000','Món nướng và lẩu hấp dẫn','Lẩu Nướng Hàn Quốc',21.004506,105.835333),('ac7cc327-eb6f-413b-9416-a5cc106fb97f','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:56.308054','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:56.308054','45 Đường Xuân Diệu, Tây Hồ, Hà Nội','21:30:00.000000','Súp cá ngừ với nước dùng thơm ngon, đậm đà.','photo4jpg.jpg',_binary '',_binary '\0','10:00:00.000000','Súp đậm đà hương vị biển','Súp Cá Ngừ',21.060275,105.853485),('c609d2dd-3d97-48a3-a7a4-d15405226c2c','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:29.506015','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:29.506015','34 Lý Thường Kiệt, Hoàn Kiếm, Hà Nội','21:00:00.000000','Súp măng cua thơm ngon với hương vị truyền thống.','pngtree-asian-themed-restaurant-picture-image_2468253.jpg',_binary '',_binary '\0','09:00:00.000000','Súp đặc sản Hà Nội','Súp Măng Cua',21.022076,105.848978),('edb94931-a52f-4b03-b901-1d63ca855e96','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:39.804802','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:53:39.804802','200 Đường Hoàng Hoa Thám, Tây Hồ, Hà Nội','23:00:00.000000','Quán phục vụ lẩu và nướng với nguyên liệu sạch và tươi.','mo-hinh-kinh-doanh-quan-lau-nuong.jpg',_binary '',_binary '','11:00:00.000000','Đồ nướng tươi ngon','Quán Lẩu Nướng Nguyên Bảo',21.066174,105.842214),('f5ef9792-022a-4ec0-afcd-f48d3a58e988','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:54:13.488193','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 10:54:13.488193','88 Đường Ngọc Khánh, Ba Đình, Hà Nội','23:00:00.000000','Đồ nướng đa dạng với hương vị đặc trưng và không gian thoải mái.','z5284875433788_70b03ef30a03a9182677a6cd9650f2c0.jpg',_binary '',_binary '','17:00:00.000000','Món nướng thơm ngon','Quán Nướng Nướng Bống',21.023956,105.834925);
/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKch1113horj4qr56f91omojv8` (`code`),
  UNIQUE KEY `UKofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'CUSTOMER','Khách hàng'),(2,'EMPLOYEE','Nhân viên'),(3,'MANAGER','Quản lý'),(4,'IT_ADMIN','IT ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokens` (
  `id` varchar(255) NOT NULL,
  `expired` bit(1) NOT NULL,
  `expires_at` datetime(6) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `refresh_token_expires_at` datetime(6) DEFAULT NULL,
  `revoked` bit(1) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `token_type` varchar(255) DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkxd4xsavefdtlpkvnxpgojn6` (`account_id`),
  CONSTRAINT `FKkxd4xsavefdtlpkvnxpgojn6` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokens`
--

LOCK TABLES `tokens` WRITE;
/*!40000 ALTER TABLE `tokens` DISABLE KEYS */;
INSERT INTO `tokens` VALUES ('021a61aa-0d8c-4115-9f5d-37ebd4fe88fc',_binary '\0','2024-11-11 08:40:29.455979','511c2e9c-6105-4606-bb0b-3d7608593601','2024-11-25 08:40:29.455979',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ0MjksImV4cCI6MTczMTI4OTIyOX0.GyJiFgX6QYPeUdZBAMRLXFYuOyFKAdGonMGLTcxRJ4kJ0cOlprT1lr5odjRA1YMt','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('06110eb2-a570-4c8d-a202-fcaa6243b3d8',_binary '\0','2024-11-11 18:33:51.778331','cde9557f-b689-42ba-b880-d54496df1841','2024-11-25 18:33:51.778331',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA3MjAwMzEsImV4cCI6MTczMTMyNDgzMX0.rDV4vTmelz5VpGgZAdpZpFffJCQI-7vf1oDVjrzCqchIY_gspzbDJfIOwIAxTaia','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('064d0789-b77d-422f-bce4-b178cc0462b9',_binary '\0','2024-11-11 11:20:43.942050','43c2587f-cbba-45b9-a049-050ddeefaaaf','2024-11-25 11:20:43.942050',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQwNDMsImV4cCI6MTczMTI5ODg0M30.p3yYJGrU3sFXKIE_w3Fx3tDkivvlK9tAYndcXCyV6PeRYVl7RjwovWUApVXJfCDY','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('0ecf3ab0-71e2-4e99-8787-792b7747d87c',_binary '\0','2024-11-11 08:40:01.844493','928a6e37-789e-422d-8c52-f083e1fd5801','2024-11-25 08:40:01.844493',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ0MDEsImV4cCI6MTczMTI4OTIwMX0.GGjWw76jKaNbzmtGUBA0PalwlIJlBENaassps18n4i_YELNZvnW6pA8ttsMXiCV0','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('107a44de-f4c7-4055-ba07-852973c7fed7',_binary '\0','2024-11-11 11:20:40.637163','95a991f9-0d5c-426c-8d75-2b2d7f2f0ffc','2024-11-25 11:20:40.637163',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQwNDAsImV4cCI6MTczMTI5ODg0MH0.aC0b8p0-3Sr2VKfchK8p-lYrXk1N0ejbhRTPigGuSVwj0GEfbQGdNeX5Np88AzdI','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('1186cdd4-11aa-4330-960f-8c15152aa779',_binary '\0','2024-11-11 08:43:23.531911','ff796fbc-4e8f-4b10-a563-4be2ceda7a8b','2024-11-25 08:43:23.531911',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ2MDMsImV4cCI6MTczMTI4OTQwM30.0x8s7vrzV58j5GCcKYY8SFrnGQVnUyekm6lu6p719kaSvnDwWSu41-bG-tW9f2h9','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('1b23dcd9-a228-4901-8ff0-d1a8ab258a7c',_binary '\0','2024-11-11 11:20:45.580049','7324d18e-db85-4f8b-9ff3-e093039e8ff5','2024-11-25 11:20:45.580049',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQwNDUsImV4cCI6MTczMTI5ODg0NX0.439UCKF849KRIMJHbdje5Hq7fHsbTlirZWrVN7Ud2heBEfguNldvoh9hZiY_9vXF','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('1d2b725a-823a-4363-bfff-4fce42e62cff',_binary '\0','2024-11-11 08:41:14.411207','088bcced-57ad-41fd-b074-8d1089c0c3b8','2024-11-25 08:41:14.411207',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ0NzQsImV4cCI6MTczMTI4OTI3NH0.OXu79-P5ntZP6RLSc1WMNrE8xTLYfhsg-DFj-AbrrlSkdbPDrt85Kupu712jD_85','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('2230bbb7-b91b-44cd-8dea-efacaeb44561',_binary '\0','2024-11-11 08:42:56.539714','078b84e7-f93c-43cc-83bc-22b3adde063d','2024-11-25 08:42:56.539714',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ1NzYsImV4cCI6MTczMTI4OTM3Nn0.fXv5vv08UVUCaFELGNGgqH3Zzvxo9VcD5hSfhIgIWuu3TT27bepKKtkRDXp0uA0w','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('270f903c-3228-4d4d-877c-1ec8a7a058ae',_binary '\0','2024-11-11 08:42:28.767323','8b4e5102-8c52-47c0-9fbc-da5a8a9fdd88','2024-11-25 08:42:28.767323',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ1NDgsImV4cCI6MTczMTI4OTM0OH0.No9E52qBLlAw4zo9X_vKt0yciCrr5bTGnkeYaVRFWvux-3hhnMlRQG3DYLxLYGi3','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('3017a882-f243-4435-9756-04f686820c9f',_binary '\0','2024-11-11 08:40:36.234279','3910c53e-e579-4abb-bec3-4fc039ae4ea7','2024-11-25 08:40:36.234279',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ0MzYsImV4cCI6MTczMTI4OTIzNn0.IAIa0xkthbB0CA_Qj8Oz8lU144SZnfbbrSAj9FJ3jRIIQv0pFVLx3Vy_bqqpu-yj','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('357a4360-c672-4fb6-af5e-95a5c0399346',_binary '\0','2024-11-11 11:33:00.738430','f2ef098c-f41c-4b6c-b4da-ca54e489fc5f','2024-11-25 11:33:00.738430',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQ3ODAsImV4cCI6MTczMTI5OTU4MH0.oLe3b6MwGuaO55I0ivY2ECSaE_o93wVWFUEDjoV9jat_86JMnK1U9REoGKpX4YS0','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('369453bf-b377-4731-b8e9-eae78861fbcd',_binary '\0','2024-11-11 11:34:52.209924','d651eda9-d4d9-4459-b5ed-fda2caf13ad5','2024-11-25 11:34:52.209924',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI4ODA2NjA5NS0zY2Y1LTRiNjEtYTg4NC0yODk1NWVhYWU1YjMiLCJpYXQiOjE3MzA2OTQ4OTIsImV4cCI6MTczMTI5OTY5Mn0.Oi_Qtwz0wbiKKiphvXQB5NMEJ-z_QemLvn21Plx3OsdjDoWHitglSsjUFxZHEP7u','Bearer','88066095-3cf5-4b61-a884-28955eaae5b3'),('37b032f0-c4ee-48f1-bae2-1750122a6c3b',_binary '\0','2024-11-11 11:35:24.217381','61db8d94-9212-4a67-b485-be23cb2518ce','2024-11-25 11:35:24.217381',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI4ODA2NjA5NS0zY2Y1LTRiNjEtYTg4NC0yODk1NWVhYWU1YjMiLCJpYXQiOjE3MzA2OTQ5MjQsImV4cCI6MTczMTI5OTcyNH0.4MRw78gseZ0Ec-7xvjOspWCtjDHP3eBdn5yS2aKEq7ZJ35n_Hxd_JPAm59LudlPT','Bearer','88066095-3cf5-4b61-a884-28955eaae5b3'),('37d9db18-674b-4bb0-bb50-07e3f4ee2bf9',_binary '\0','2024-11-11 11:26:19.355399','67b085a6-f8f5-4ebd-b24b-2cdcffd459a9','2024-11-25 11:26:19.355399',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQzNzksImV4cCI6MTczMTI5OTE3OX0.6bYOtYVd7Nf_MFaVwXOTPGXqj_bTgiIXW-j5hsBax7sLCb_SjkAGoy0thG0_A324','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('3b18dbe3-44dd-4704-8dff-54cc91bce424',_binary '\0','2024-11-11 11:24:48.462604','4e8cbb90-66f1-4dce-89a5-c51ac36ea7ac','2024-11-25 11:24:48.462604',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQyODgsImV4cCI6MTczMTI5OTA4OH0.zEytvDkVH2rMq4xjMMaV7T9d4m8PGacRgBPIq6gNlfn78k0WQ1g6JYS6eU4zbe5v','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('3cf92e23-5aea-4da7-b244-8a19529c4306',_binary '\0','2024-11-11 08:35:11.573615','347f1b43-8692-4db6-83d4-80636ae2e460','2024-11-25 08:35:11.573615',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQxMTEsImV4cCI6MTczMTI4ODkxMX0.C9LOFZbUb0qSHujUOoc2CIvrEty-KCzGtzaDHCM0ft6axbqx1Oqq2fTsB_hTlOqq','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('4a108494-54ed-4061-935a-759a0b7e443d',_binary '\0','2024-11-11 11:35:19.487412','d1d16120-7a38-4edb-8a92-2f2e7b285a23','2024-11-25 11:35:19.487412',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI4ODA2NjA5NS0zY2Y1LTRiNjEtYTg4NC0yODk1NWVhYWU1YjMiLCJpYXQiOjE3MzA2OTQ5MTksImV4cCI6MTczMTI5OTcxOX0.QR41JWwITeeV1sEH2N4mNlqCVFCRbhhvM1cXey1SsMWGN0aFSUAylugvr5U60NqS','Bearer','88066095-3cf5-4b61-a884-28955eaae5b3'),('5e4ddb8e-fc95-4428-b9af-964d5d5d9b16',_binary '\0','2024-11-11 11:26:40.708020','bf3d86f6-3ae8-4294-8f2f-e0e7c9ec406d','2024-11-25 11:26:40.708020',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQ0MDAsImV4cCI6MTczMTI5OTIwMH0.5MNkk9n1MRHZc6rEDN6p59BknMeZeLz7SEnKIt6BEr1PSCpGUmPva5QLdoaKHapy','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('5f0a98dd-2fac-4a32-a822-b424aded57a2',_binary '\0','2024-11-11 11:24:44.542938','b7d58f2f-2bec-4dc9-889c-def905386d1f','2024-11-25 11:24:44.542938',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQyODQsImV4cCI6MTczMTI5OTA4NH0.naP-6e8oygEy5AJk3TvsGcXp6GbaLp8mGQ4O5MKSKLfyJL5nwViHilhmhGElCh9o','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('5f6ace92-c22c-46a8-9d12-3df7fcb93d84',_binary '\0','2024-11-11 11:34:00.532463','b9cb5c45-d25e-4445-bf5b-1a6acca67546','2024-11-25 11:34:00.532463',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI4ODA2NjA5NS0zY2Y1LTRiNjEtYTg4NC0yODk1NWVhYWU1YjMiLCJpYXQiOjE3MzA2OTQ4NDAsImV4cCI6MTczMTI5OTY0MH0.igtryV1v8SHnk018S65d11Ab0OwbQATbfCdYpmI2b0Q5Lug_IBV13ziCaT6dn0XR','Bearer','88066095-3cf5-4b61-a884-28955eaae5b3'),('601d641f-69a0-49ec-a5f5-31d31c111ec7',_binary '\0','2024-11-11 11:34:57.894155','9703fc65-c322-4100-9706-89db6266fbc8','2024-11-25 11:34:57.894155',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI4ODA2NjA5NS0zY2Y1LTRiNjEtYTg4NC0yODk1NWVhYWU1YjMiLCJpYXQiOjE3MzA2OTQ4OTcsImV4cCI6MTczMTI5OTY5N30.SHX2-sbVbZ-F_8rWHtuaxXxBqP9f-h1OwA2nYq-OSOGRiGqt9sqpJDDElbLvnZYQ','Bearer','88066095-3cf5-4b61-a884-28955eaae5b3'),('6c08376f-a65d-4b8e-b386-8aa24b2d0374',_binary '\0','2024-11-11 11:20:49.702152','81f40a9f-ddf1-4b29-8684-a969631f1b34','2024-11-25 11:20:49.702152',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQwNDksImV4cCI6MTczMTI5ODg0OX0.b4dkqh6k_xiVIbSD83ZpfGGVKd4m4t3hxSSdEYBDGu1vZpK_KEwtdRM9USSq_ETN','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('7363ed9c-e357-4a1b-aae6-3604b8c94670',_binary '\0','2024-11-11 11:19:44.384571','9c9ff891-364a-4971-869f-d081d0cd3b53','2024-11-25 11:19:44.384571',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTM5ODQsImV4cCI6MTczMTI5ODc4NH0.hCXc_j9RIH4b3te5Bfo51O8mC4ojUxNGDISyZT5KLuC6G1koonDQjGWsuVDAaqZl','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('83c0df97-59d7-4c6c-aae1-d738db1282c4',_binary '\0','2024-11-11 08:42:19.029071','9b9e8691-279b-4b4e-a9f4-f0c2f882313d','2024-11-25 08:42:19.029071',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ1MzksImV4cCI6MTczMTI4OTMzOX0.w4zWCDCLdiquIQbvEsiMN9USiHG0SfASnopvJVMAfRIU4KOCsgDBjDYuU5q4_vy1','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('92c0bf5f-d23f-40e8-981e-2de9ae36ff26',_binary '\0','2024-11-11 11:21:47.242625','40243bd0-17eb-406c-a6f6-53d319a6ce54','2024-11-25 11:21:47.242625',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQxMDcsImV4cCI6MTczMTI5ODkwN30.uMPvumTxwZ7lzIt232_Sb6I4BqbaffMSg-xMUpJ6RHWsY_wZM91r1cHEQuR_zcos','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('9ec102a6-a4ee-4f97-8dba-ac1256abc148',_binary '\0','2024-11-11 11:20:32.832322','d8d6d41f-3d24-4191-9215-6a2460c539e3','2024-11-25 11:20:32.832322',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQwMzIsImV4cCI6MTczMTI5ODgzMn0.G78yRHbkfJDF9sxnHKSGp2-eSwuK2P00O-IiCM1Nt6LigReQy-xKI2xwDOxXBmsb','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('a05152e0-9c80-446d-8dff-1a89899a05cf',_binary '\0','2024-11-11 08:40:09.297408','471fa3f0-c56e-404a-810c-8761041c281d','2024-11-25 08:40:09.297408',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ0MDksImV4cCI6MTczMTI4OTIwOX0.PZXQMtfgRwfbrZEhzQ2aNF57YOHEweFKdoJUipnfIf0USe8MQVBi1_zh47GzC0ce','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('a0ca86ab-33a3-4e02-98f3-a7432d0234ce',_binary '\0','2024-11-11 08:41:12.332325','4c2bbb92-38c9-49a6-ab54-8f130c9fc06d','2024-11-25 08:41:12.332878',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ0NzIsImV4cCI6MTczMTI4OTI3Mn0.-46WTr6Tha51a4I3wvEIIamq1nToezOrExqeuoFy_yE0d5HuOL52ccRr39cYCZUq','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('a79c17c0-834b-47d2-ae95-9d54ae90485f',_binary '\0','2024-11-11 08:41:27.122165','b423744f-416f-4e96-8d7e-2300470a0a28','2024-11-25 08:41:27.122165',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ0ODcsImV4cCI6MTczMTI4OTI4N30.e6irJp_iFoBZrycLk_ZNMFYSX8Kl5P7Vy-KfyBeYMjfopipONFGSfhSmMG4hdOcp','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('a7d94567-7213-40c8-8e0d-73d8e2b4b648',_binary '\0','2024-11-11 14:42:01.429923','07dedc02-96ec-4bcf-a253-b568cf706022','2024-11-25 14:42:01.429923',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA3MDYxMjEsImV4cCI6MTczMTMxMDkyMX0.fwbQojECSK0ApuJzITunjW5xdYhgHxvNOCOqRKDLGKzJcW6D_tLsItjrFOollHlh','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('af75bb76-f953-406d-8927-25644275f420',_binary '\0','2024-11-11 08:36:20.926089','94c34a9e-d05e-48e1-a567-66f0d2ffc630','2024-11-25 08:36:20.927183',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQxODAsImV4cCI6MTczMTI4ODk4MH0.VALERJTjezQWmFHcYodrLmFlruTeHkLilbJgp0Oej8VoSsmWHev040v9-Y8MME26','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('b4bdd177-eba2-45b9-ae60-d7a0569653c7',_binary '\0','2024-11-11 08:42:51.798888','18a6bc34-7816-47e8-bf5b-7bcf310f1576','2024-11-25 08:42:51.798888',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ1NzEsImV4cCI6MTczMTI4OTM3MX0.pC2euTgsDHWch68Hb6TT0bs0-MGKzKceCYgvjQhAob2rh1lHHlLFAHDxci4i6gEg','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('cc79e4a4-5370-4f3a-bed5-1f10526fe1fa',_binary '\0','2024-11-11 08:36:51.868383','0ff851e7-793a-45d9-b12e-e9c1998e0656','2024-11-25 08:36:51.868383',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQyMTEsImV4cCI6MTczMTI4OTAxMX0.PqU4CH0oI-Ndh_0Mr_US2p8THQ4m1Teh3E13viThBIrBuNVNqoHHs4wO5FTThFiX','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('d39fb73a-4349-453e-9a77-021248ac6189',_binary '\0','2024-11-11 08:43:14.133919','969dcfcb-4f37-44b9-a900-151c56b106c5','2024-11-25 08:43:14.133919',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ1OTQsImV4cCI6MTczMTI4OTM5NH0.J9SA1iFhevcC0caLf3Nvuf-NCv7xBTQ8qQYDmebbzEdAVf1LZzaRTp1MuWA8hiNS','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('ddab0af7-5bfb-4d14-9381-9a1c3580cc14',_binary '\0','2024-11-11 08:43:17.941157','5e45907b-faec-4b36-aff3-0b55d03ddb53','2024-11-25 08:43:17.941157',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ1OTcsImV4cCI6MTczMTI4OTM5N30.Q5epSTjMcES0ukaVqFsbyU3G3NP9YNw5_HcWLAABvwdeJsDR-wDwbZODt7EZUlEk','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('e6dc3c9a-8529-4561-b21a-499b31f88147',_binary '\0','2024-11-11 08:43:36.029314','4507ed8d-5cff-4a96-aaaf-9d17a848ddda','2024-11-25 08:43:36.029314',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ2MTYsImV4cCI6MTczMTI4OTQxNn0.vHVJTvmLO9QekwD3UujdPVMIRUBy9d6mqcg2jrinRb_iADHrBLSiMau0aFtKhaxT','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('ee214c6f-f312-487e-917d-ef8261af3752',_binary '\0','2024-11-11 08:40:10.946506','94b2d0b0-1f51-44f8-a882-3370fec73dbd','2024-11-25 08:40:10.946506',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ0MTAsImV4cCI6MTczMTI4OTIxMH0.mN7EQUNg07Ls4ID_2TO-QwaM9u7LjNF0BhNEq5JrHH70LDN5MbXR3wbrNCCPt5zq','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('efde9d05-61f4-4652-a5b5-81aea42b5fe8',_binary '\0','2024-11-11 11:20:09.545886','5b2de636-7f75-4beb-8709-e87f6581b09b','2024-11-25 11:20:09.545886',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2OTQwMDksImV4cCI6MTczMTI5ODgwOX0.GszX4ecFRKBCWYASE560-4uHv2olAE3OzEec7sQ_md-ycCq9PHxSC6lI-S6kzxw9','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('ff6ecf10-a090-4be1-8bb9-47570e689261',_binary '\0','2024-11-11 08:43:08.995451','be917f9b-0566-4007-96de-8271aa6aab6a','2024-11-25 08:43:08.995451',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA2ODQ1ODgsImV4cCI6MTczMTI4OTM4OH0.BM7Xb0Nx1_83ZkLzLK4MQ5OZy2zQTr70He6BpY3ObkgBWgelkmBM6XAVMqMpF71K','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e');
/*!40000 ALTER TABLE `tokens` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-05 12:58:30
