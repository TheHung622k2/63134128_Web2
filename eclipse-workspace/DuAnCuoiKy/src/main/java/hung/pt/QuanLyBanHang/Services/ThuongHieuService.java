package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import hung.pt.QuanLyBanHang.Models.ThuongHieu;

public interface ThuongHieuService {

    List<ThuongHieu> getAllThuongHieu();

    Optional<ThuongHieu> getThuongHieuById(int id);

    ThuongHieu saveThuongHieu(ThuongHieu thuongHieu);

    void deleteThuongHieuById(int id);

    List<ThuongHieu> getThuongHieuByTenThuongHieu(String tenThuongHieu);
}
