package hung.pt.QuanLyBanHang.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hung.pt.QuanLyBanHang.Models.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

	List<HoaDon> findByNgayLap(Date ngayLap);

	@Query("SELECT DISTINCT YEAR(h.ngayLap) FROM HoaDon h")
    List<Integer> findDistinctYears();
	
	@Query("SELECT h FROM HoaDon h WHERE YEAR(h.ngayLap) = :year")
    List<HoaDon> findByYear(@Param("year") int year);
	
	@Query("SELECT MONTH(h.ngayLap) AS month, SUM(h.tongTien) AS total FROM HoaDon h WHERE YEAR(h.ngayLap) = :year GROUP BY MONTH(h.ngayLap)")
    List<Object[]> findMonthlyRevenueByYear(@Param("year") int year);
    
    @Query("SELECT MONTH(h.ngayLap) AS month, SUM(h.tongTien) AS total FROM HoaDon h WHERE YEAR(h.ngayLap) = :year AND MONTH(h.ngayLap) BETWEEN :startMonth AND :endMonth GROUP BY MONTH(h.ngayLap)")
    List<Object[]> findMonthlyRevenueByYearAndMonthRange(@Param("year") int year, @Param("startMonth") int startMonth, @Param("endMonth") int endMonth);
}
