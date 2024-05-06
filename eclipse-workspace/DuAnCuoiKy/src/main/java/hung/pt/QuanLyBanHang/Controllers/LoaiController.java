package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hung.pt.QuanLyBanHang.Models.Loai;
import hung.pt.QuanLyBanHang.Services.LoaiService;

@Controller
@RequestMapping("/loai")
public class LoaiController {

    @Autowired
    private LoaiService loaiService;

    @GetMapping("/all")
    public String getAllLoai(Model model) {
        List<Loai> dsLoai = loaiService.getAllLoai();
        model.addAttribute("dsLoai", dsLoai);
        return "loai/loai";
    }
}
