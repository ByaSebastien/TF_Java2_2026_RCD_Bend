package be.bstorm.tf_java_2026_rcd_bend.models.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public record UserContext(
        Integer id,
        String email,
        String role
) {

    public List<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }
}
