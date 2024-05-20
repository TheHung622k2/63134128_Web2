package hung.pt.QuanLyBanHang.Controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hung.pt.QuanLyBanHang.Models.NguoiDung;
import hung.pt.QuanLyBanHang.Services.NguoiDungService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/nguoidung")
public class NguoiDungController {

    @Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping("/all")
    public String getAllNguoiDung(Model model) {
        List<NguoiDung> dsNguoiDung = nguoiDungService.getAllNguoiDungs();
        // Lọc ra các tài khoản không phải là "Admin"
        List<NguoiDung> dsNhanVien = dsNguoiDung.stream()
                                                 .filter(nguoiDung -> !"Admin".equals(nguoiDung.getQuyen()))
                                                 .collect(Collectors.toList());
        model.addAttribute("dsNguoiDung", dsNhanVien);
        return "nguoidung/nguoidung";
    }

    @GetMapping("/dangnhap")
    public String signIn() {
        return "dangnhap/sign_in";
    }

    @PostMapping("/dangnhap")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        List<NguoiDung> nguoiDungs = nguoiDungService.getNguoiDungsByTenDangNhap(username);
        boolean isAuthenticated = false;
        NguoiDung authenticatedUser = null;

        for (NguoiDung nguoiDung : nguoiDungs) {
            if (nguoiDung.getMatKhau().equals(password)) {
                if (!nguoiDung.isTrangThai()) {
                    model.addAttribute("error", "Tài khoản của bạn tạm thời đang bị khóa!");
                    return "dangnhap/sign_in";
                }
                isAuthenticated = true;
                authenticatedUser = nguoiDung;
                break;
            }
        }

        if (isAuthenticated && authenticatedUser != null) {
            session.setAttribute("authenticatedUser", authenticatedUser);
            if ("Admin".equals(authenticatedUser.getQuyen())) {
                return "admin/admin";
            } else if ("Nhân viên".equals(authenticatedUser.getQuyen())) {
                return "employee/nhanvien";
            } else {
                model.addAttribute("error", "Không có quyền truy cập phù hợp!");
                return "dangnhap/sign_in";
            }
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu sai!");
            return "dangnhap/sign_in";
        }
    }

    @GetMapping("/dangky")
    public String signUp() {
        return "dangky/sign_up";
    }

    @PostMapping("/dangky")
    public String signUp(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("confirmPassword") String confirmPassword,
                         @RequestParam("hoVaTen") String hoVaTen,
                         @RequestParam("email") String email,
                         @RequestParam("sdt") String sdt,
                         @RequestParam("diaChi") String diaChi,
                         @RequestParam("ngaySinh") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaySinh,
                         Model model) {
        model.addAttribute("username", username);
        model.addAttribute("hoVaTen", hoVaTen);
        model.addAttribute("email", email);
        model.addAttribute("sdt", sdt);
        model.addAttribute("diaChi", diaChi);
        model.addAttribute("ngaySinh", ngaySinh);

        if (!password.equals(confirmPassword)) {
            model.addAttribute("confirmPasswordError", "Mật khẩu xác nhận không đúng!");
            return "dangky/sign_up";
        }

        List<NguoiDung> nguoiDungs = nguoiDungService.getNguoiDungsByTenDangNhap(username);
        for (NguoiDung nguoiDung : nguoiDungs) {
            if (nguoiDung.getMatKhau().equals(password)) {
                model.addAttribute("passwordError", "Mật khẩu bị trùng khớp! Xin vui lòng nhập một mật khẩu khác");
                return "dangky/sign_up";
            }
        }

        NguoiDung nguoiDung = new NguoiDung(username, "Nhân viên", password, hoVaTen, diaChi, sdt, ngaySinh, email, true);
        nguoiDungService.saveNguoiDung(nguoiDung);

        return "dangnhap/sign_in";
    }

    @GetMapping("/dangxuat")
    public String logout(HttpSession session) {
        session.removeAttribute("authenticatedUser");
        return "redirect:/home";
    }

    @GetMapping("/them")
    public String themNguoiDungForm(Model model) {
        model.addAttribute("nguoiDung", new NguoiDung());
        return "nguoidung/them";
    }

    @PostMapping("/them")
    public String themNguoiDung(NguoiDung nguoiDung) {
        nguoiDungService.saveNguoiDung(nguoiDung);
        return "redirect:/nguoidung/all";
    }

    @GetMapping("/sua/{id}")
    public String suaNguoiDungForm(@PathVariable("id") int id, Model model) {
        Optional<NguoiDung> optionalNguoiDung = nguoiDungService.getNguoiDungById(id);
        if (optionalNguoiDung.isPresent()) {
            model.addAttribute("nguoiDung", optionalNguoiDung.get());
            return "nguoidung/sua";
        } else {
            return "redirect:/nguoidung/all";
        }
    }

    @PostMapping("/sua")
    public String suaNguoiDung(@RequestParam("userId") int userId, NguoiDung nguoiDung) {
        nguoiDung.setUserId(userId);
        nguoiDungService.saveNguoiDung(nguoiDung);
        return "redirect:/nguoidung/all";
    }

    @GetMapping("/xoa/{id}")
    public String xoaNguoiDung(@PathVariable("id") int id) {
        nguoiDungService.deleteNguoiDungById(id);
        return "redirect:/nguoidung/all";
    }

    @GetMapping("/chitiet/{id}")
    public String chiTietNguoiDung(@PathVariable("id") int id, Model model) {
        Optional<NguoiDung> optionalNguoiDung = nguoiDungService.getNguoiDungById(id);
        if (optionalNguoiDung.isPresent()) {
            model.addAttribute("nguoiDung", optionalNguoiDung.get());
            return "nguoidung/chitiet";
        } else {
            return "redirect:/nguoidung/all";
        }
    }

    @PostMapping("/khoa")
    public String khoaNguoiDung(@RequestParam("userId") int userId) {
        nguoiDungService.updateTrangThaiNguoiDung(userId, false);
        return "redirect:/nguoidung/all";
    }

    @PostMapping("/mokhoa")
    public String moKhoaNguoiDung(@RequestParam("userId") int userId) {
        nguoiDungService.updateTrangThaiNguoiDung(userId, true);
        return "redirect:/nguoidung/all";
    }
    
    @PostMapping("/toggle")
    public String toggleNguoiDung(@RequestParam("userId") int userId) {
        Optional<NguoiDung> optionalNguoiDung = nguoiDungService.getNguoiDungById(userId);
        if (optionalNguoiDung.isPresent()) {
            NguoiDung nguoiDung = optionalNguoiDung.get();
            nguoiDung.setTrangThai(!nguoiDung.isTrangThai());
            nguoiDungService.saveNguoiDung(nguoiDung);
        }
        return "redirect:/nguoidung/all";
    }
}