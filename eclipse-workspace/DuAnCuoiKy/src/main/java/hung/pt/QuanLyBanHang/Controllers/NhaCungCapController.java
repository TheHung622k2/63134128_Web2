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

import hung.pt.QuanLyBanHang.Models.NhaCungCap;
import hung.pt.QuanLyBanHang.Services.NhaCungCapService;

@Controller
@RequestMapping("/nhacungcap")
public class NhaCungCapController {

    @Autowired
    private NhaCungCapService nhaCungCapService;

    @GetMapping("/all")
    public String getAllNhaCungCap(Model model) {
        List<NhaCungCap> dsNhaCungCap = nhaCungCapService.getAllNhaCungCap();
        model.addAttribute("dsNhaCungCap", dsNhaCungCap);
        return "nhacungcap/nhacungcap";
    }

    @GetMapping("/detail/{id}")
    public String getNhaCungCapDetail(@PathVariable("id") int id, Model model) {
        Optional<NhaCungCap> nhaCungCap = nhaCungCapService.getNhaCungCapById(id);
        if (nhaCungCap.isPresent()) {
            model.addAttribute("nhaCungCap", nhaCungCap.get());
            return "nhacungcap/chitiet_ncc";
        } else {
            return "redirect:/nhacungcap/all";
        }
    }

    @GetMapping("/edit/{id}")
    public String editNhaCungCap(@PathVariable("id") int id, Model model) {
        Optional<NhaCungCap> nhaCungCap = nhaCungCapService.getNhaCungCapById(id);
        if (nhaCungCap.isPresent()) {
            model.addAttribute("nhaCungCap", nhaCungCap.get());
            return "nhacungcap/sua_ncc";
        } else {
            return "redirect:/nhacungcap/all";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateNhaCungCap(@PathVariable("id") int id, @ModelAttribute("nhaCungCap") NhaCungCap nhaCungCap) {
        nhaCungCap.setMaNhaCungCap(id);
        nhaCungCapService.saveNhaCungCap(nhaCungCap);
        return "redirect:/nhacungcap/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhaCungCap(@PathVariable("id") int id) {
        nhaCungCapService.deleteNhaCungCapById(id);
        return "redirect:/nhacungcap/all";
    }

    @GetMapping("/add")
    public String addNhaCungCapForm(Model model) {
        model.addAttribute("nhaCungCap", new NhaCungCap());
        return "nhacungcap/them_ncc";
    }

    @PostMapping("/add")
    public String addNhaCungCap(@ModelAttribute("nhaCungCap") NhaCungCap nhaCungCap) {
        nhaCungCapService.saveNhaCungCap(nhaCungCap);
        return "redirect:/nhacungcap/all";
    }
}

