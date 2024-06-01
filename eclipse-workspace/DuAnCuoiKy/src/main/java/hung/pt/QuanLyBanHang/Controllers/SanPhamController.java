package hung.pt.QuanLyBanHang.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hung.pt.QuanLyBanHang.Models.Loai;
import hung.pt.QuanLyBanHang.Models.NhaCungCap;
import hung.pt.QuanLyBanHang.Models.NoiGiaCongVaSanXuat;
import hung.pt.QuanLyBanHang.Models.SanPham;
import hung.pt.QuanLyBanHang.Models.ThuongHieu;
import hung.pt.QuanLyBanHang.Services.LoaiService;
import hung.pt.QuanLyBanHang.Services.NhaCungCapService;
import hung.pt.QuanLyBanHang.Services.NoiGiaCongVaSanXuatService;
import hung.pt.QuanLyBanHang.Services.SanPhamService;
import hung.pt.QuanLyBanHang.Services.ThuongHieuService;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
	
	private static final String UPLOAD_DIR = "src/main/resources/static/products/";

    @Autowired
    private SanPhamService sanPhamService;
    
    @Autowired
    private NhaCungCapService nhaCungCapService;
    
    @Autowired
    private LoaiService loaiService;
    
    @Autowired
    private ThuongHieuService thuongHieuService;
    
    @Autowired
    private NoiGiaCongVaSanXuatService noiGiaCongVaSanXuatService;

    @GetMapping("/all")
    public String getAllSanPhams(@RequestParam(defaultValue = "0") int page, 
                                 @RequestParam(defaultValue = "") String keyword, 
                                 @RequestParam(defaultValue = "") String nhaCungCapId,
                                 @RequestParam(defaultValue = "") String loaiId,
                                 @RequestParam(defaultValue = "") String thuongHieuId,
                                 @RequestParam(defaultValue = "") String noiGiaCongVaSanXuatId,
                                 Model model) {
        Pageable pageable = PageRequest.of(page, 10); // 10 sản phẩm mỗi trang
        Page<SanPham> dsSanPham;

        Integer nccId = nhaCungCapId.isEmpty() ? null : Integer.parseInt(nhaCungCapId);
        Integer lId = loaiId.isEmpty() ? null : Integer.parseInt(loaiId);
        Integer thId = thuongHieuId.isEmpty() ? null : Integer.parseInt(thuongHieuId);
        Integer ngcvsxId = noiGiaCongVaSanXuatId.isEmpty() ? null : Integer.parseInt(noiGiaCongVaSanXuatId);

        if (!keyword.isEmpty() || nccId != null || lId != null || thId != null || ngcvsxId != null) {
            dsSanPham = sanPhamService.filterSanPhams(keyword, nccId, lId, thId, ngcvsxId, pageable);
        } else {
            dsSanPham = sanPhamService.getAllSanPhams(pageable);
        }

        List<NhaCungCap> listNhaCungCap = nhaCungCapService.getAllNhaCungCap();
        List<Loai> listLoai = loaiService.getAllLoai();
        List<ThuongHieu> listThuongHieu = thuongHieuService.getAllThuongHieu();
        List<NoiGiaCongVaSanXuat> listNoiGiaCongVaSanXuat = noiGiaCongVaSanXuatService.getAllNoiGiaCongVaSanXuat();

        model.addAttribute("dsSanPham", dsSanPham);
        model.addAttribute("keyword", keyword);
        model.addAttribute("listNhaCungCap", listNhaCungCap);
        model.addAttribute("listLoai", listLoai);
        model.addAttribute("listThuongHieu", listThuongHieu);
        model.addAttribute("listNoiGiaCongVaSanXuat", listNoiGiaCongVaSanXuat);

        model.addAttribute("nhaCungCapId", nhaCungCapId);
        model.addAttribute("loaiId", loaiId);
        model.addAttribute("thuongHieuId", thuongHieuId);
        model.addAttribute("noiGiaCongVaSanXuatId", noiGiaCongVaSanXuatId);

        return "sanpham/sanpham";
    }

    @GetMapping("/them")
    public String themSanPhamForm(Model model) {
        model.addAttribute("sanPham", new SanPham());
        
        // Truy vấn danh sách nhà cung cấp và thêm vào model
        List<NhaCungCap> listNhaCungCap = nhaCungCapService.getAllNhaCungCap();
        model.addAttribute("listNhaCungCap", listNhaCungCap);
        
        // Truy vấn danh sách loại và thêm vào model
        List<Loai> listLoai = loaiService.getAllLoai();
        model.addAttribute("listLoai", listLoai);
        
        // Truy vấn danh sách thương hiệu và thêm vào model
        List<ThuongHieu> listThuongHieu = thuongHieuService.getAllThuongHieu();
        model.addAttribute("listThuongHieu", listThuongHieu);
        
        // Truy vấn danh sách nơi gia công và sản xuất và thêm vào model
        List<NoiGiaCongVaSanXuat> listNoiGiaCongVaSanXuat = noiGiaCongVaSanXuatService.getAllNoiGiaCongVaSanXuat();
        model.addAttribute("listNoiGiaCongVaSanXuat", listNoiGiaCongVaSanXuat);

        return "sanpham/them_sp";
    }

    @PostMapping("/them")
    public String themSanPham(@ModelAttribute("sanPham") SanPham sanPham, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR + fileName);
                
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                sanPham.setAnhSp("/products/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "File upload failed!");
                return "redirect:/sanpham/them";
            }
        }
        sanPhamService.saveSanPham(sanPham);
        return "redirect:/sanpham/all";
    }

    @GetMapping("/sua/{id}")
    public String suaSanPhamForm(@PathVariable("id") int id, Model model) {
        Optional<SanPham> optionalSanPham = sanPhamService.getSanPhamById(id);
        if (optionalSanPham.isPresent()) {
            model.addAttribute("sanPham", optionalSanPham.get());
            // Truy vấn danh sách nhà cung cấp và thêm vào model
            List<NhaCungCap> listNhaCungCap = nhaCungCapService.getAllNhaCungCap();
            model.addAttribute("listNhaCungCap", listNhaCungCap);
            
            // Truy vấn danh sách loại và thêm vào model
            List<Loai> listLoai = loaiService.getAllLoai();
            model.addAttribute("listLoai", listLoai);
            
            // Truy vấn danh sách thương hiệu và thêm vào model
            List<ThuongHieu> listThuongHieu = thuongHieuService.getAllThuongHieu();
            model.addAttribute("listThuongHieu", listThuongHieu);
            
            // Truy vấn danh sách nơi gia công và sản xuất và thêm vào model
            List<NoiGiaCongVaSanXuat> listNoiGiaCongVaSanXuat = noiGiaCongVaSanXuatService.getAllNoiGiaCongVaSanXuat();
            model.addAttribute("listNoiGiaCongVaSanXuat", listNoiGiaCongVaSanXuat);

            return "sanpham/sua_sp";
        } else {
            return "redirect:/sanpham/all";
        }
    }

    @PostMapping("/sua")
    public String suaSanPham(@RequestParam("maSanPham") int maSanPham, @ModelAttribute("sanPham") SanPham sanPham, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        Optional<SanPham> existingSanPhamOpt = sanPhamService.getSanPhamById(maSanPham);
        if (existingSanPhamOpt.isPresent()) {
            SanPham existingSanPham = existingSanPhamOpt.get();

            if (file != null && !file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR + fileName);
                try {
                    Files.write(path, file.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    sanPham.setAnhSp("/products/" + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message", "Tải tệp thất bại!");
                    return "redirect:/sanpham/sua/" + maSanPham;
                }
            } else {
                sanPham.setAnhSp(existingSanPham.getAnhSp());
            }

            sanPham.setMaSanPham(maSanPham);
            sanPhamService.saveSanPham(sanPham);
        }
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
