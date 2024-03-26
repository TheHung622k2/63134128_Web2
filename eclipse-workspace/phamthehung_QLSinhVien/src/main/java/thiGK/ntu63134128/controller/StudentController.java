package thiGK.ntu63134128.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import thiGK.ntu63134128.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
}