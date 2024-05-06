package hung.pt.QuanLyBanHang.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hung.pt.QuanLyBanHang.Models.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer>{
	
	List<NguoiDung> findByTenDangNhap(String tenDangNhap);
    
    List<NguoiDung> findByQuyen(String quyen);
}
