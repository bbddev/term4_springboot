package fpt.aptech.day1p2.controller;

import fpt.aptech.day1p2.models.Student;
import fpt.aptech.day1p2.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private StudentService studentService;

//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping("/")
    public List<Student> index() {
        List<Student> students = studentService.getStudents();
        return students;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/doCreate")
    public String doCreate(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            return "create";
        } else {
            studentService.saveStudent(student);
            return "redirect:/";
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "min", required = false) Integer min,
                         @RequestParam(name = "max", required = false) Integer max,
                         Model model) {
        List<Student> students;
        if (min != null && max != null) {
            students = studentService.filterByAge(min, max);
        } else {
            students = studentService.getStudents(); // fallback
        }
        model.addAttribute("students", students);
        return "index";
    }

}
