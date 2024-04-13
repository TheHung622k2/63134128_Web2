package hung.pt.QuanLyBanHang.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.models.KhachHang;

@Service
public interface KhachHangService {
	public List<KhachHang> getAllKhachHang();
	public KhachHang getKhachHangByID(String maKH);
}
