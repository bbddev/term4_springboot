package fpt.controller;

import fpt.model.Login;
import fpt.model.Student;
import fpt.service.LoginService;
import fpt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        Login loginAccount = loginService.checkLogin(username, password);
        if (loginAccount != null) {
            if (loginAccount.getRole().equals("admin")) {
                return "redirect:/delete";
            } else {
                return "redirect:/home";
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "home";
    }

    @GetMapping("/delete")
    public String deletePage() {
        return "delete";
    }


    @PostMapping("/delete")
    public String deleteStudent(@RequestParam("idstudent") String idstudent, Model model) {
        Student stu = studentService.deleteStudent(idstudent);
        System.out.println("CONTROLLER: Deleting student with ID: " + idstudent);
        if (stu != null) {
            System.out.println("Deleted student: " + stu.getName());
            model.addAttribute("success", "Deleted student: " + stu.getName());
        } else {
            System.out.println("Student not found");
            model.addAttribute("error", "Student not found");
        }
        return "delete";
    }

}
