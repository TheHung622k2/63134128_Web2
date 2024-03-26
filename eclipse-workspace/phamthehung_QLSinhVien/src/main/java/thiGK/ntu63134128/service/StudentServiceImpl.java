package thiGK.ntu63134128.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thiGK.ntu63134128.models.DTOStudent;

@Service
public class StudentServiceImpl implements StudentService {
	
	static List<DTOStudent> dsSinhVien = new ArrayList<>();

    static {
        dsSinhVien.add(new DTOStudent("001", "Nguyễn Thị Hương", "8.1"));
        dsSinhVien.add(new DTOStudent("002", "Lê Minh Khánh", "8.2"));
        dsSinhVien.add(new DTOStudent("003", "Võ Thị Lan Anh", "8.3"));
        dsSinhVien.add(new DTOStudent("004", "Nguyễn Văn Nam", "8.4"));
        dsSinhVien.add(new DTOStudent("005", "Đặng Thị Ngọc Trâm", "8.5"));
        dsSinhVien.add(new DTOStudent("006", "Hoàng Minh Tuấn", "8.6"));
        dsSinhVien.add(new DTOStudent("007", "Lê Thị Thu Thảo", "8.7"));
        dsSinhVien.add(new DTOStudent("008", "Nguyễn Văn Phúc", "8.8"));
        dsSinhVien.add(new DTOStudent("009", "Trần Thị Hương Ly", "8.9"));
        dsSinhVien.add(new DTOStudent("010", "Phan Văn Đức", "8.1"));
        dsSinhVien.add(new DTOStudent("011", "Đỗ Thị Hồng Nhung", "8.2"));
        dsSinhVien.add(new DTOStudent("012", "Lê Văn Duy", "8.3"));
    }

    @Override
	public Page<DTOStudent> findPaginated(Pageable pageable) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<DTOStudent> list;

		if (dsSinhVien.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, dsSinhVien.size());
			list = dsSinhVien.subList(startItem, toIndex);
		}
		Page<DTOStudent> sinhvienPage = new PageImpl<DTOStudent>(list, PageRequest.of(currentPage, pageSize),
				dsSinhVien.size());
		return sinhvienPage;
	}
}
