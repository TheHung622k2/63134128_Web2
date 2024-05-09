package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "sanpham/sanpham";
    }
    
    @GetMapping("/them")
    public String themSanPhamForm(Model model) {
        model.addAttribute("sanPham", new SanPham());
        return "sanpham/them_sp";
    }

    @PostMapping("/them")
    public String themSanPham(SanPham sanPham) {
        sanPhamService.saveSanPham(sanPham);
        return "redirect:/sanpham/all";
    }

    @GetMapping("/sua/{id}")
    public String suaSanPhamForm(@PathVariable("id") int id, Model model) {
        Optional<SanPham> optionalSanPham = sanPhamService.getSanPhamById(id);
        if (optionalSanPham.isPresent()) {
            model.addAttribute("sanPham", optionalSanPham.get());
            return "sanpham/sua_sp";
        } else {
            return "redirect:/sanpham/all";
        }
    }

    @PostMapping("/sua")
    public String suaSanPham(@RequestParam("maSanPham") int maSanPham, SanPham sanPham) {
        sanPham.setMaSanPham(maSanPham);
        sanPhamService.saveSanPham(sanPham);
        return "redirect:/sanpham/all";
    }

    @GetMapping("/xoa/{id}")
    public String xoaSanPham(@PathVariable("id") int id) {
        sanPhamService.deleteSanPhamById(id);
        return "redirect:/sanpham/all";
    }

    @GetMapping("/chitiet/{id}")
    public String chiTietSanPham(@PathVariable("id") int id, Model model) {
        Optional<SanPham> optionalSanPham = sanPhamService.getSanPhamById(id);
        if (optionalSanPham.isPresent()) {
            model.addAttribute("sanPham", optionalSanPham.get());
            return "sanpham/chitiet_sp";
        } else {
            return "redirect:/sanpham/all";
        }
    }
}
