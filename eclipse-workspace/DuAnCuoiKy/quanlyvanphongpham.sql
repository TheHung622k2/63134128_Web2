CREATE DATABASE IF NOT EXISTS QuanLyVanPhongPham CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE QuanLyVanPhongPham;

-- Bảng 'thanhvien'
CREATE TABLE IF NOT EXISTS thanhvien (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    TenDangNhap VARCHAR(2000) NOT NULL,
    Quyen VARCHAR(20) NOT NULL,
    MatKhau VARCHAR(500),
    HoVaTen NVARCHAR(2000),
    DiaChi NVARCHAR(2000),
    SDT VARCHAR(12),
    Email VARCHAR(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'hoadon'
CREATE TABLE IF NOT EXISTS hoadon (
    MaHoaDon INT AUTO_INCREMENT PRIMARY KEY,
    NgayTao DATETIME,
    MaThanhVien INT NOT NULL,
    TongTien FLOAT,
    NguoiNhan NVARCHAR(2000),
    DiaChi NVARCHAR(2000),
    SDT VARCHAR(12),
    GhiChu NVARCHAR(20),
    FOREIGN KEY (MaThanhVien) REFERENCES thanhvien(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'nhacungcap'
CREATE TABLE IF NOT EXISTS nhacungcap (
    MaNhaCungCap INT AUTO_INCREMENT PRIMARY KEY,
    TenNhaCungCap NVARCHAR(2000),
    SDT VARCHAR(12),
    DiaChi NVARCHAR(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'loai'
CREATE TABLE IF NOT EXISTS loai (
    MaLoai INT AUTO_INCREMENT PRIMARY KEY,
    TenLoai NVARCHAR(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'sanpham'
CREATE TABLE IF NOT EXISTS sanpham (
    MaSanPham INT AUTO_INCREMENT PRIMARY KEY,
    TenSanPham NVARCHAR(2000),
    MaNCC INT NOT NULL,
    SoLuong INT,
    MaLoai INT NOT NULL,
    GiaTien FLOAT,
    MoTa NVARCHAR(2000),
    AnhSP NVARCHAR(2000),
    FOREIGN KEY (MaNCC) REFERENCES nhacungcap(MaNhaCungCap),
    FOREIGN KEY (MaLoai) REFERENCES loai(MaLoai)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'chitiethoadon'
CREATE TABLE IF NOT EXISTS chitiethoadon (
    MaHoaDon INT,
    MaSP INT,
    SoLuong INT,
    GhiChu NVARCHAR(2000),
    PRIMARY KEY (MaHoaDon, MaSP),
    FOREIGN KEY (MaHoaDon) REFERENCES hoadon(MaHoaDon),
    FOREIGN KEY (MaSP) REFERENCES sanpham(MaSanPham)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'nhanvien'
CREATE TABLE IF NOT EXISTS nhanvien (
    MaNhanVien INT AUTO_INCREMENT PRIMARY KEY,
    TenNhanVien NVARCHAR(2000),
    DiaChi NVARCHAR(2000),
    SDT VARCHAR(12),
    NgaySinh DATETIME,
    TienLuong FLOAT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'cauhoithuonggap'
CREATE TABLE IF NOT EXISTS cauhoithuonggap (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Question NVARCHAR(2000),
    Answer NVARCHAR(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
