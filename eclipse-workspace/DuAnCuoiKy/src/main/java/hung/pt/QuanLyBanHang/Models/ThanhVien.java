package hung.pt.QuanLyBanHang.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thanhvien") // ánh xạ các đối tượng Java với các bảng trong cơ sở dữ liệu.
public class ThanhVien {
    @Id // đánh dấu là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // thiết lập tự động tăng bằng cách sử dụng @GeneratedValue với GenerationType.IDENTITY.
    @Column(name = "ID")
    private int id;
    
    @Column(name = "TenDangNhap", nullable = false) // nullable = false để phản ánh điều kiện NOT NULL trong cơ sở dữ liệu.
    private String tenDangNhap;
    
    @Column(name = "Quyen", nullable = false)
    private String quyen;
    
    @Column(name = "MatKhau")
    private String matKhau;
    
    @Column(name = "HoVaTen")
    private String hoVaTen;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "SDT", length = 12) // length được sử dụng để chỉ định độ dài tối đa của chuỗi
    private String sdt;
    
    @Column(name = "Email")
    private String email;

    // Constructor
	public ThanhVien() {
		super();
	}

	public ThanhVien(int id, String tenDangNhap, String quyen, String matKhau, String hoVaTen, String diaChi,
			String sdt, String email) {
		super();
		this.id = id;
		this.tenDangNhap = tenDangNhap;
		this.quyen = quyen;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
	}

    // getter, setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}