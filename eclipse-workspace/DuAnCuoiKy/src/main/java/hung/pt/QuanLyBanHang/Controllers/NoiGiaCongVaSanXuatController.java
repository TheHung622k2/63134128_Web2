package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hung.pt.QuanLyBanHang.Models.NoiGiaCongVaSanXuat;
import hung.pt.QuanLyBanHang.Services.NoiGiaCongVaSanXuatService;

@Controller
@RequestMapping("/noigiacongvasanxuat")
public class NoiGiaCongVaSanXuatController {

	@Autowired
	private NoiGiaCongVaSanXuatService noiGiaCongVaSanXuatService;

	@GetMapping("/all")
	public String getAllNoiGiaCongVaSanXuat(Model model) {
		List<NoiGiaCongVaSanXuat> dsNoiGiaCongVaSanXuat = noiGiaCongVaSanXuatService.getAllNoiGiaCongVaSanXuat();
		model.addAttribute("dsNoiGiaCongVaSanXuat", dsNoiGiaCongVaSanXuat);
		return "noigiacongvasanxuat/noigiacongvasanxuat";
	}
}
