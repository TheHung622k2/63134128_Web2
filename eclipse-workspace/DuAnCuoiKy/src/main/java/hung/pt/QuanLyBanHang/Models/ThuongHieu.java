package hung.pt.QuanLyBanHang.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thuonghieu")
public class ThuongHieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_thuong_hieu")
    private int maThuongHieu;

    @Column(name = "ten_thuong_hieu", length = 200)
    private String tenThuongHieu;

    // Constructors, getters, setters

    public ThuongHieu() {
    }

    public ThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public int getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(int maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    @Override
    public String toString() {
        return "ThuongHieu{" +
                "maThuongHieu=" + maThuongHieu +
                ", tenThuongHieu='" + tenThuongHieu + '\'' +
                '}';
    }
}