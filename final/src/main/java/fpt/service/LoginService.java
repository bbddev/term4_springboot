package fpt.service;

import fpt.model.Login;
import fpt.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    public Login checkLogin(String username, String password) {
        Login loginAccount = loginRepository.findByUsernameAndPassword(username, password);
        System.out.println("Login account: " + loginAccount);
        if (loginAccount != null) {
            return loginAccount;
        } else {
            return null;
        }
    }
}
