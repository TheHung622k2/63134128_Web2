package hung.pt.QuanLyBanHang.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NhanVienController {

	@GetMapping("/nhanvien/nhanvien.html")
	public String nhanVienPage() {
        return "employee/nhanvien";
    }
}
