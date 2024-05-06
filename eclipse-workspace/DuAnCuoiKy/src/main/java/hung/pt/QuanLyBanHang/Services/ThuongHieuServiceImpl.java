package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.ThuongHieu;
import hung.pt.QuanLyBanHang.Repositories.ThuongHieuRepository;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

	@Autowired
	private ThuongHieuRepository thuongHieuRepository;

	@Override
	public List<ThuongHieu> getAllThuongHieu() {
		return thuongHieuRepository.findAll();
	}

	@Override
	public Optional<ThuongHieu> getThuongHieuById(int id) {
		return thuongHieuRepository.findById(id);
	}

	@Override
	public ThuongHieu saveThuongHieu(ThuongHieu thuongHieu) {
		return thuongHieuRepository.save(thuongHieu);
	}

	@Override
	public void deleteThuongHieuById(int id) {
		thuongHieuRepository.deleteById(id);
	}

	@Override
	public List<ThuongHieu> getThuongHieuByTenThuongHieu(String tenThuongHieu) {
		return thuongHieuRepository.findByTenThuongHieu(tenThuongHieu);
	}
}
