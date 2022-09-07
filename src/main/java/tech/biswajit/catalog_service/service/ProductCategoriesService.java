package tech.biswajit.catalog_service.service;

import java.util.List;
import tech.biswajit.catalog_service.data.ProductCategories;
import tech.biswajit.catalog_service.dto.ProductCategoriesResponseDTO;

public interface ProductCategoriesService {
    public ProductCategoriesResponseDTO saveProductCategory(ProductCategories p);

    public List<ProductCategoriesResponseDTO> getProducts(int page);
}
