package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hung.pt.QuanLyBanHang.Models.HoaDon;
import hung.pt.QuanLyBanHang.Services.HoaDonService;

@Controller
@RequestMapping("/hoadon")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping("/all")
    public String getAllHoaDon(Model model) {
        List<HoaDon> dsHoaDon = hoaDonService.getAllHoaDon();
        model.addAttribute("dsHoaDon", dsHoaDon);
        return "hoadon/hoadon";
    }
}
