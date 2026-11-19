package be.bstorm.tf_java_2026_rcd_bend.models.product.responses;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;

public record ProductIndexResponse(
        Long id,
        String name,
        int price
) {

    public static ProductIndexResponse fromProduct(Product p) {
        return new ProductIndexResponse(
                p.getId(),
                p.getName(),
                p.getPrice()
        );
    }
}
