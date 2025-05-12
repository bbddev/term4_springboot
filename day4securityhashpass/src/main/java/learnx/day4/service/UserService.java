package learnx.day4.service;

import learnx.day4.dto.UserDTO;
import learnx.day4.models.Users;

import java.util.List;

public interface UserService {
    List<Users> getUsers();
    Users findByEmail(String email);
    void saveUser(UserDTO userDTO);
}