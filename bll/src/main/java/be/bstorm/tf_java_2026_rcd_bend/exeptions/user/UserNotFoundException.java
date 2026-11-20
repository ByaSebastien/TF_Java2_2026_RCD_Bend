package be.bstorm.tf_java_2026_rcd_bend.exeptions.user;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{

    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "User not found");
    }

    public UserNotFoundException(String body) {
        super(HttpStatus.NOT_FOUND, body);
    }

    @Override
    public String toString() {
        return getBody().toString();
    }
}
