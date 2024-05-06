package hung.pt.QuanLyBanHang.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "noigiacongvasanxuat")
public class NoiGiaCongVaSanXuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_noi_gia_cong_va_san_xuat")
    private int maNoiGiaCongVaSanXuat;

    @Column(name = "ten_noi_gia_cong_va_san_xuat", length = 200)
    private String tenNoiGiaCongVaSanXuat;

    // Constructors, getters, setters

    public NoiGiaCongVaSanXuat() {
    }

    public NoiGiaCongVaSanXuat(String tenNoiGiaCongVaSanXuat) {
        this.tenNoiGiaCongVaSanXuat = tenNoiGiaCongVaSanXuat;
    }

    public int getMaNoiGiaCongVaSanXuat() {
        return maNoiGiaCongVaSanXuat;
    }

    public void setMaNoiGiaCongVaSanXuat(int maNoiGiaCongVaSanXuat) {
        this.maNoiGiaCongVaSanXuat = maNoiGiaCongVaSanXuat;
    }

    public String getTenNoiGiaCongVaSanXuat() {
        return tenNoiGiaCongVaSanXuat;
    }

    public void setTenNoiGiaCongVaSanXuat(String tenNoiGiaCongVaSanXuat) {
        this.tenNoiGiaCongVaSanXuat = tenNoiGiaCongVaSanXuat;
    }

    @Override
    public String toString() {
        return "NoiGiaCongVaSanXuat{" +
                "maNoiGiaCongVaSanXuat=" + maNoiGiaCongVaSanXuat +
                ", tenNoiGiaCongVaSanXuat='" + tenNoiGiaCongVaSanXuat + '\'' +
                '}';
    }
}