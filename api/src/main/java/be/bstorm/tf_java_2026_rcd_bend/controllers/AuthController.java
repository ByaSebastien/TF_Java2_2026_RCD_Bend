package be.bstorm.tf_java_2026_rcd_bend.controllers;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import be.bstorm.tf_java_2026_rcd_bend.models.user.requests.LoginRequest;
import be.bstorm.tf_java_2026_rcd_bend.models.user.responses.UserResponse;
import be.bstorm.tf_java_2026_rcd_bend.models.user.responses.UserTokenResponse;
import be.bstorm.tf_java_2026_rcd_bend.services.AuthService;
import be.bstorm.tf_java_2026_rcd_bend.utils.JwtUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtils jwtUtils;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<UserTokenResponse> login(@Valid @RequestBody LoginRequest request) {
        User user = authService.login(request.username(), request.password());
        UserTokenResponse response = mapUser(user);
        log.info("User {} logged in successfully", user.getUsername());
        return ResponseEntity.ok(response);
    }

    private UserTokenResponse mapUser(User user) {
        UserResponse userResponse = UserResponse.fromUser(user);
        String token = jwtUtils.generateToken(user);
        String refreshToken = jwtUtils.generateRefreshToken(user);
        return new UserTokenResponse(userResponse, token, refreshToken);
    }
}
