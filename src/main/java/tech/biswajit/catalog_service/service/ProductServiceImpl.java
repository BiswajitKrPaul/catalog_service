package tech.biswajit.catalog_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.biswajit.catalog_service.data.Products;
import tech.biswajit.catalog_service.dto.ProductRequestDTO;
import tech.biswajit.catalog_service.dto.ProductResponseDTO;
import tech.biswajit.catalog_service.repositories.ProductCategoriesRepository;
import tech.biswajit.catalog_service.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoriesRepository productCategoriesRepository;

    @Override
    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        var product =
                productRepository
                        .save(Products.builder().name(productRequestDTO.getProductName())
                                .description(productRequestDTO.getProductDesc())
                                .categoryId(productCategoriesRepository
                                        .findById(productRequestDTO.getCategoryId()).get())
                                .build());
        return ProductResponseDTO.builder().productDesc(product.getDescription())
                .productName(product.getName()).build();
    }

}
