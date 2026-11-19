package be.bstorm.tf_java_2026_rcd_bend.repositories;

import be.bstorm.tf_java_2026_rcd_bend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
