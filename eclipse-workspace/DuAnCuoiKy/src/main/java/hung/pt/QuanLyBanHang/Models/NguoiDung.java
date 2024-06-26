package hung.pt.QuanLyBanHang.Models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "nguoidung")
public class NguoiDung {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "ten_dang_nhap", nullable = false, length = 200)
	private String tenDangNhap;

	@Column(name = "quyen", nullable = false, length = 30)
	private String quyen;

	@Column(name = "mat_khau", length = 50)
	private String matKhau;

	@Column(name = "ho_va_ten", length = 100)
	private String hoVaTen;

	@Column(name = "dia_chi", length = 200)
	private String diaChi;

	@Column(name = "sdt", length = 12)
	private String sdt;

	@Column(name = "ngay_sinh")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date ngaySinh;

	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "trang_thai", nullable = false)
    private boolean trangThai = true; // true: active, false: locked

	// Constructors, getters, setters

	public NguoiDung() {
	}

	public NguoiDung(String tenDangNhap, String quyen, String matKhau, String hoVaTen, String diaChi, String sdt,
			Date ngaySinh, String email, boolean trangThai) {
		this.tenDangNhap = tenDangNhap;
		this.quyen = quyen;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.trangThai = trangThai;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

	@Override
	public String toString() {
		return "NguoiDung{" + "userId=" + userId + ", tenDangNhap='" + tenDangNhap + '\'' + ", quyen='" + quyen + '\''
				+ ", matKhau='" + matKhau + '\'' + ", hoVaTen='" + hoVaTen + '\'' + ", diaChi='" + diaChi + '\''
				+ ", sdt='" + sdt + '\'' + ", ngaySinh=" + ngaySinh + ", email='" + email + '\'' + '}';
	}
}