package be.bstorm.tf_java_2026_rcd_bend.models.user.requests;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterRequest(
        @NotBlank @Email
        String email,
        @NotBlank @Size(min = 8)
        String password
) {

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
