package be.bstorm.tf_java_2026_rcd_bend.models.user.responses;

public record UserTokenResponse(
        UserResponse user,
        String token
) {
}
