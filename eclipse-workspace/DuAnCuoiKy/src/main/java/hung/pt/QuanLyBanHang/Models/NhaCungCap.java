package hung.pt.QuanLyBanHang.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
    @Id // đánh dấu là khóa chính và tự động tăng bằng cách sử dụng @Id và @GeneratedValue.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nha_cung_cap")
    private int maNhaCungCap;

    @Column(name = "ten_nha_cung_cap")
    private String tenNhaCungCap;

    @Column(name = "sdt", length = 12) // length được sử dụng để chỉ định độ dài tối đa của chuỗi, giống với độ dài được xác định trong cấu trúc SQL.
    private String sdt;

    @Column(name = "dia_chi")
    private String diaChi;

    // Constructor
	public NhaCungCap() {
		super();
	}

	public NhaCungCap(int maNhaCungCap, String tenNhaCungCap, String sdt, String diaChi) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}

	// getter, setter
	public int getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(int maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}
