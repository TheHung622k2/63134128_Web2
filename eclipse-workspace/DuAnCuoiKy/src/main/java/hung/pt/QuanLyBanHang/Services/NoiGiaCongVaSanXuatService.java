package hung.pt.QuanLyBanHang.Services;

import java.util.List;
import java.util.Optional;

import hung.pt.QuanLyBanHang.Models.NoiGiaCongVaSanXuat;

public interface NoiGiaCongVaSanXuatService {

	List<NoiGiaCongVaSanXuat> getAllNoiGiaCongVaSanXuat();

	Optional<NoiGiaCongVaSanXuat> getNoiGiaCongVaSanXuatById(int id);

	NoiGiaCongVaSanXuat saveNoiGiaCongVaSanXuat(NoiGiaCongVaSanXuat noiGiaCongVaSanXuat);

	void deleteNoiGiaCongVaSanXuatById(int id);

	List<NoiGiaCongVaSanXuat> getNoiGiaCongVaSanXuatByTenNoiGiaCongVaSanXuat(String tenNoiGiaCongVaSanXuat);
}
