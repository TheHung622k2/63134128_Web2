package hung.pt.QuanLyBanHang.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hung.pt.QuanLyBanHang.Models.ThuongHieu;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {
    
	List<ThuongHieu> findByTenThuongHieu(String tenThuongHieu);
}