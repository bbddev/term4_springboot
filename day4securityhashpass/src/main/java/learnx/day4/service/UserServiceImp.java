package learnx.day4.service;

import learnx.day4.dto.UserDTO;
import learnx.day4.models.Roles;
import learnx.day4.models.Users;
import learnx.day4.repository.RoleRepository;
import learnx.day4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Users> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private Roles checkExistAdmin() {
        Roles roles = new Roles();
        roles.setName("ROLE_ADMIN");
        return roleRepository.save(roles);
    }

    private Roles checkExistUser() {
        Roles roles = new Roles();
        roles.setName("ROLE_USER");
        return roleRepository.save(roles);
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        Users users = new Users();
        users.setName(userDTO.getFirstname() + " " + userDTO.getLastname());
        users.setEmail(userDTO.getEmail());
//        users.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        users.setPassword(userDTO.getPassword());
        users.setPhone(userDTO.getPhone());
        Roles rolesUser = roleRepository.findByName("ROLE_USER");
        Roles roleAdmin = roleRepository.findByName("ROLE_ADMIN");

        if (rolesUser == null && roleAdmin == null) {
            rolesUser = checkExistUser();
            roleAdmin = checkExistAdmin();
        }
//        users.setRoles(Arrays.asList(rolesUser));
        users.setRoles(Arrays.asList(roleAdmin));
        userRepository.save(users);
    }
}
