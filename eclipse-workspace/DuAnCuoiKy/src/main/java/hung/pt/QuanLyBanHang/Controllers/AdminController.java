package hung.pt.QuanLyBanHang.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    
    @GetMapping("/admin/admin.html")
    public String adminPage() {
        return "admin/admin";
    }
}