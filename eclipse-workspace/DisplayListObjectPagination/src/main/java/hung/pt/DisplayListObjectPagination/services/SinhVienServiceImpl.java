package hung.pt.DisplayListObjectPagination.services;

import org.springframework.stereotype.Service;

import hung.pt.DisplayListObjectPagination.models.SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class SinhVienServiceImpl implements SinhVienService {
	// Ta hard-code dữ liệu tại đây để tiện demo------
	static List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	static {
		dsSinhVien.add(new SinhVien("001", "Nguyễn Thị Hương"));
		dsSinhVien.add(new SinhVien("002", "Lê Minh Khánh"));
		dsSinhVien.add(new SinhVien("003", "Võ Thị Lan Anh"));
		dsSinhVien.add(new SinhVien("004", "Nguyễn Văn Nam"));
		dsSinhVien.add(new SinhVien("005", "Đặng Thị Ngọc Trâm"));
		dsSinhVien.add(new SinhVien("006", "Hoàng Minh Tuấn"));
		dsSinhVien.add(new SinhVien("007", "Lê Thị Thu Thảo"));
		dsSinhVien.add(new SinhVien("008", "Nguyễn Văn Phúc"));
		dsSinhVien.add(new SinhVien("009", "Trần Thị Hương Ly"));
		dsSinhVien.add(new SinhVien("010", "Phan Văn Đức"));
		dsSinhVien.add(new SinhVien("011", "Đỗ Thị Hồng Nhung"));
		dsSinhVien.add(new SinhVien("012", "Lê Văn Duy"));
	}

	// ----------hết phần hard-code dữ liệu ---------------------
	@Override
	public Page<SinhVien> findPaginated(Pageable pageable) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<SinhVien> list;

		if (dsSinhVien.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, dsSinhVien.size());
			list = dsSinhVien.subList(startItem, toIndex);
		}
		Page<SinhVien> sinhvienPage = new PageImpl<SinhVien>(list, PageRequest.of(currentPage, pageSize),
				dsSinhVien.size());
		return sinhvienPage;
	}
}