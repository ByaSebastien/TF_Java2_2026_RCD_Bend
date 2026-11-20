package be.bstorm.tf_java_2026_rcd_bend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "userexo")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString(exclude = "password")
public class User implements UserDetails{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(nullable = false, length = 200)
    @Getter @Setter
    private String email;

    @Column(nullable = false, length = 200)
    @Getter @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Getter @Setter
    private Role role;

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(role.getName())
        );
    }

	@Override
    public String getUsername() {
        return email;
    }
}
