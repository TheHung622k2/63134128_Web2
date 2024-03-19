package hung.pt.DisplayListObjectPagination.services;

import org.springframework.stereotype.Service;
import hung.pt.DisplayListObjectPagination.models.SinhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public interface SinhVienService {
	public Page<SinhVien> findPaginated(Pageable pageable);
}