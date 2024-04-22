package hung.pt.QuanLyBanHang.Models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable // chỉ định rằng đây là một lớp nhúng được sử dụng làm khóa nhúng trong lớp ChiTietHoaDon
public class ChiTietHoaDonId implements Serializable { // cần triển khai giao diện Serializable vì nó sẽ được sử dụng trong một môi trường JPA
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MaHoaDon")
    private int maHoaDon;

    @Column(name = "MaSP")
    private int maSP;

	public ChiTietHoaDonId() {
		super();
	}

	public ChiTietHoaDonId(int maHoaDon, int maSP) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSP = maSP;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	} 
}
