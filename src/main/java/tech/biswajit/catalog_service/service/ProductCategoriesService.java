package tech.biswajit.catalog_service.service;

import tech.biswajit.catalog_service.data.ProductCategories;
import tech.biswajit.catalog_service.dto.ProductCategoriesPaginatedResponseListDTO;
import tech.biswajit.catalog_service.dto.ProductCategoriesResponseDTO;

public interface ProductCategoriesService {
    public ProductCategoriesResponseDTO saveProductCategory(ProductCategories p);

    public ProductCategoriesPaginatedResponseListDTO getProducts(int page, int pageSize);
}
