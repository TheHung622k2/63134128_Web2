CREATE DATABASE IF NOT EXISTS quanlyvanphongpham1 CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE quanlyvanphongpham1;

-- Bảng 'nguoidung'
CREATE TABLE IF NOT EXISTS nguoidung (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    ten_dang_nhap VARCHAR(200) NOT NULL,
    quyen NVARCHAR(30) NOT NULL,
    mat_khau VARCHAR(50),
    ho_va_ten NVARCHAR(100),
    dia_chi NVARCHAR(200),
    sdt VARCHAR(12),
    ngay_sinh DATETIME,
    email VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS nguoidung;

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

-- Bảng 'sanpham'
CREATE TABLE IF NOT EXISTS sanpham (
    ma_san_pham INT AUTO_INCREMENT PRIMARY KEY,
    ten_san_pham NVARCHAR(200),
    ma_ncc INT NOT NULL,
    so_luong INT,
    ma_loai INT NOT NULL,
    ma_thuong_hieu INT NOT NULL,
    ma_noi_gia_cong_va_san_xuat INT NOT NULL,
    gia_tien FLOAT,
    mo_ta NVARCHAR(2000),
    anh_sp NVARCHAR(200),
    FOREIGN KEY (ma_ncc) REFERENCES nhacungcap(ma_nha_cung_cap),
    FOREIGN KEY (ma_loai) REFERENCES loai(ma_loai),
    FOREIGN KEY (ma_thuong_hieu) REFERENCES thuonghieu(ma_thuong_hieu),
    FOREIGN KEY (ma_noi_gia_cong_va_san_xuat) REFERENCES noigiacongvasanxuat(ma_noi_gia_cong_va_san_xuat)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Bảng 'hoadon'
CREATE TABLE IF NOT EXISTS hoadon (
    ma_hoa_don INT AUTO_INCREMENT PRIMARY KEY,
    ngay_lap DATE NOT NULL,
    tong_tien FLOAT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES nguoidung(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

DROP TABLE IF EXISTS hoadon;

INSERT INTO nguoidung (ten_dang_nhap, quyen, mat_khau, email)
VALUES 
('admin', 'Admin', '123456', 'hung.pt.63cntt@ntu.edu.vn');

INSERT INTO nguoidung (ten_dang_nhap, quyen, mat_khau, ho_va_ten, dia_chi, sdt, ngay_sinh, email)
VALUES 
('nguyenvana_emp', 'Nhân viên', 'nguyenvana123', 'Nguyễn Văn A', '123 Employee Street', '0123456789', '1992-02-02', 'nhanvien1@example.com'),
('tranvanb_emp', 'Nhân viên', 'tranducb123', 'Trần Văn Bình', '456 Employee Street', '0123456789', '1997-07-07', 'nhanvien2@example.com'),
('lechic_emp', 'Nhân viên', 'lechic123', 'Lê Chí Cường', '789 Employee Street', '0123456789', '1999-09-09', 'nhanvien3@example.com'),
('duongvand_emp', 'Nhân viên', 'duongvand123', 'Dương Văn Dũng', '1011 Employee Street', '0123456789', '2000-10-10', 'nhanvien4@example.com');

INSERT INTO nhacungcap (ten_nha_cung_cap, sdt, dia_chi)
VALUES 
('Thiên Long Hoàn Cầu', '02837505555', '658P Đ. Phạm Văn Chí, Phường 8, Quận 6, Thành phố Hồ Chí Minh 700000'),
('Cty Văn Phòng Sáng Tạo (Stacom)', '02836368831', '43 Đường Linh Đông, Khu phố 7, P. Linh Đông, TP. Thủ Đức, TP. HCM'),
('Cty Fabico', '02743822062', '604 Cách Mạng Tháng 8 - Phú Cường - Thủ Dầu Một - Bình Dương'),
('Bình Tây', '	0913394655', '76 Đường TK 2, Ấp Tiền Lân, Xã Bà Điểm, Huyện Hóc Môn, Thành phố Hồ Chí Minh, Việt Nam'),
('Cty TM Hạnh Thuận', '0310576040', '43 Đ. D4, Tân Hưng, Quận 7, Thành phố Hồ Chí Minh');

INSERT INTO loai (ten_loai)
VALUES 
('Bút - Viết'),
('Sản Phẩm Về Giấy'),
('Dụng Cụ Học Sinh'),
('Dụng Cụ Vẽ'),
('Dụng Cụ Văn Phòng'),
('Sản Phẩm Điện Tử');

INSERT INTO thuonghieu (ten_thuong_hieu)
VALUES 
('Thiên Long'),
('Artline'),
('OEM'),
('Stacom'),
('Pentel');

INSERT INTO noigiacongvasanxuat (ten_noi_gia_cong_va_san_xuat)
VALUES 
('Việt Nam'),
('Trung Quốc'),
('Nhật Bản'),
('Malaysia'),
('Thái Lan');

INSERT INTO sanpham (ten_san_pham, ma_ncc, so_luong, ma_loai, ma_thuong_hieu, ma_noi_gia_cong_va_san_xuat, gia_tien, mo_ta, anh_sp) VALUES
('Bút bi Thiên Long BL-05 (Đen)', 1, 100, 1, 1, 1, 5000, 'Bút bi Thiên Long mực đen BL-05', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Thiên Long BL-05 (Xanh)', 1, 100, 1, 1, 1, 5000, 'Bút bi Thiên Long mực xanh BL-05', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Thiên Long BL-05 (Đỏ)', 1, 100, 1, 1, 1, 5000, 'Bút bi Thiên Long mực đỏ BL-05', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Thiên Long BL-05 (Vàng)', 1, 100, 1, 1, 1, 5000, 'Bút bi Thiên Long mực vàng BL-05', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Artline EK-200 (Đen)', 2, 100, 1, 2, 1, 7000, 'Bút bi Artline mực đen EK-200', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Artline EK-200 (Xanh)', 2, 100, 1, 2, 1, 7000, 'Bút bi Artline mực xanh EK-200', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Artline EK-200 (Đỏ)', 2, 100, 1, 2, 1, 7000, 'Bút bi Artline mực đỏ EK-200', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Artline EK-200 (Vàng)', 2, 100, 1, 2, 1, 7000, 'Bút bi Artline mực vàng EK-200', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Stacom SF-200 (Đen)', 2, 100, 1, 4, 1, 6000, 'Bút bi Stacom mực đen SF-200', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Stacom SF-200 (Xanh)', 2, 100, 1, 4, 1, 6000, 'Bút bi Stacom mực xanh SF-200', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Stacom SF-200 (Đỏ)', 2, 100, 1, 4, 1, 6000, 'Bút bi Stacom mực đỏ SF-200', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Stacom SF-200 (Vàng)', 2, 100, 1, 4, 1, 6000, 'Bút bi Stacom mực vàng SF-200', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Pentel BK-417 (Đen)', 2, 100, 1, 5, 1, 8000, 'Bút bi Pentel mực đen BK-417', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Pentel BK-417 (Xanh)', 2, 100, 1, 5, 1, 8000, 'Bút bi Pentel mực xanh BK-417', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Pentel BK-417 (Đỏ)', 2, 100, 1, 5, 1, 8000, 'Bút bi Pentel mực đỏ BK-417', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút bi Pentel BK-417 (Vàng)', 2, 100, 1, 5, 1, 8000, 'Bút bi Pentel mực vàng BK-417', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì HB Thiên Long', 1, 300, 1, 1, 1, 2000, 'Bút chì HB Thiên Long', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì HB Artline', 2, 300, 1, 2, 1, 2500, 'Bút chì HB Artline', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì HB OEM', 3, 300, 1, 3, 1, 3000, 'Bút chì HB OEM', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì HB Stacom', 4, 300, 1, 4, 1, 2800, 'Bút chì HB Stacom', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì HB Pentel', 5, 300, 1, 5, 1, 3500, 'Bút chì HB Pentel', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút màu Thiên Long', 1, 200, 1, 1, 1, 5000, 'Bút màu Thiên Long', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút màu Artline', 2, 200, 1, 2, 1, 6000, 'Bút màu Artline', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút màu OEM', 3, 200, 1, 3, 1, 7000, 'Bút màu OEM', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút màu Stacom', 4, 200, 1, 4, 1, 6500, 'Bút màu Stacom', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút màu Pentel', 5, 200, 1, 5, 1, 8000, 'Bút màu Pentel', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút lông Artline', 2, 150, 1, 2, 1, 10000, 'Bút lông Artline', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút lông Pentel', 5, 150, 1, 5, 1, 12000, 'Bút lông Pentel', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì màu Thiên Long', 1, 200, 1, 1, 1, 4000, 'Bút chì màu Thiên Long', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì màu Artline', 2, 200, 1, 2, 1, 5000, 'Bút chì màu Artline', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì màu OEM', 3, 200, 1, 3, 1, 6000, 'Bút chì màu OEM', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì màu Stacom', 4, 200, 1, 4, 1, 5500, 'Bút chì màu Stacom', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg'),
('Bút chì màu Pentel', 5, 200, 1, 5, 1, 7000, 'Bút chì màu Pentel', '/products/Bút Bi Điểm 10 Windee 0.5 mm.jpg');

INSERT INTO hoadon (ngay_lap, tong_tien, user_id) VALUES
('2024-04-01', 150000, 2),
('2024-04-02', 200000, 3),
('2024-04-03', 175000, 4),
('2024-04-04', 220000, 2),
('2024-04-05', 180000, 3),
('2024-04-06', 195000, 4),
('2024-04-07', 210000, 2),
('2024-04-08', 225000, 3),
('2024-04-09', 185000, 4),
('2024-04-10', 230000, 2),
('2024-05-01', 240000, 3),
('2024-05-02', 250000, 4),
('2024-05-03', 260000, 2),
('2024-05-04', 270000, 3),
('2024-05-05', 280000, 4),
('2024-05-06', 290000, 2),
('2024-05-07', 300000, 3),
('2024-05-08', 310000, 4),
('2024-05-09', 320000, 2),
('2024-05-10', 330000, 3),
('2024-06-01', 340000, 4),
('2024-06-02', 350000, 2),
('2024-06-03', 360000, 3),
('2024-06-04', 370000, 4),
('2024-06-05', 380000, 2),
('2024-06-06', 390000, 3),
('2024-06-07', 400000, 4),
('2024-06-08', 410000, 2),
('2024-06-09', 420000, 3),
('2024-06-10', 430000, 4),
('2024-07-01', 440000, 2),
('2024-07-02', 450000, 3),
('2024-07-03', 460000, 4),
('2024-07-04', 470000, 2),
('2024-07-05', 480000, 3),
('2024-07-06', 490000, 4),
('2024-07-07', 500000, 2),
('2024-07-08', 510000, 3),
('2024-07-09', 520000, 4),
('2024-07-10', 530000, 2),
('2024-08-01', 540000, 3),
('2024-08-02', 550000, 4),
('2024-08-03', 560000, 2),
('2024-08-04', 570000, 3),
('2024-08-05', 580000, 4),
('2024-08-06', 590000, 2),
('2024-08-07', 600000, 3),
('2024-08-08', 610000, 4),
('2024-08-09', 620000, 2),
('2024-08-10', 630000, 3);
