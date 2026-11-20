package be.bstorm.tf_java_2026_rcd_bend.controllers;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import be.bstorm.tf_java_2026_rcd_bend.models.user.requests.UserRegisterRequest;
import be.bstorm.tf_java_2026_rcd_bend.models.user.responses.UserResponse;
import be.bstorm.tf_java_2026_rcd_bend.models.user.responses.UserTokenResponse;
import be.bstorm.tf_java_2026_rcd_bend.services.AuthService;
import be.bstorm.tf_java_2026_rcd_bend.utils.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtils jwtUtils;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<UserTokenResponse> login(@Valid @RequestBody LoginRequest request) {
        User user = authService.login(request.email(), request.password());
        UserTokenResponse response = mapUser(user);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register")
  	public ResponseEntity<UserTokenResponse> register(
      @Valid @RequestBody UserRegisterRequest request) {

	    User user = authService.register(request.toUser());
	    String token = jwtUtil.generateToken(user);
	
	    UserTokenResponse response = new UserTokenResponse(UserResponse.fromUser(user), token);
	
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

    private UserTokenResponse mapUser(User user) {
        UserResponse userResponse = UserResponse.fromUser(user);
        String token = jwtUtils.generateToken(user);
        String refreshToken = jwtUtils.generateRefreshToken(user);
        return new UserTokenResponse(userResponse, token, refreshToken);
    }
}
