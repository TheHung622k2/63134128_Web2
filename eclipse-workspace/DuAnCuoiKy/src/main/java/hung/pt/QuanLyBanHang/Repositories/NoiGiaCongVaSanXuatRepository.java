package hung.pt.QuanLyBanHang.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hung.pt.QuanLyBanHang.Models.NoiGiaCongVaSanXuat;

@Repository
public interface NoiGiaCongVaSanXuatRepository extends JpaRepository<NoiGiaCongVaSanXuat, Integer> {
    
	List<NoiGiaCongVaSanXuat> findByTenNoiGiaCongVaSanXuat(String tenNoiGiaCongVaSanXuat);
}
