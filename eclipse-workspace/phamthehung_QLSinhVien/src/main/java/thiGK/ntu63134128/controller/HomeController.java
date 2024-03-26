package thiGK.ntu63134128.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu63134128.models.DTOStudent;
import thiGK.ntu63134128.service.StudentService;

@Controller
public class HomeController {
	@Autowired
    private StudentService studentService;
	
	@GetMapping("/home")
	public String index()
	{
		return "index";
	}
	
	// hien thi danh sach
    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
    
    // Hien thi form cho phep them moi sinh vien
    @GetMapping("/add-student-form")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new DTOStudent());
        return "add-student-form";
    }
    
    // Tim kiem thong qua ma
    @GetMapping("/search")
    public String searchStudentById(@RequestParam("id") String id, Model model) {
    	DTOStudent student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "student-details";
        } else {
            return "student-not-found";
        }
    }
}
