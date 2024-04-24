CREATE DATABASE IF NOT EXISTS QuanLyVanPhongPham CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE QuanLyVanPhongPham;

-- Bảng 'nguoidung'
CREATE TABLE IF NOT EXISTS thanhvien (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten_dang_nhap VARCHAR(2000) NOT NULL,
    quyen VARCHAR(20) NOT NULL,
    mat_khau VARCHAR(500),
    ho_va_ten NVARCHAR(2000),
    dia_chi NVARCHAR(2000),
    sdt VARCHAR(12),
    email VARCHAR(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'hoadon'
CREATE TABLE IF NOT EXISTS hoadon (
    ma_hoa_don INT AUTO_INCREMENT PRIMARY KEY,
    ngay_tao DATETIME,
    ma_thanh_vien INT NOT NULL,
    tong_tien FLOAT,
    nguoi_nhan NVARCHAR(2000),
    dia_chi NVARCHAR(2000),
    sdt VARCHAR(12),
    ghi_chu NVARCHAR(20),
    FOREIGN KEY (ma_thanh_vien) REFERENCES thanhvien(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'nhacungcap'
CREATE TABLE IF NOT EXISTS nhacungcap (
    ma_nha_cung_cap INT AUTO_INCREMENT PRIMARY KEY,
    ten_nha_cung_cap NVARCHAR(2000),
    sdt VARCHAR(12),
    dia_chi NVARCHAR(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'loai'
CREATE TABLE IF NOT EXISTS loai (
    ma_loai INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai NVARCHAR(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'sanpham'
CREATE TABLE IF NOT EXISTS sanpham (
    ma_san_pham INT AUTO_INCREMENT PRIMARY KEY,
    ten_san_pham NVARCHAR(2000),
    ma_ncc INT NOT NULL,
    so_luong INT,
    ma_loai INT NOT NULL,
    gia_tien FLOAT,
    mo_ta NVARCHAR(2000),
    anh_sp NVARCHAR(2000),
    FOREIGN KEY (ma_ncc) REFERENCES nhacungcap(ma_nha_cung_cap),
    FOREIGN KEY (ma_loai) REFERENCES loai(ma_loai)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'chitiethoadon'
CREATE TABLE IF NOT EXISTS chitiethoadon (
    ma_hoa_don INT,
    ma_sp INT,
    so_luong INT,
    ghi_chu NVARCHAR(2000),
    PRIMARY KEY (ma_hoa_don, ma_sp),
    FOREIGN KEY (ma_hoa_don) REFERENCES hoadon(ma_hoa_don),
    FOREIGN KEY (ma_sp) REFERENCES sanpham(ma_san_pham)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'nhanvien'
CREATE TABLE IF NOT EXISTS nhanvien (
    ma_nhan_vien INT AUTO_INCREMENT PRIMARY KEY,
    ten_nhan_vien NVARCHAR(2000),
    dia_chi NVARCHAR(2000),
    sdt VARCHAR(12),
    ngay_sinh DATETIME,
    tien_luong FLOAT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'cauhoithuonggap'
CREATE TABLE IF NOT EXISTS cauhoithuonggap (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question NVARCHAR(2000),
    answer NVARCHAR(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO thanhvien (ten_dang_nhap, quyen, mat_khau, ho_va_ten, dia_chi, sdt, email) 
VALUES 
('user1', 'admin', 'password1', N'Nguyễn Văn A', N'123 Đường ABC, Quận 1, Thành phố Hồ Chí Minh', '0123456789', 'user1@example.com'),
('user2', 'member', 'password2', N'Trần Thị B', N'456 Đường XYZ, Quận 2, Thành phố Hồ Chí Minh', '0987654321', 'user2@example.com'),
('user3', 'member', 'password3', N'Lê Văn C', N'789 Đường DEF, Quận 3, Thành phố Hồ Chí Minh', '0369852147', 'user3@example.com');


