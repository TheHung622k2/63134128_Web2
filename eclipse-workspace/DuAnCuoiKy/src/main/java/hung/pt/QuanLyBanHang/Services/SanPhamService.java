package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import hung.pt.QuanLyBanHang.Models.SanPham;

public interface SanPhamService {

	List<SanPham> getAllSanPhams();

	Optional<SanPham> getSanPhamById(int id);

	SanPham saveSanPham(SanPham sanPham);

	void deleteSanPhamById(int id);

	List<SanPham> getSanPhamsByTenSanPham(String tenSanPham);

	List<SanPham> getSanPhamsByGiaTienBetween(float minGiaTien, float maxGiaTien);
}