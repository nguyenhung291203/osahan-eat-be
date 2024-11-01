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
INSERT INTO `categories` VALUES ('04b64dfd-d02c-4447-b410-b4281f5ae998','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:02:45.010826','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:04:57.114225','Các món thịt nướng thường được ướp gia vị và nướng trên lửa trực tiếp hoặc than hoa để tạo ra hương vị thơm ngon đặc trưng','480ff1b9-b669-4e4c-8b09-e316024c1ebd_barbecue.png','Thịt nướng'),('0b7d2b17-7f0e-4423-aa2f-c73872b90cf8','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:45:30.124176','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:17:21.870168','Các loại súp nóng hoặc lạnh, như súp gà, súp rau củ, hoặc súp hải sản','e92a4a30-903d-4857-8970-63d5f7ca87d3_9296635.png','Súp'),('45095590-e4f0-4837-855b-66048a95d64b','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:08:17.491281','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:24:40.255190','Phở là một trong những món ăn đặc trưng và nổi tiếng nhất của ẩm thực Việt Nam','a1b3a824-84dc-4a9a-b7ec-890ba00572b4_ramen.png','Phở'),('5b923767-b769-46cb-9cc0-4ae379fedbbf','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:46:23.115912','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:44:16.370477','Các món ăn phụ như khoai tây chiên, cơm, hoặc rau xào','e33a6e74-c6d7-4e4d-94fd-a1ccaf0e903b_6571044.png','Món Phụ'),('7ac12914-c253-49b5-8871-12a8ac440685','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:00:10.705551','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:01:14.032514','Mì sợi là một thực phẩm thường dùng trong nhiều nền văn hóa làm từ bột không men','69d5895f-b17e-4d6c-9b30-e19062a69fab_8775447.png','Mì sợi'),('86bab1aa-51ff-4a1b-b5e9-349c5386bcdb','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:28:57.373162','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:46:36.091728','Các món ăn nhẹ thường được phục vụ trước bữa chính, chẳng hạn như salad, súp, hoặc các món chiên','3f8fe62d-d31a-4e6b-9766-128912a20a5b_4465282.png','Món Khai Vị'),('a5c05607-4e78-40ee-be47-21eda0741232','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:46:39.680425','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:46:39.680425','Các món ăn từ các nền văn hóa khác nhau, chẳng hạn như món ăn Trung Quốc, Nhật Bản, Hàn Quốc, hoặc Ấn Độ',NULL,'Ẩm Thực Quốc Tế'),('b6237f8c-bca6-4c0b-ba89-7e922a0e26b8','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:44:49.215214','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:51:43.216173','Nước giải khát, rượu, cocktail, trà và cà phê.','5d6b83c9-e95d-4444-b0a6-cfe57de6543b_6190582.png','Đồ Uống'),('b66ac07a-a59f-4a22-bd96-29373b4e543a','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:45:43.888013','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:53:39.488453','Các món ăn đặc biệt theo mùa hoặc theo ngày, thường được thay đổi thường xuyên','114e8b78-91a0-46dd-8efa-aac4e951afb0_9418698.png','Món Đặc Biệt'),('c2e78dc3-ff30-401e-b556-27f809fbcd1f','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:46:07.381368','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:55:30.454044','Các món ăn dành cho trẻ em, như pizza nhỏ, bánh mì kẹp, hoặc món tráng miệng.','7798cb25-f850-4858-bb3f-8d33bba13ec9_baby.png','Thực Đơn Trẻ Em'),('d879f89d-97bd-46ea-9368-f3dc6a2a6a7e','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:45:14.910602','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 23:59:16.689755','Các loại salad khác nhau, có thể là salad rau xanh, salad trái cây, hoặc salad mì.','8536068e-cab2-4158-be0f-55da641bc4cc_2515183.png','Salad'),('e3c6cccf-add7-4495-9953-64f8d4403c1a','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:06:34.391034','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-02 00:07:12.352720','Cơm chiên thường được phục vụ nóng và có thể kèm theo các món ăn khác như dưa chua, salad hoặc nước sốt','fdec21b7-4ae5-4442-a3f6-b28d5d2ad104_fried-rice.png','Cơm chiên'),('e6879e39-b1be-46c0-8a3a-d687badaacde','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:43:38.277807','347d00fa-8899-4a58-986a-519169c2ac5e','2024-11-01 16:43:38.278815','Các món ăn ngọt phục vụ sau bữa chính, như bánh ngọt, kem, hoặc trái cây.',NULL,'Món Tráng Miệng');
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
INSERT INTO `tokens` VALUES ('0df9e867-2bd3-4db6-bd86-c8738b8f9838',_binary '\0','2024-11-08 23:17:18.576333','5ebd02fb-abad-47f1-904c-37f8a5b6dfc8','2024-11-22 23:17:18.576333',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA0Nzc4MzgsImV4cCI6MTczMTA4MjYzOH0.y-8-z3Rj1X5t1x2Z2wjdOFY3abKENPUzYlfHKg230EDMVbNDF1oOp9slBx7tE4fe','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('15052d1b-c2a8-477d-a106-b3f71f8fbdaa',_binary '\0','2024-11-07 10:58:50.854054','969cee8e-a5f9-45dd-81ce-06d412e06872','2024-11-21 10:58:50.854054',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI4ODA2NjA5NS0zY2Y1LTRiNjEtYTg4NC0yODk1NWVhYWU1YjMiLCJpYXQiOjE3MzAzNDcxMzAsImV4cCI6MTczMDk1MTkzMH0.E9YvdpRFnDtyEnK4yRr1N5jDbn-raOvNIId1jvj80dbuA-lp7ga5YPLlpoZh1A4Q','Bearer','88066095-3cf5-4b61-a884-28955eaae5b3'),('1816c76c-8af3-4728-813a-312c775c92b4',_binary '','2024-11-08 23:00:48.894222','3bd45044-ce53-427c-bbb2-6ed85b97cb02','2024-11-22 23:00:48.894222',_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA0NzY4NDgsImV4cCI6MTczMTA4MTY0OH0.uWFiEmjJeY1j6E1LhoGTwIajedBfzbr5YGiJV2PQPE8x7DIr57Wjhml8_ICjC7F7','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('1e712d18-8076-4fd5-a006-9b03ae76b974',_binary '\0','2024-11-07 11:56:04.579301','4d106c22-c651-4bbd-ae7f-39a8644d0f64','2024-11-21 11:56:04.579301',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA1NjQsImV4cCI6MTczMDk1NTM2NH0.4RWbebbh4dP5ZIAclXjjZY1SN2beZUijphtPhGgGUKRDUL_ufeaLV1DCJyjSDKc6','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('1f17e781-8679-48c4-9fcb-3c66fd6013a2',_binary '\0','2024-11-07 11:48:37.730698','bcdea229-f917-4630-921e-580a6cecd901','2024-11-21 11:48:37.730698',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTAxMTcsImV4cCI6MTczMDk1NDkxN30.MEWKaYMyU5n1XzJ2p5tDDMexRje-4p8J-jCnnqZ6OMAhpq1jAGiB6x64i-iwAl8G','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('22f38910-040c-49d9-bd66-f6f6fc359f5d',_binary '\0','2024-11-07 11:40:51.924206','3a1341f4-5f02-4c38-b0dc-c1e3e3597ca4','2024-11-21 11:40:51.924206',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNDk2NTEsImV4cCI6MTczMDk1NDQ1MX0.poFvKRBa535bv-diz9N3jcW27n2tm89Xhmhyudbd84z2vuUYhXQo-Ws9IN3FuuU2','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('2b6abe4c-bd48-448d-980d-baded46a614e',_binary '\0','2024-11-07 11:47:26.720947','5a7c1e9c-9c67-4d24-927b-70bd1ffea2bb','2024-11-21 11:47:26.720947',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTAwNDYsImV4cCI6MTczMDk1NDg0Nn0.G_WhSdEOg05-Pd_XvLCrIHCS4aJUgazjh8xQAEEDNimps0CYucIfJiOacfBc5Goi','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('2b7a8fb8-e191-4cd5-9c33-48ff9d0424fd',_binary '\0','2024-11-07 14:37:41.412912','d71382a2-4d56-4773-87e3-8a4383645fdd','2024-11-21 14:37:41.412912',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNjAyNjEsImV4cCI6MTczMDk2NTA2MX0.nU9E0LdGEjpfraLl9PPDhezScABT7T8lbZRF5r4GFbVdxVs9BA_Rd7faxKB-R3LJ','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('2e1727bd-6fa8-4d5a-abe5-64a9698a9a56',_binary '\0','2024-11-07 11:47:04.491052','6b302973-ef6b-4a5d-ada5-845c07b9334b','2024-11-21 11:47:04.491052',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTAwMjQsImV4cCI6MTczMDk1NDgyNH0.izuDx5rHcRmUcjT0KQ7UBRucWJDXtwev8M61pdY9mtP2vnG3q9W9Xw8ND523-Ch9','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('4632eb0c-b743-466a-bf80-eeaa9234e06f',_binary '\0','2024-11-07 10:56:54.842155','8002e3d8-70c3-4a5d-8702-4f7dbbb3caf8','2024-11-21 10:56:54.842155',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI4ODA2NjA5NS0zY2Y1LTRiNjEtYTg4NC0yODk1NWVhYWU1YjMiLCJpYXQiOjE3MzAzNDcwMTQsImV4cCI6MTczMDk1MTgxNH0.ocaUoCPuK9t9ClTC6-nvRmq0Ns-7ro9mfbNsOYgih6WrTF_PP0EBJZ-TrzQhWWvc','Bearer','88066095-3cf5-4b61-a884-28955eaae5b3'),('4dc4ff3c-07d6-4377-99bd-8bee1b2611de',_binary '\0','2024-11-07 11:59:15.809171','55ae0b59-7633-4e1d-bd86-5cbc5e037cee','2024-11-21 11:59:15.809171',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA3NTUsImV4cCI6MTczMDk1NTU1NX0.mGoEjXOhy2OD4brGcHZqE7icZjRInmaikKUSXVjJxQ9nm7SgO5jWF99KzApiG-3B','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('57eb392a-d15b-4536-bae7-e82b2a0ac96e',_binary '','2024-11-08 22:54:35.617936','14c64a83-2348-48e2-95bf-d9ecac15ae3a','2024-11-22 22:54:35.617936',_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA0NzY0NzUsImV4cCI6MTczMTA4MTI3NX0.sSNjBUsLB19wecDT71FtALiduma2LWl-7nvbevIu6lTBeLWYC-HQvbmNZv4rO071','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('6d1c993e-d804-46b5-8888-a53bdd020ab3',_binary '\0','2024-11-07 13:50:13.212297','72cd1995-f85d-4ee4-b203-e41afcaa7deb','2024-11-21 13:50:13.212297',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTc0MTMsImV4cCI6MTczMDk2MjIxM30.S6xkftuigwaOOgNQqMZEsYIJn7NlZtPSCHa0HfbTUmx23mWzNRSHwsVfSBd2DjUQ','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('749ed338-ef76-4be2-8b52-f4a35f628917',_binary '\0','2024-11-07 11:55:51.225268','3e9c324b-5e55-4fc0-a424-47d3a5bbd11b','2024-11-21 11:55:51.225268',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA1NTEsImV4cCI6MTczMDk1NTM1MX0.ATV97TBR5Lf8XR1q9Qmsb7Y3No7edmKcPwm86n4ogook0Yw56ox1KqVjiY6ND-17','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('76a3d9ad-16fe-4899-a123-bb6a22d47b40',_binary '\0','2024-11-07 11:39:50.354070','b44ac98f-74f4-489a-933d-df91842a81a5','2024-11-21 11:39:50.354070',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNDk1OTAsImV4cCI6MTczMDk1NDM5MH0.dTVLBzdYA4PR1hRac4mVuVkLYkslbU1sDGMFfJmdNhXJTumO7UAOzbb00yY-OPq2','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('9864dcaf-97b1-43e6-bc09-362e6b731bc4',_binary '\0','2024-11-08 11:55:46.278725','7dfc2be9-494d-42b5-b1c5-1a287ed11b9f','2024-11-22 11:55:46.278725',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzA0MzY5NDYsImV4cCI6MTczMTA0MTc0Nn0.YInZDqTBaONSOKmEbpaUM0qA2MrxcMkoWvq3d1Sb3kNYEKeS5Up9yuWc9kPfd9T8','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('98e01ff2-3943-4d22-ba0a-98e19e7c5716',_binary '\0','2024-11-07 11:56:59.001327','f8098438-248b-4757-92fa-b2047ea06070','2024-11-21 11:56:59.001832',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA2MTgsImV4cCI6MTczMDk1NTQxOH0.Ik9gbhnEp41aUbKni8sul6MCoSpiwd6qSOQGdI5s2GwQKEtP_xHXffmy8C4yCWEI','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('a4e92544-8ebd-43e4-9d1d-730b481940d0',_binary '\0','2024-11-07 12:02:41.959865','00ce4a15-678f-481a-a1ba-d407bd18fcca','2024-11-21 12:02:41.959865',_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA5NjEsImV4cCI6MTczMDk1NTc2MX0.Wt3TSod_3FNj0ZYU6RLFHMbw7HQ9ojgPbEl0EfCBeGBLehXMk3DWTc2O7I-Y17QQ','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('b480413c-80fd-4011-857e-a8ce12713a1d',_binary '\0','2024-11-07 11:59:47.367385','f6bab234-f12e-43ae-81ae-e10fad36a388','2024-11-21 11:59:47.367385',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA3ODcsImV4cCI6MTczMDk1NTU4N30.uFoB95GkB8O2Nfw_FpnDKonO-629kTJtMsvjT-44Xdqbw9L3D2W4MeRZ94lg4Mmb','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('b4976955-0691-468c-8602-936deefb6f09',_binary '\0','2024-11-07 11:17:01.972740','f11af0f3-516a-42a5-b43b-28e195bf14cf','2024-11-21 11:17:01.972740',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNDgyMjEsImV4cCI6MTczMDk1MzAyMX0.4yN52Go4paXWPi8zxiAOJvvcKj_iuTTzFpdIoNNc0YTOwUpYKwGIKUR0gZu32tZ7','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('c34eb1ce-a191-4a76-9ff5-b60ac3d181b6',_binary '\0','2024-11-07 11:56:30.227343','39d23350-e4b9-44fd-a82c-6a58d55b07d8','2024-11-21 11:56:30.227343',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA1OTAsImV4cCI6MTczMDk1NTM5MH0.V_R0Gme1mRdhKOJ4-qkNVqEF53HtpTfUY3idITdBudzbZJTwX05s0fG1aFhH6FaV','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('c41e863f-c093-41fc-940a-9e5cd2dbe225',_binary '\0','2024-11-07 11:40:05.503610','bcfd9ff7-1890-45c2-9636-2c30dd92529a','2024-11-21 11:40:05.503610',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNDk2MDUsImV4cCI6MTczMDk1NDQwNX0.A6qUX83oBr3k1wJziRTeof5N0QkJqbQbYr42rrZNVZTEv8_8SwkOVeR3hKyc4GbM','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('cf39a16d-68fd-4364-b09e-77b546b22e70',_binary '\0','2024-11-07 12:02:29.129109','e7951ca8-621f-479f-917d-38a677004fea','2024-11-21 12:02:29.129109',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA5NDksImV4cCI6MTczMDk1NTc0OX0.PKVoZKxX_u0t0Xy9nltT4TiLFqqlkQqubmJZRaR4TeZu4ubIB3nCCo3wQjqKHVfL','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('cf77f798-f780-4750-94f9-5fa0beb699dd',_binary '\0','2024-11-07 13:50:40.627799','c2467031-570e-4375-81ef-9edf61b263df','2024-11-21 13:50:40.627799',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTc0NDAsImV4cCI6MTczMDk2MjI0MH0.Ed-PPKNxf2wLt7Lf45xcQ7tTIMP_iUeqohYTHK3hyi22KOia-0hRKPMJJ36961jP','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('e139318f-61d9-4b58-920d-97b02c33170f',_binary '\0','2024-11-07 12:06:43.067148','f95eac83-6bd8-4165-894b-afe4f5c9dfba','2024-11-21 12:06:43.067148',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTEyMDMsImV4cCI6MTczMDk1NjAwM30.na5POKX3Fh_wGwETB65kBMNz6kA7NuEWRuhd1yQMXng_G-f30o130DN0zDjJpNKa','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('e40ac9e0-b6ae-40d9-8633-2a0bba563d4b',_binary '\0','2024-11-07 11:57:27.513341','f6028e5a-093e-4807-96fe-d296869e72e9','2024-11-21 11:57:27.513341',_binary '\0','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTA2NDcsImV4cCI6MTczMDk1NTQ0N30.WzuoFcmO0tIs8AY5-wXcZ8ZsYZIu56IGwc_gnEZw1Ew6kkSgDqWb0OWlv93qTgkN','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('e59db7a8-fe6f-4d6b-900b-cc344fe41a75',_binary '\0','2024-11-07 11:20:44.575614','de18e9d0-913c-4ed1-91ae-5ce9a5facc49','2024-11-21 11:20:44.575614',_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNDg0NDQsImV4cCI6MTczMDk1MzI0NH0.8ql9aCG1R7BNezhHxRibXJ6lQM0chK1oQfu5sd5oZszj6rLK5Toyn5RGmhNifSKE','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('eadb104b-8577-4a90-bcfe-f0210d356e88',_binary '\0','2024-11-07 11:33:59.107844','733a7eb6-1fe0-47a5-acf5-d27275e92944','2024-11-21 11:33:59.107844',_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNDkyMzksImV4cCI6MTczMDk1NDAzOX0.G3w9yv0n9xaQqZlr0sWfWfN2gWWdqsgc-HIM6u7MWFiqSboIXG5pB22gPbkuNiHw','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e'),('f649e607-6314-4329-9054-aac225edc6b1',_binary '\0','2024-11-07 12:03:38.328066','7b15a566-99cc-4e2f-bc09-d6862c2d0079','2024-11-21 12:03:38.328066',_binary '','eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIzNDdkMDBmYS04ODk5LTRhNTgtOTg2YS01MTkxNjljMmFjNWUiLCJpYXQiOjE3MzAzNTEwMTgsImV4cCI6MTczMDk1NTgxOH0.sV5S7Aow4K7XXmmvG1CqerCrNE7lKjQ0BoVSlw1G3cWC5nL3jZXSEoL7sp1socgr','Bearer','347d00fa-8899-4a58-986a-519169c2ac5e');
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

-- Dump completed on 2024-11-02  3:14:51
