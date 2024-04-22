package hung.pt.QuanLyBanHang.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoadon")
public class HoaDon {
    @Id //  đánh dấu là khóa chính và tự động tăng bằng cách sử dụng @Id và @GeneratedValue.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hoa_don")
    private int maHoaDon;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @ManyToOne // đánh dấu là một liên kết n-1 tới lớp ThanhVien bằng cách sử dụng @ManyToOne và @JoinColumn.
    @JoinColumn(name = "ma_thanh_vien", nullable = false)
    private ThanhVien maThanhVien;

    @Column(name = "tong_tien")
    private float tongTien;

    @Column(name = "nguoi_nhan")
    private String nguoiNhan;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "sdt", length = 12)
    private String sdt;

    @Column(name = "ghi_chu")
    private String ghiChu;

    // Constructors
	public HoaDon() {
		super();
	}

	public HoaDon(int maHoaDon, Date ngayTao, ThanhVien maThanhVien, float tongTien, String nguoiNhan, String diaChi,
			String sdt, String ghiChu) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayTao = ngayTao;
		this.maThanhVien = maThanhVien;
		this.tongTien = tongTien;
		this.nguoiNhan = nguoiNhan;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ghiChu = ghiChu;
	}

	// getter, setter
	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public ThanhVien getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(ThanhVien maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	public String getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
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

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}  
}
