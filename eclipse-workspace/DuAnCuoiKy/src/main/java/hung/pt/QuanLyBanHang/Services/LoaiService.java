package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import hung.pt.QuanLyBanHang.Models.Loai;

public interface LoaiService {

	List<Loai> getAllLoai();

	Optional<Loai> getLoaiById(int id);

	Loai saveLoai(Loai loai);

	void deleteLoaiById(int id);

	List<Loai> getLoaiByTenLoai(String tenLoai);
}