package be.bstorm.tf_java_2026_rcd_bend.repositories;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}