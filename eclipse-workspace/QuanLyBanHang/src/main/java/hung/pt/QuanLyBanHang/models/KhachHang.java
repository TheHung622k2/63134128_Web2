package hung.pt.QuanLyBanHang.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "khachhang") // Tên bảng sẽ Mapping, chú ý phân biệt hoa thường
public class KhachHang {
	@Id
	@Column(name="MAKH")
	private String maKhach;
	@Column(name="HOTEN")
	private String hoTen;
	@Column(name="DCHI")
	private String diaChi;
	@Column(name="SODT")
	private String soDienThoai;
	@Column(name="NGSINH")
	private Date ngaySinh;
	@Column(name="NGDK")
	private Date ngayDangKy;
	@Column(name="DOANHSO")
	private double doanhSo;
	
	// getter, setter	
	public String getMaKhach() {
		return maKhach;
	}
	public void setMaKhach(String maKhach) {
		this.maKhach = maKhach;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Date getNgayDangKy() {
		return ngayDangKy;
	}
	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}
	public double getDoanhSo() {
		return doanhSo;
	}
	public void setDoanhSo(double doanhSo) {
		this.doanhSo = doanhSo;
	}
}
