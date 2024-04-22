package hung.pt.QuanLyBanHang.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSanPham")
    private int maSanPham;

    @Column(name = "TenSanPham")
    private String tenSanPham;

    @ManyToOne
    @JoinColumn(name = "MaNCC", nullable = false)
    private NhaCungCap maNCC;

    @Column(name = "SoLuong")
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "MaLoai", nullable = false)
    private Loai maLoai;

    @Column(name = "GiaTien")
    private float giaTien;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "AnhSP")
    private String anhSP;

    // Constructor
	public SanPham() {
		super();
	}

	public SanPham(int maSanPham, String tenSanPham, NhaCungCap maNCC, int soLuong, Loai maLoai, float giaTien,
			String moTa, String anhSP) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.maNCC = maNCC;
		this.soLuong = soLuong;
		this.maLoai = maLoai;
		this.giaTien = giaTien;
		this.moTa = moTa;
		this.anhSP = anhSP;
	}

	// getter, setter
	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public NhaCungCap getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(NhaCungCap maNCC) {
		this.maNCC = maNCC;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Loai getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(Loai maLoai) {
		this.maLoai = maLoai;
	}

	public float getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(float giaTien) {
		this.giaTien = giaTien;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getAnhSP() {
		return anhSP;
	}

	public void setAnhSP(String anhSP) {
		this.anhSP = anhSP;
	}    
}
