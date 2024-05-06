package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.Loai;
import hung.pt.QuanLyBanHang.Repositories.LoaiRepository;

@Service
public class LoaiServiceImpl implements LoaiService {

    @Autowired
    private LoaiRepository loaiRepository;

    @Override
    public List<Loai> getAllLoai() {
        return loaiRepository.findAll();
    }

    @Override
    public Optional<Loai> getLoaiById(int id) {
        return loaiRepository.findById(id);
    }

    @Override
    public Loai saveLoai(Loai loai) {
        return loaiRepository.save(loai);
    }

    @Override
    public void deleteLoaiById(int id) {
        loaiRepository.deleteById(id);
    }

    @Override
    public List<Loai> getLoaiByTenLoai(String tenLoai) {
        return loaiRepository.findByTenLoai(tenLoai);
    }
}