package hung.pt.QuanLyBanHang.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hung.pt.QuanLyBanHang.Models.Loai;

@Repository
public interface LoaiRepository extends JpaRepository<Loai, Integer> {
	List<Loai> findByTenLoai(String tenLoai);
}