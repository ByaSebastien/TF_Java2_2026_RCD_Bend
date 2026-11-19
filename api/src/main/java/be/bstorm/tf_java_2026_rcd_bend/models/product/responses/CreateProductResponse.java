package be.bstorm.tf_java_2026_rcd_bend.models.product.responses;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;

public record CreateProductResponse(
        Long id
) {

    public static CreateProductResponse fromProduct(Product p) {
        return new CreateProductResponse(
                p.getId()
        );
    }
}
