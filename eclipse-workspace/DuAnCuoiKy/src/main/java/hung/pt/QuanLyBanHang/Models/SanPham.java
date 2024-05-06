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
	@Column(name = "ma_san_pham")
	private int maSanPham;

	@Column(name = "ten_san_pham", length = 200)
	private String tenSanPham;

	@ManyToOne
	@JoinColumn(name = "ma_ncc", nullable = false)
	private NhaCungCap nhaCungCap;

	@Column(name = "so_luong")
	private int soLuong;

	@ManyToOne
	@JoinColumn(name = "ma_loai", nullable = false)
	private Loai loai;

	@ManyToOne
	@JoinColumn(name = "ma_thuong_hieu", nullable = false)
	private ThuongHieu thuongHieu;

	@ManyToOne
	@JoinColumn(name = "ma_noi_gia_cong_va_san_xuat", nullable = false)
	private NoiGiaCongVaSanXuat noiGiaCongVaSanXuat;

	@Column(name = "gia_tien")
	private float giaTien;

	@Column(name = "mo_ta", length = 2000)
	private String moTa;

	@Column(name = "anh_sp", length = 200)
	private String anhSp;

	// Constructors, getters, setters

	public SanPham() {
	}

	public SanPham(String tenSanPham, NhaCungCap nhaCungCap, int soLuong, Loai loai, ThuongHieu thuongHieu,
			NoiGiaCongVaSanXuat noiGiaCongVaSanXuat, float giaTien, String moTa, String anhSp) {
		this.tenSanPham = tenSanPham;
		this.nhaCungCap = nhaCungCap;
		this.soLuong = soLuong;
		this.loai = loai;
		this.thuongHieu = thuongHieu;
		this.noiGiaCongVaSanXuat = noiGiaCongVaSanXuat;
		this.giaTien = giaTien;
		this.moTa = moTa;
		this.anhSp = anhSp;
	}

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

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Loai getLoai() {
		return loai;
	}

	public void setLoai(Loai loai) {
		this.loai = loai;
	}

	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public NoiGiaCongVaSanXuat getNoiGiaCongVaSanXuat() {
		return noiGiaCongVaSanXuat;
	}

	public void setNoiGiaCongVaSanXuat(NoiGiaCongVaSanXuat noiGiaCongVaSanXuat) {
		this.noiGiaCongVaSanXuat = noiGiaCongVaSanXuat;
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

	public String getAnhSp() {
		return anhSp;
	}

	public void setAnhSp(String anhSp) {
		this.anhSp = anhSp;
	}

	@Override
	public String toString() {
		return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham='" + tenSanPham + '\'' + ", nhaCungCap="
				+ nhaCungCap + ", soLuong=" + soLuong + ", loai=" + loai + ", thuongHieu=" + thuongHieu
				+ ", noiGiaCongVaSanXuat=" + noiGiaCongVaSanXuat + ", giaTien=" + giaTien + ", moTa='" + moTa + '\''
				+ ", anhSp='" + anhSp + '\'' + '}';
	}
}