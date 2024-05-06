package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hung.pt.QuanLyBanHang.Models.ThuongHieu;
import hung.pt.QuanLyBanHang.Services.ThuongHieuService;

@Controller
@RequestMapping("/thuonghieu")
public class ThuongHieuController {

	@Autowired
	private ThuongHieuService thuongHieuService;

	@GetMapping("/all")
	public String getAllThuongHieu(Model model) {
		List<ThuongHieu> dsThuongHieu = thuongHieuService.getAllThuongHieu();
		model.addAttribute("dsThuongHieu", dsThuongHieu);
		return "thuonghieu/thuonghieu";
	}
}
