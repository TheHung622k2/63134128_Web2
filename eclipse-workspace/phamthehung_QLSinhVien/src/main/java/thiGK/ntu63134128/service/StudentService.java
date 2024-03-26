package thiGK.ntu63134128.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thiGK.ntu63134128.models.DTOStudent;

@Service
public interface StudentService {
	public Page<DTOStudent> findPaginated(Pageable pageable);
}
