package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hung.pt.QuanLyBanHang.Models.NguoiDung;
import hung.pt.QuanLyBanHang.Services.NguoiDungService;

@Controller
@RequestMapping("/nguoidung")
public class NguoiDungController {

	@Autowired
	private NguoiDungService nguoiDungService;

	@GetMapping("/all")
	public String getAllNguoiDung(Model model) {
		List<NguoiDung> dsNguoiDung = nguoiDungService.getAllNguoiDungs();
		model.addAttribute("dsNguoiDung", dsNguoiDung);
		return "nguoidung/nguoidung";
	}
	
	@GetMapping("/dangnhap")
	public String signIn() {
	    return "dangnhap/sign_in"; // trả về trang đăng nhập
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
	                    @RequestParam("password") String password, Model model) {
	    List<NguoiDung> nguoiDungs = nguoiDungService.getNguoiDungsByTenDangNhap(username);
	    boolean isAuthenticated = false;

	    for (NguoiDung nguoiDung : nguoiDungs) {
	        if (nguoiDung.getMatKhau().equals(password)) {
	            isAuthenticated = true;
	            break;
	        }
	    }

	    if (isAuthenticated) {
	        return "admin/admin"; // chuyển hướng tới admin.html
	    } else {
	        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
	        return "dangnhap/sign_in"; // trả về trang đăng nhập với thông báo lỗi
	    }
	}
}
