package hung.pt.QuanLyBanHang.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhanVien")
    private int maNhanVien;

    @Column(name = "TenNhanVien")
    private String tenNhanVien;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "TienLuong")
    private float tienLuong;

    // Constructor
	public NhanVien() {
		super();
	}

	public NhanVien(int maNhanVien, String tenNhanVien, String diaChi, String sdt, Date ngaySinh, float tienLuong) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.tienLuong = tienLuong;
	}

	// getter, setter
	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public float getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(float tienLuong) {
		this.tienLuong = tienLuong;
	}   
}
