package hung.pt.QuanLyBanHang.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loai")
public class Loai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_loai")
	private int maLoai;

	@Column(name = "ten_loai", length = 200)
	private String tenLoai;

	// Constructors, getters, setters

	public Loai() {
	}

	public Loai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public String toString() {
		return "Loai{" + "maLoai=" + maLoai + ", tenLoai='" + tenLoai + '\'' + '}';
	}
}