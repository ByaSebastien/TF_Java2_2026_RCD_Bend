package be.bstorm.tf_java_2026_rcd_bend.services.impls;

import be.bstorm.tf_java_2026_rcd_bend.entities.Role;
import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import be.bstorm.tf_java_2026_rcd_bend.repositories.UserRepository;
import be.bstorm.tf_java_2026_rcd_bend.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use: " + user.getEmail());
        }
        // @TODO sécurité : chiffrer le mot de passe (PasswordEncoder / BCrypt)
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

}
