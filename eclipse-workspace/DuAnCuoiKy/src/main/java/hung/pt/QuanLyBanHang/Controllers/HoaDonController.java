package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hung.pt.QuanLyBanHang.Models.HoaDon;
import hung.pt.QuanLyBanHang.Services.HoaDonService;

@Controller
@RequestMapping("/hoadon")
public class HoaDonController {

	@Autowired
	private HoaDonService hoaDonService;

	@GetMapping("/all")
	public String getAllHoaDon(Model model) {
		List<HoaDon> dsHoaDon = hoaDonService.getAllHoaDon();
		model.addAttribute("dsHoaDon", dsHoaDon);
		return "hoadon/hoadon";
	}
	
	@GetMapping("/revenue")
	public String filterHoaDonByYear(@RequestParam(value = "year", required = false, defaultValue = "2024") int year,
	                                 @RequestParam(value = "startMonth", required = false, defaultValue = "1") int startMonth,
	                                 @RequestParam(value = "endMonth", required = false, defaultValue = "12") int endMonth,
	                                 Model model) {
	    List<Object[]> monthlyRevenue = hoaDonService.getMonthlyRevenueByYearAndMonthRange(year, startMonth, endMonth);
	    model.addAttribute("monthlyRevenue", monthlyRevenue);
	    model.addAttribute("selectedYear", year);
	    model.addAttribute("years", hoaDonService.getDistinctYears());
	    model.addAttribute("startMonth", startMonth);
	    model.addAttribute("endMonth", endMonth);
	    return "hoadon/thongke";
	}

}
