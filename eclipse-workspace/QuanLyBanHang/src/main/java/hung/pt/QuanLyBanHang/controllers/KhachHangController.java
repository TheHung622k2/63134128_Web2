package hung.pt.QuanLyBanHang.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import hung.pt.QuanLyBanHang.models.KhachHang;
import hung.pt.QuanLyBanHang.services.KhachHangService;

@Controller
@RequestMapping("/customer")
public class KhachHangController {
	@Autowired KhachHangService customerService;
	@GetMapping("/all")
	public String getAll(Model model) {
		List<KhachHang> dsKH = customerService.getAllKhachHang();
		model.addAttribute("dsKhachHang", dsKH);
		return "index";
	}
}