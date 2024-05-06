package hung.pt.QuanLyBanHang.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "hoadon")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hoa_don")
    private int maHoaDon;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_lap", nullable = false)
    private Date ngayLap;

    @Column(name = "tong_tien", nullable = false)
    private float tongTien;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private NguoiDung nguoiDung;

    // Constructors, getters, setters

    public HoaDon() {
    }

    public HoaDon(Date ngayLap, float tongTien, NguoiDung nguoiDung) {
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.nguoiDung = nguoiDung;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHoaDon=" + maHoaDon +
                ", ngayLap=" + ngayLap +
                ", tongTien=" + tongTien +
                ", nguoiDung=" + nguoiDung +
                '}';
    }
}