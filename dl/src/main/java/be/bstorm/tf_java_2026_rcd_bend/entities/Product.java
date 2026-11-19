package be.bstorm.tf_java_2026_rcd_bend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private int price;

    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
