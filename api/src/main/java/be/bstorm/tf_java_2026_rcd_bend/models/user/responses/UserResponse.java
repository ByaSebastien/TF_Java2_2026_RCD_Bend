package be.bstorm.tf_java_2026_rcd_bend.models.user.responses;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import be.bstorm.tf_java_2026_rcd_bend.models.role.responses.RoleResponse;

public record UserResponse(
        Integer id,
        String email,
        RoleResponse role
) {
    public static UserResponse fromUser(User user){
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                RoleResponse.fromRole(user.getRole())
        );
    }
}
