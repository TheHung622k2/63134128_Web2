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
    public String getDistinctYears(Model model) {
        List<Integer> years = hoaDonService.getDistinctYears();
        model.addAttribute("years", years);
        return "hoadon/hoadon";
    }
	
	/*
	 * @GetMapping("/filter") public String filterHoaDonByYear(@RequestParam("year")
	 * int year, Model model) { List<Object[]> monthlyRevenue =
	 * hoaDonService.getMonthlyRevenueByYear(year);
	 * model.addAttribute("monthlyRevenue", monthlyRevenue);
	 * model.addAttribute("selectedYear", year); model.addAttribute("years",
	 * hoaDonService.getDistinctYears()); return "hoadon/chart"; }
	 */
	
	@GetMapping("/filter")
    public String filterHoaDonByYear(@RequestParam(value = "year", required = false, defaultValue = "2024") int year, Model model) {
        List<Object[]> monthlyRevenue = hoaDonService.getMonthlyRevenueByYear(year);
        model.addAttribute("monthlyRevenue", monthlyRevenue);
        model.addAttribute("selectedYear", year);
        model.addAttribute("years", hoaDonService.getDistinctYears());
        return "hoadon/thongke";
    }
}
