package hung.pt.QuanLyBanHang.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.ThanhVien;

@Service
public interface ThanhVienService {
	public List<ThanhVien> getAllThanhVien();
	public ThanhVien getThanhVienByID(int id);
}
