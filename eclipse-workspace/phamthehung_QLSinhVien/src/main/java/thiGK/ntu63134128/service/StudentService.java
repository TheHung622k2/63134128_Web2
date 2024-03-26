package thiGK.ntu63134128.service;

import java.util.List;

import thiGK.ntu63134128.models.DTOStudent;

public interface StudentService {
	List<DTOStudent> getAllStudents();
	DTOStudent getStudentById(String id);
    void addStudent(DTOStudent student);
}
