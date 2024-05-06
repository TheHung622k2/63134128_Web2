package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
