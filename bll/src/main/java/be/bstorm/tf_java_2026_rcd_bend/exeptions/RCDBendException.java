package be.bstorm.tf_java_2026_rcd_bend.exeptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = false) @ToString
public abstract class RCDBendException extends RuntimeException {

    @Getter
    private String section;

    @Getter
    private final HttpStatus status;

    @Getter
    private final Object body;

    public RCDBendException(HttpStatus status, Object body, String section) {
        super();
        this.status = status;
        this.body = body;
        this.section = section;
    }
}