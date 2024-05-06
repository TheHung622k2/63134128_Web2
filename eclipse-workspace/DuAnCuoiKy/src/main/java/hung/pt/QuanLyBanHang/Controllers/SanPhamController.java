package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hung.pt.QuanLyBanHang.Models.SanPham;
import hung.pt.QuanLyBanHang.Services.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/all")
    public String getAllSanPhams(Model model) {
        List<SanPham> dsSanPham = sanPhamService.getAllSanPhams();
        model.addAttribute("dsSanPham", dsSanPham);
        return "test";
    }
}