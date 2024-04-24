CREATE DATABASE IF NOT EXISTS quanlyvanphongpham1 CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE quanlyvanphongpham1;

-- Bảng 'nguoidung'
CREATE TABLE IF NOT EXISTS nguoidung (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    ten_dang_nhap VARCHAR(200) NOT NULL,
    quyen NVARCHAR(50) NOT NULL,
    mat_khau VARCHAR(50),
    ho_va_ten NVARCHAR(100),
    dia_chi NVARCHAR(200),
    sdt VARCHAR(12),
    ngay_sinh DATETIME,
    email VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'nhacungcap'
CREATE TABLE IF NOT EXISTS nhacungcap (
    ma_nha_cung_cap INT AUTO_INCREMENT PRIMARY KEY,
    ten_nha_cung_cap NVARCHAR(200),
    sdt VARCHAR(12),
    dia_chi NVARCHAR(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'loai'
CREATE TABLE IF NOT EXISTS loai (
    ma_loai INT AUTO_INCREMENT PRIMARY KEY,
    ten_loai NVARCHAR(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'thuonghieu'
CREATE TABLE IF NOT EXISTS thuonghieu (
	ma_thuong_hieu INT AUTO_INCREMENT PRIMARY KEY,
	ten_thuong_hieu NVARCHAR(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'noigiacongvasanxuat'
CREATE TABLE IF NOT EXISTS noigiacongvasanxuat (
	ma_noi_gia_cong_va_san_xuat INT AUTO_INCREMENT PRIMARY KEY,
	ten_noi_gia_cong_va_san_xuat NVARCHAR(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'xuatxuthuonghieu'
CREATE TABLE IF NOT EXISTS xuatxuthuonghieu (
	ma_xuat_xu_thuong_hieu INT AUTO_INCREMENT PRIMARY KEY,
	ten_xuat_xu_thuong_hieu NVARCHAR(200)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'sanpham'
CREATE TABLE IF NOT EXISTS sanpham (
    ma_san_pham INT AUTO_INCREMENT PRIMARY KEY,
    ten_san_pham NVARCHAR(200),
    ma_ncc INT NOT NULL,
    so_luong INT,
    ma_loai INT NOT NULL,
    ma_thuong_hieu INT NOT NULL,
    ma_noi_gia_cong_va_san_xuat INT NOT NULL,
    ma_xuat_xu_thuong_hieu INT NOT NULL,
    gia_tien FLOAT,
    mo_ta NVARCHAR(2000),
    anh_sp NVARCHAR(200),
    FOREIGN KEY (ma_ncc) REFERENCES nhacungcap(ma_nha_cung_cap),
    FOREIGN KEY (ma_loai) REFERENCES loai(ma_loai),
    FOREIGN KEY (ma_thuong_hieu) REFERENCES thuonghieu(ma_thuong_hieu),
    FOREIGN KEY (ma_noi_gia_cong_va_san_xuat) REFERENCES noigiacongvasanxuat(ma_noi_gia_cong_va_san_xuat),
    FOREIGN KEY (ma_xuat_xu_thuong_hieu) REFERENCES xuatxuthuonghieu(ma_xuat_xu_thuong_hieu)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;