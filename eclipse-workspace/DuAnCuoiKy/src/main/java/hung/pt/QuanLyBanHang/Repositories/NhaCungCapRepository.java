package hung.pt.QuanLyBanHang.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hung.pt.QuanLyBanHang.Models.NhaCungCap;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer> {

	List<NhaCungCap> findByTenNhaCungCap(String tenNhaCungCap);
}
