CREATE DATABASE IF NOT EXISTS QuanLyVanPhongPham CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE QuanLyVanPhongPham;

CREATE TABLE `nguoidung` (
	`ID` int NOT NULL,
    `USERID` varchar(40)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;