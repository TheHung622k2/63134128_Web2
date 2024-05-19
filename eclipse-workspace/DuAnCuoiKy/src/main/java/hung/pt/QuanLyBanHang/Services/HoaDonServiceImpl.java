package hung.pt.QuanLyBanHang.Services;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.HoaDon;
import hung.pt.QuanLyBanHang.Repositories.HoaDonRepository;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Override
	public List<HoaDon> getAllHoaDon() {
		return hoaDonRepository.findAll();
	}

	@Override
	public Optional<HoaDon> getHoaDonById(int id) {
		return hoaDonRepository.findById(id);
	}

	@Override
	public HoaDon saveHoaDon(HoaDon hoaDon) {
		return hoaDonRepository.save(hoaDon);
	}

	@Override
	public void deleteHoaDonById(int id) {
		hoaDonRepository.deleteById(id);
	}

	@Override
	public List<HoaDon> getHoaDonByNgayLap(Date ngayLap) {
		return hoaDonRepository.findByNgayLap(ngayLap);
	}
	
	@Override
	public List<Integer> getDistinctYears() {
	    List<Integer> years = hoaDonRepository.findDistinctYears();
	    Collections.sort(years);
	    return years;
	}
	
	@Override
    public List<HoaDon> getHoaDonByYear(int year) {
        return hoaDonRepository.findByYear(year);
    }
	
	@Override
    public List<Object[]> getMonthlyRevenueByYear(int year) {
        return hoaDonRepository.findMonthlyRevenueByYear(year);
    }
    
    @Override
    public List<Object[]> getMonthlyRevenueByYearAndMonthRange(int year, int startMonth, int endMonth) {
        return hoaDonRepository.findMonthlyRevenueByYearAndMonthRange(year, startMonth, endMonth);
    }
}
