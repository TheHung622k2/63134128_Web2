package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.SanPham;
import hung.pt.QuanLyBanHang.Repositories.SanPhamRepository;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	private SanPhamRepository sanPhamRepository;

	@Override
	public List<SanPham> getAllSanPhams() {
		return sanPhamRepository.findAll();
	}

	@Override
	public Optional<SanPham> getSanPhamById(int id) {
		return sanPhamRepository.findById(id);
	}

	@Override
	public SanPham saveSanPham(SanPham sanPham) {
		return sanPhamRepository.save(sanPham);
	}

	@Override
	public void deleteSanPhamById(int id) {
		sanPhamRepository.deleteById(id);
	}

	@Override
	public List<SanPham> getSanPhamsByTenSanPham(String tenSanPham) {
		return sanPhamRepository.findByTenSanPham(tenSanPham);
	}

	@Override
	public List<SanPham> getSanPhamsByGiaTienBetween(float minGiaTien, float maxGiaTien) {
		return sanPhamRepository.findByGiaTienBetween(minGiaTien, maxGiaTien);
	}
}