package hung.pt.QuanLyBanHang.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hung.pt.QuanLyBanHang.Models.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

	List<SanPham> findByTenSanPham(String tenSanPham);

	List<SanPham> findByGiaTienBetween(float minGiaTien, float maxGiaTien);
	
	Page<SanPham> findAll(Pageable pageable);
	
	Page<SanPham> findByTenSanPhamContaining(String tenSanPham, Pageable pageable);
	
	@Query("SELECT sp FROM SanPham sp WHERE "
	         + "(:keyword IS NULL OR sp.tenSanPham LIKE %:keyword%) AND "
	         + "(:nhaCungCapId IS NULL OR sp.nhaCungCap.maNhaCungCap = :nhaCungCapId) AND "
	         + "(:loaiId IS NULL OR sp.loai.maLoai = :loaiId) AND "
	         + "(:thuongHieuId IS NULL OR sp.thuongHieu.maThuongHieu = :thuongHieuId) AND "
	         + "(:noiGiaCongVaSanXuatId IS NULL OR sp.noiGiaCongVaSanXuat.maNoiGiaCongVaSanXuat = :noiGiaCongVaSanXuatId)")
	    Page<SanPham> findByFilters(@Param("keyword") String keyword,
	                                @Param("nhaCungCapId") Integer nhaCungCapId,
	                                @Param("loaiId") Integer loaiId,
	                                @Param("thuongHieuId") Integer thuongHieuId,
	                                @Param("noiGiaCongVaSanXuatId") Integer noiGiaCongVaSanXuatId,
	                                Pageable pageable);
}