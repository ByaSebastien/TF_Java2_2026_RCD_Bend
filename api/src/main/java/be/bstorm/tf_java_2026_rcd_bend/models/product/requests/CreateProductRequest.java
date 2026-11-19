package be.bstorm.tf_java_2026_rcd_bend.models.product.requests;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateProductRequest(
        @NotNull @Size(min=3, max=50) String name,
        @NotNull @Size(min=3, max=255) String description,
        @NotNull @Min(0) float price
) {
    public Product toProduct() {
        return new Product(name, description, Math.round(price*100));
    }
}
