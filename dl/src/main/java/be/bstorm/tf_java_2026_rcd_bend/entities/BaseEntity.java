package be.bstorm.tf_java_2026_rcd_bend.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class BaseEntity {

    @Getter
    @Setter
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Getter @Setter
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
