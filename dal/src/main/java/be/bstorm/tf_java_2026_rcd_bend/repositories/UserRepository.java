package be.bstorm.tf_java_2026_rcd_bend.repositories;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.role where u.email ilike :email")
    Optional<User> findByEmail(String email);
}
