package hung.pt.QuanLyBanHang.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hung.pt.QuanLyBanHang.Models.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

	List<HoaDon> findByNgayLap(Date ngayLap);
	
	@Query("SELECT MONTH(h.ngayLap), SUM(h.tongTien) FROM HoaDon h GROUP BY MONTH(h.ngayLap)")
    List<Object[]> findRevenueByMonth();
}
