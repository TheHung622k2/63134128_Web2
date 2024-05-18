package hung.pt.QuanLyBanHang.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import hung.pt.QuanLyBanHang.Models.HoaDon;

public interface HoaDonService {

	List<HoaDon> getAllHoaDon();

	Optional<HoaDon> getHoaDonById(int id);

	HoaDon saveHoaDon(HoaDon hoaDon);

	void deleteHoaDonById(int id);

	List<HoaDon> getHoaDonByNgayLap(Date ngayLap);
	
	List<Integer> getDistinctYears();
	
	List<HoaDon> getHoaDonByYear(int year);
	
	List<Object[]> getMonthlyRevenueByYear(int year);
}
