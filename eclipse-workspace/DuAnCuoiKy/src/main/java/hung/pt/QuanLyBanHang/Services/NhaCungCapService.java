package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import hung.pt.QuanLyBanHang.Models.NhaCungCap;

public interface NhaCungCapService {

	List<NhaCungCap> getAllNhaCungCap();

	Optional<NhaCungCap> getNhaCungCapById(int id);

	NhaCungCap saveNhaCungCap(NhaCungCap nhaCungCap);

	void deleteNhaCungCapById(int id);

	List<NhaCungCap> getNhaCungCapByTenNhaCungCap(String tenNhaCungCap);
}
