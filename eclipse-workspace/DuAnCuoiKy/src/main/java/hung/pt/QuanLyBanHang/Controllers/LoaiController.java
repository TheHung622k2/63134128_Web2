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

    @GetMapping("/add")
    public String addLoaiForm(Model model) {
        model.addAttribute("loai", new Loai());
        return "loai/them";
    }

    @PostMapping("/add")
    public String addLoaiSubmit(@ModelAttribute Loai loai) {
        loaiService.saveLoai(loai);
        return "redirect:/loai/all";
    }

    @GetMapping("/edit/{id}")
    public String editLoaiForm(@PathVariable("id") int id, Model model) {
        Optional<Loai> optionalLoai = loaiService.getLoaiById(id);
        if (optionalLoai.isPresent()) {
            model.addAttribute("loai", optionalLoai.get());
            return "loai/sua";
        } else {
            // Handle not found
            return "redirect:/loai/all";
        }
    }

    @PostMapping("/edit/{id}")
    public String editLoaiSubmit(@PathVariable("id") int id, @ModelAttribute Loai loai) {
        loai.setMaLoai(id); // Ensure the ID from the path is set to the object
        loaiService.saveLoai(loai);
        return "redirect:/loai/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteLoai(@PathVariable("id") int id) {
        loaiService.deleteLoaiById(id);
        return "redirect:/loai/all";
    }

    @GetMapping("/detail/{id}")
    public String detailLoai(@PathVariable("id") int id, Model model) {
        Optional<Loai> optionalLoai = loaiService.getLoaiById(id);
        if (optionalLoai.isPresent()) {
            model.addAttribute("loai", optionalLoai.get());
            return "loai/chitiet";
        } else {
            // Handle not found
            return "redirect:/loai/all";
        }
    }
}

