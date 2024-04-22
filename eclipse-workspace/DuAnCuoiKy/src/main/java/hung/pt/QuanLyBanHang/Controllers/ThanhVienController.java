package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hung.pt.QuanLyBanHang.Models.ThanhVien;
import hung.pt.QuanLyBanHang.Services.ThanhVienService;

@Controller
@RequestMapping("/thanhvien")
public class ThanhVienController {
	@Autowired ThanhVienService thanhVienService;
	@GetMapping("/all")
	public String getAll(Model model) {
		List<ThanhVien> dsTV = thanhVienService.getAllThanhVien();
		model.addAttribute("dsThanhVien", dsTV);
		return "thanhvien";
	}
}
