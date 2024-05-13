package hung.pt.QuanLyBanHang.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hung.pt.QuanLyBanHang.Models.ThuongHieu;
import hung.pt.QuanLyBanHang.Services.ThuongHieuService;

@Controller
@RequestMapping("/thuonghieu")
public class ThuongHieuController {

    @Autowired
    private ThuongHieuService thuongHieuService;

    @GetMapping("/all")
    public String getAllThuongHieu(Model model) {
        List<ThuongHieu> dsThuongHieu = thuongHieuService.getAllThuongHieu();
        model.addAttribute("dsThuongHieu", dsThuongHieu);
        return "thuonghieu/thuonghieu";
    }

    @GetMapping("/add")
    public String addThuongHieuForm(Model model) {
        model.addAttribute("thuongHieu", new ThuongHieu());
        return "thuonghieu/them_th";
    }

    @PostMapping("/add")
    public String addThuongHieuSubmit(@ModelAttribute ThuongHieu thuongHieu) {
        thuongHieuService.saveThuongHieu(thuongHieu);
        return "redirect:/thuonghieu/all";
    }

    @GetMapping("/edit/{id}")
    public String editThuongHieuForm(@PathVariable("id") int id, Model model) {
        Optional<ThuongHieu> thuongHieu = thuongHieuService.getThuongHieuById(id);
        thuongHieu.ifPresent(hieu -> model.addAttribute("thuongHieu", hieu));
        return "thuonghieu/sua_th";
    }

    @PostMapping("/edit/{id}")
    public String editThuongHieuSubmit(@PathVariable("id") int id, @ModelAttribute ThuongHieu thuongHieu) {
        thuongHieu.setMaThuongHieu(id);
        thuongHieuService.saveThuongHieu(thuongHieu);
        return "redirect:/thuonghieu/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteThuongHieu(@PathVariable("id") int id) {
        thuongHieuService.deleteThuongHieuById(id);
        return "redirect:/thuonghieu/all";
    }
}

