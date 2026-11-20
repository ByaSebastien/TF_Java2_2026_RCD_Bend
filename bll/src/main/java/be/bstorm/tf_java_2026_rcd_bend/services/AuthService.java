package be.bstorm.tf_java_2026_rcd_bend.services;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    User login(String username, String password);
    User register(User user);
}
