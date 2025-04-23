package bv.userservice.controllers;

import bv.userservice.models.User;
import bv.userservice.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
//    @Autowired //cach 1: khong khuyen khi vi gay kho hieu
    private UserRepository userRepository;
    public UserController(UserRepository _userRepository) {
        userRepository = _userRepository;
    }

    @GetMapping
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody  User user) {
        return userRepository.save(user);
    }


    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
