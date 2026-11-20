package be.bstorm.tf_java_2026_rcd_bend.services.impls;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import be.bstorm.tf_java_2026_rcd_bend.exeptions.user.UserInvalidPasswordException;
import be.bstorm.tf_java_2026_rcd_bend.exeptions.user.UserNotFoundException;
import be.bstorm.tf_java_2026_rcd_bend.repositories.UserRepository;
import be.bstorm.tf_java_2026_rcd_bend.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import be.bstorm.tf_java_2026_rcd_bend.entities.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

	@Override
    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use: " + user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));

        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new UserInvalidPasswordException("Invalid password for user " + email);
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
    }
}
