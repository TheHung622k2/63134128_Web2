package hung.pt.QuanLyBanHang.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.models.KhachHang;
import hung.pt.QuanLyBanHang.repositories.KhachHangRepository;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	
	@Autowired KhachHangRepository khachHangRepository; // Inject vào để sd các dịch vụ

	@Override
	public List<KhachHang> getAllKhachHang() {	
		return khachHangRepository.findAll();
	}

	@Override
	public KhachHang getKhachHangByID(String maKH) {
		return khachHangRepository.getById(maKH);
	}

}
