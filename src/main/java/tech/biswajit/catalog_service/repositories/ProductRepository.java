package tech.biswajit.catalog_service.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.biswajit.catalog_service.data.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, UUID> {

}
