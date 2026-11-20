package be.bstorm.tf_java_2026_rcd_bend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userexo")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString(exclude = "password")
public class User {

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
}
