package learnx.day4.service;

import learnx.day4.models.Roles;
import learnx.day4.models.Users;
import learnx.day4.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    UserRepository userRepository;

    CustomerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(email);
        if (users != null) {
            return new org.springframework.security.core.userdetails.User(
                    users.getEmail(), users.getPassword(),
                    mapRoleAuthor(users.getRoles()));
        } else {
            throw new UsernameNotFoundException("Email not found");
        }
    }

    private Collection<? extends GrantedAuthority> mapRoleAuthor(Collection<Roles> roles) {
        Collection<? extends GrantedAuthority> authorities =
                roles.stream().map(
                                role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList());
        return authorities;
    }
}
