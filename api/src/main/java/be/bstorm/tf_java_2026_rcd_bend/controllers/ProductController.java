package be.bstorm.tf_java_2026_rcd_bend.controllers;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;
import be.bstorm.tf_java_2026_rcd_bend.models.product.requests.CreateProductRequest;
import be.bstorm.tf_java_2026_rcd_bend.models.product.responses.CreateProductResponse;
import be.bstorm.tf_java_2026_rcd_bend.models.product.responses.ProductIndexResponse;
import be.bstorm.tf_java_2026_rcd_bend.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductIndexResponse>> getAll(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size
    ) {
        Page<Product> products = productService.findAll(PageRequest.of(page, size, Sort.by("id")));

        Page<ProductIndexResponse> response = products.map(ProductIndexResponse::fromProduct);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(
            @RequestBody @Valid CreateProductRequest req
    ) {
        Product newProduct = req.toProduct();

        Product inserted = productService.create(newProduct);
        CreateProductResponse response = CreateProductResponse.fromProduct(inserted);

        return ResponseEntity.ok(response);
    }
}
