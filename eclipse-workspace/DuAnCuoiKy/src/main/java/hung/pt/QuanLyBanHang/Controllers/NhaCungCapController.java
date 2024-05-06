package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hung.pt.QuanLyBanHang.Models.NhaCungCap;
import hung.pt.QuanLyBanHang.Services.NhaCungCapService;

@Controller
@RequestMapping("/nhacungcap")
public class NhaCungCapController {

	@Autowired
	private NhaCungCapService nhaCungCapService;

	@GetMapping("/all")
	public String getAllNhaCungCap(Model model) {
		List<NhaCungCap> dsNhaCungCap = nhaCungCapService.getAllNhaCungCap();
		model.addAttribute("dsNhaCungCap", dsNhaCungCap);
		return "nhacungcap/nhacungcap";
	}
}
