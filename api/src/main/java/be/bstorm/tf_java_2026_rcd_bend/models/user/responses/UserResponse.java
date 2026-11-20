package be.bstorm.tf_java_2026_rcd_bend.models.user.responses;

import be.bstorm.tf_java_2026_rcd_bend.entities.Role;
import be.bstorm.tf_java_2026_rcd_bend.entities.User;

public record UserResponse(
        Integer id,
        String email,
        Role role
) {

    public static UserResponse fromUser(User u) {
        return new UserResponse(
                u.getId(),
                u.getEmail(),
                u.getRole()
        );
    }
}
