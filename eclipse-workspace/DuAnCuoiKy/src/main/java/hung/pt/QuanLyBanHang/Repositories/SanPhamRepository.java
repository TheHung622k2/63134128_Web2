package hung.pt.QuanLyBanHang.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hung.pt.QuanLyBanHang.Models.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

	List<SanPham> findByTenSanPham(String tenSanPham);

	List<SanPham> findByGiaTienBetween(float minGiaTien, float maxGiaTien);
	
	Page<SanPham> findAll(Pageable pageable);
	
	Page<SanPham> findByTenSanPhamContaining(String tenSanPham, Pageable pageable);	
}