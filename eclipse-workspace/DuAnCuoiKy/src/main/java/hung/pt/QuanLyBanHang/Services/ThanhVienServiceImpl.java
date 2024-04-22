package hung.pt.QuanLyBanHang.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.ThanhVien;
import hung.pt.QuanLyBanHang.Repositories.ThanhVienRepository;

@Service
public class ThanhVienServiceImpl implements ThanhVienService {
	
	@Autowired ThanhVienRepository thanhVienRepository; // Inject vào để sd các dịch vụ

	@Override
	public List<ThanhVien> getAllThanhVien() {
		return thanhVienRepository.findAll();
	}

	@Override
	public ThanhVien getThanhVienByID(int id) {
		return thanhVienRepository.getReferenceById(id);
	}
}
