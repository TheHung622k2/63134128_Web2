package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import hung.pt.QuanLyBanHang.Models.NguoiDung;

public interface NguoiDungService {

	List<NguoiDung> getAllNguoiDungs();

	Optional<NguoiDung> getNguoiDungById(int id);

	NguoiDung saveNguoiDung(NguoiDung nguoiDung);

	void deleteNguoiDungById(int id);

	List<NguoiDung> getNguoiDungsByTenDangNhap(String tenDangNhap);

	List<NguoiDung> getNguoiDungsByQuyen(String quyen);
	
	void updateTrangThaiNguoiDung(int id, boolean trangThai);
}