package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hung.pt.QuanLyBanHang.Models.NoiGiaCongVaSanXuat;
import hung.pt.QuanLyBanHang.Repositories.NoiGiaCongVaSanXuatRepository;

@Service
public class NoiGiaCongVaSanXuatServiceImpl implements NoiGiaCongVaSanXuatService {

    @Autowired
    private NoiGiaCongVaSanXuatRepository noiGiaCongVaSanXuatRepository;

    @Override
    public List<NoiGiaCongVaSanXuat> getAllNoiGiaCongVaSanXuat() {
        return noiGiaCongVaSanXuatRepository.findAll();
    }

    @Override
    public Optional<NoiGiaCongVaSanXuat> getNoiGiaCongVaSanXuatById(int id) {
        return noiGiaCongVaSanXuatRepository.findById(id);
    }

    @Override
    public NoiGiaCongVaSanXuat saveNoiGiaCongVaSanXuat(NoiGiaCongVaSanXuat noiGiaCongVaSanXuat) {
        return noiGiaCongVaSanXuatRepository.save(noiGiaCongVaSanXuat);
    }

    @Override
    public void deleteNoiGiaCongVaSanXuatById(int id) {
        noiGiaCongVaSanXuatRepository.deleteById(id);
    }

    @Override
    public List<NoiGiaCongVaSanXuat> getNoiGiaCongVaSanXuatByTenNoiGiaCongVaSanXuat(String tenNoiGiaCongVaSanXuat) {
        return noiGiaCongVaSanXuatRepository.findByTenNoiGiaCongVaSanXuat(tenNoiGiaCongVaSanXuat);
    }
}
