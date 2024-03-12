package hung.pt.DisplayListObject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import hung.pt.DisplayListObject.models.SinhVien;

@Controller
public class SinhVienController {
	// hard-code dữ liệu
	static List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static {
		dsSinhVien.add(new SinhVien("0001", "Lê Văn A"));
		dsSinhVien.add(new SinhVien("0002", "Trần Đức B"));
		dsSinhVien.add(new SinhVien("0003", "Phạm Văn C"));
		dsSinhVien.add(new SinhVien("0004", "Nguyễn Xuân D"));
		dsSinhVien.add(new SinhVien("0005", "Lê Đức H"));
	}
	
	@GetMapping("/danhSachSV")
	public String listStudent(ModelMap mm) {
		mm.addAttribute("dsSV", dsSinhVien);
		return "sinhvien_getAll";
	}
}
