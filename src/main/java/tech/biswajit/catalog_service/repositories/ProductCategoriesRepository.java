package tech.biswajit.catalog_service.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.biswajit.catalog_service.data.ProductCategories;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, UUID> {
}
