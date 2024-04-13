package hung.pt.QuanLyBanHang.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hung.pt.QuanLyBanHang.models.KhachHang;
import hung.pt.QuanLyBanHang.services.KhachHangService;

@RestController
public class KhachHangController {
	@Autowired KhachHangService khachHangService;
	@GetMapping("/dsKhachHang")
	public List<KhachHang> getAllKhachHang()
	{
		return khachHangService.getAllKhachHang();
	}
}
