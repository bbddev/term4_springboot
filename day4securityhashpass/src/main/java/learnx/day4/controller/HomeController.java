package learnx.day4.controller;

import learnx.day4.dto.UserDTO;
import learnx.day4.models.Users;
import learnx.day4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register/save")
    public String register(Model model, UserDTO userDTO) {
        Users users = userService.findByEmail(userDTO.getEmail());
        if (users == null) {
            userService.saveUser(userDTO);
        }
        return "redirect:/register?success";
    }
}
