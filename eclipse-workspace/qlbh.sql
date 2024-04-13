CREATE DATABASE IF NOT EXISTS QuanLyBanHang CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE QuanLyBanHang;

CREATE TABLE `khachhang` (
  `MAKH` char(4) NOT NULL,
  `HOTEN` varchar(40) DEFAULT NULL,
  `DCHI` varchar(50) DEFAULT NULL,
  `SODT` varchar(20) DEFAULT NULL,
  `NGSINH` date DEFAULT NULL,
  `NGDK` timestamp NOT NULL DEFAULT current_timestamp(),
  `DOANHSO` double DEFAULT NULL,
  PRIMARY KEY (`MAKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `nhanvien` (
  `MANV` char(4) NOT NULL,
  `HOTEN` varchar(40) DEFAULT NULL,
  `SODT` varchar(20) DEFAULT NULL,
  `NGAYVL` date NOT NULL,
  PRIMARY KEY (`MANV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `sanpham` (
  `MASP` char(4) NOT NULL,
  `TENSP` varchar(40) DEFAULT NULL,
  `DVT` varchar(20) DEFAULT NULL,
  `NUOCSX` varchar(40) DEFAULT NULL,
  `GIA` double NOT NULL,
  PRIMARY KEY (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `hoadon` (
  `SOHD` int NOT NULL, -- Thay `int(11)` thành `int`
  `NGHD` datetime DEFAULT NULL,
  `MAKH` char(4) DEFAULT NULL,
  `MANV` char(4) DEFAULT NULL,
  `TRIGIA` double NOT NULL,
  PRIMARY KEY (`SOHD`),
  KEY `fk01_HD` (`MAKH`),
  KEY `fk02_HD` (`MANV`),
  CONSTRAINT `fk01_HD` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`),
  CONSTRAINT `fk02_HD` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `cthd` (
  `SOHD` int NOT NULL, -- Thay `int(11)` thành `int`
  `MASP` char(4) NOT NULL,
  `SL` int DEFAULT NULL, -- Thay `int(11)` thành `int`
  PRIMARY KEY (`SOHD`,`MASP`),
  KEY `fk02_CTHD` (`MASP`),
  CONSTRAINT `fk01_CTHD` FOREIGN KEY (`SOHD`) REFERENCES `hoadon` (`SOHD`),
  CONSTRAINT `fk02_CTHD` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

