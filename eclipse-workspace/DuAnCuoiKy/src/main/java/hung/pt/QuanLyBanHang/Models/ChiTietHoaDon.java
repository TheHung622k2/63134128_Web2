package hung.pt.QuanLyBanHang.Models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {
    @EmbeddedId
    private ChiTietHoaDonId id; // sử dụng một khóa chính nhúng (ChiTietHoaDonId) để đại diện cho khóa chính gồm cả MaHoaDon và MaSP.

    @ManyToOne // đánh dấu là các liên kết nhiều-đến-một tới các đối tượng HoaDon tương ứng
    @JoinColumn(name = "MaHoaDon", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @ManyToOne // đánh dấu là các liên kết nhiều-đến-một tới các đối tượng SanPham tương ứng
    @JoinColumn(name = "MaSP", insertable = false, updatable = false) // insertable = false và updatable = false được sử dụng trong các chú thích @JoinColumn để chỉ định rằng các trường MaHoaDon và MaSP không thể được thêm mới hoặc cập nhật trực tiếp trong lớp ChiTietHoaDon, mà chúng được điều chỉnh thông qua việc thêm hoặc cập nhật của HoaDon và SanPham tương ứng.
    private SanPham sanPham;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "GhiChu")
    private String ghiChu;

    // Constructor
	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(ChiTietHoaDonId id, HoaDon hoaDon, SanPham sanPham, int soLuong, String ghiChu) {
		super();
		this.id = id;
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
	}

	// getter, setter
	public ChiTietHoaDonId getId() {
		return id;
	}

	public void setId(ChiTietHoaDonId id) {
		this.id = id;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}    
}
