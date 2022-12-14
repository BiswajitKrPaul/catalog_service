package tech.biswajit.catalog_service.service;

import tech.biswajit.catalog_service.dto.ProductPaginatedResponseListDTO;
import tech.biswajit.catalog_service.dto.ProductRequestDTO;
import tech.biswajit.catalog_service.dto.ProductResponseDTO;

public interface ProductService {
    public ProductResponseDTO create(ProductRequestDTO productRequestDTO);

    public ProductPaginatedResponseListDTO getPageList(int page, int size);
}
