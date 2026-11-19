package be.bstorm.tf_java_2026_rcd_bend.exeptions.user;

import be.bstorm.tf_java_2026_rcd_bend.enums.Section;
import be.bstorm.tf_java_2026_rcd_bend.exeptions.RCDBendException;
import org.springframework.http.HttpStatus;

public abstract class UserException extends RCDBendException {

    public UserException(HttpStatus status, Object body) {
        super(status, body, Section.USER.name());
    }
}
