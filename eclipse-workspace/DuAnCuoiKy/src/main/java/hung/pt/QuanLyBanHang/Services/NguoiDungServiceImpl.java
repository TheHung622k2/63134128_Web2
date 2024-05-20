package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.NguoiDung;
import hung.pt.QuanLyBanHang.Repositories.NguoiDungRepository;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungRepository nguoiDungRepository;

	@Override
	public List<NguoiDung> getAllNguoiDungs() {
		return nguoiDungRepository.findAll();
	}

	@Override
	public Optional<NguoiDung> getNguoiDungById(int id) {
		return nguoiDungRepository.findById(id);
	}

	@Override
	public NguoiDung saveNguoiDung(NguoiDung nguoiDung) {
		return nguoiDungRepository.save(nguoiDung);
	}

	@Override
	public void deleteNguoiDungById(int id) {
		nguoiDungRepository.deleteById(id);
	}

	@Override
	public List<NguoiDung> getNguoiDungsByTenDangNhap(String tenDangNhap) {
		return nguoiDungRepository.findByTenDangNhap(tenDangNhap);
	}

	@Override
	public List<NguoiDung> getNguoiDungsByQuyen(String quyen) {
		return nguoiDungRepository.findByQuyen(quyen);
	}
	
	@Override
    public void updateTrangThaiNguoiDung(int id, boolean trangThai) {
        Optional<NguoiDung> optionalNguoiDung = nguoiDungRepository.findById(id);
        if (optionalNguoiDung.isPresent()) {
            NguoiDung nguoiDung = optionalNguoiDung.get();
            nguoiDung.setTrangThai(trangThai);
            nguoiDungRepository.save(nguoiDung);
        }
    }
}