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

import hung.pt.QuanLyBanHang.Models.NoiGiaCongVaSanXuat;
import hung.pt.QuanLyBanHang.Services.NoiGiaCongVaSanXuatService;

@Controller
@RequestMapping("/noigiacongvasanxuat")
public class NoiGiaCongVaSanXuatController {

    @Autowired
    private NoiGiaCongVaSanXuatService noiGiaCongVaSanXuatService;

    @GetMapping("/all")
    public String getAllNoiGiaCongVaSanXuat(Model model) {
        List<NoiGiaCongVaSanXuat> dsNoiGiaCongVaSanXuat = noiGiaCongVaSanXuatService.getAllNoiGiaCongVaSanXuat();
        model.addAttribute("dsNoiGiaCongVaSanXuat", dsNoiGiaCongVaSanXuat);
        return "noigiacongvasanxuat/noigiacongvasanxuat";
    }

    @GetMapping("/add")
    public String addNoiGiaCongVaSanXuatForm(Model model) {
        model.addAttribute("noiGiaCongVaSanXuat", new NoiGiaCongVaSanXuat());
        return "noigiacongvasanxuat/them";
    }

    @PostMapping("/add")
    public String addNoiGiaCongVaSanXuatSubmit(@ModelAttribute NoiGiaCongVaSanXuat noiGiaCongVaSanXuat) {
        noiGiaCongVaSanXuatService.saveNoiGiaCongVaSanXuat(noiGiaCongVaSanXuat);
        return "redirect:/noigiacongvasanxuat/all";
    }

    @GetMapping("/edit/{id}")
    public String editNoiGiaCongVaSanXuatForm(@PathVariable("id") int id, Model model) {
        Optional<NoiGiaCongVaSanXuat> optionalNoiGiaCongVaSanXuat = noiGiaCongVaSanXuatService.getNoiGiaCongVaSanXuatById(id);
        if (optionalNoiGiaCongVaSanXuat.isPresent()) {
            model.addAttribute("noiGiaCongVaSanXuat", optionalNoiGiaCongVaSanXuat.get());
            return "noigiacongvasanxuat/sua";
        } else {
            // Handle not found
            return "redirect:/noigiacongvasanxuat/all";
        }
    }

    @PostMapping("/edit/{id}")
    public String editNoiGiaCongVaSanXuatSubmit(@PathVariable("id") int id, @ModelAttribute NoiGiaCongVaSanXuat noiGiaCongVaSanXuat) {
        noiGiaCongVaSanXuat.setMaNoiGiaCongVaSanXuat(id); // Ensure the ID from the path is set to the object
        noiGiaCongVaSanXuatService.saveNoiGiaCongVaSanXuat(noiGiaCongVaSanXuat);
        return "redirect:/noigiacongvasanxuat/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteNoiGiaCongVaSanXuat(@PathVariable("id") int id) {
        noiGiaCongVaSanXuatService.deleteNoiGiaCongVaSanXuatById(id);
        return "redirect:/noigiacongvasanxuat/all";
    }

    @GetMapping("/detail/{id}")
    public String detailNoiGiaCongVaSanXuat(@PathVariable("id") int id, Model model) {
        Optional<NoiGiaCongVaSanXuat> optionalNoiGiaCongVaSanXuat = noiGiaCongVaSanXuatService.getNoiGiaCongVaSanXuatById(id);
        if (optionalNoiGiaCongVaSanXuat.isPresent()) {
            model.addAttribute("noiGiaCongVaSanXuat", optionalNoiGiaCongVaSanXuat.get());
            return "noigiacongvasanxuat/chitiet";
        } else {
            // Handle not found
            return "redirect:/noigiacongvasanxuat/all";
        }
    }
}