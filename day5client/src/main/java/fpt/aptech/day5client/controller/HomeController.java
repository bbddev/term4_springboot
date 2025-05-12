package fpt.aptech.day5client.controller;

import fpt.aptech.day5client.service.iSchoolService;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    iSchoolService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("marks", service.findAllMarks());
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model, @PathParam("code") String code) {
        model.addAttribute("list", service.findAllSubjectsByCode(code));
        return "index";
    }
}
