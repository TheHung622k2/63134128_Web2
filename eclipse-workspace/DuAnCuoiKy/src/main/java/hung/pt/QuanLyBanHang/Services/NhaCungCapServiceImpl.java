package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.NhaCungCap;
import hung.pt.QuanLyBanHang.Repositories.NhaCungCapRepository;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

	@Autowired
	private NhaCungCapRepository nhaCungCapRepository;

	@Override
	public List<NhaCungCap> getAllNhaCungCap() {
		return nhaCungCapRepository.findAll();
	}

	@Override
	public Optional<NhaCungCap> getNhaCungCapById(int id) {
		return nhaCungCapRepository.findById(id);
	}

	@Override
	public NhaCungCap saveNhaCungCap(NhaCungCap nhaCungCap) {
		return nhaCungCapRepository.save(nhaCungCap);
	}

	@Override
	public void deleteNhaCungCapById(int id) {
		nhaCungCapRepository.deleteById(id);
	}

	@Override
	public List<NhaCungCap> getNhaCungCapByTenNhaCungCap(String tenNhaCungCap) {
		return nhaCungCapRepository.findByTenNhaCungCap(tenNhaCungCap);
	}
}
