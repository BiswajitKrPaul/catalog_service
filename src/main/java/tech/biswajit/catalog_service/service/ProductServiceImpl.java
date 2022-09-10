package tech.biswajit.catalog_service.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.biswajit.catalog_service.data.Products;
import tech.biswajit.catalog_service.dto.ProductPaginatedResponseListDTO;
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
                var productName = productCategoriesRepository
                                .findById(productRequestDTO.getCategoryId()).get();
                var product = productRepository
                                .save(Products.builder().name(productRequestDTO.getProductName())
                                                .description(productRequestDTO.getProductDesc())
                                                .categoryId(productName).build());
                return ProductResponseDTO.builder().productId(product.getId())
                                .productDesc(product.getDescription())
                                .productName(product.getName())
                                .category(productCategoriesRepository
                                                .findById(product.getCategoryId().getId()).get()
                                                .getName())
                                .build();
        }

        @Override
        public ProductPaginatedResponseListDTO getPageList(int page, int size) {
                Pageable pageable = PageRequest.of(page - 1, size);
                Page<Products> products = productRepository.findAll(pageable);
                List<ProductResponseDTO> pList = products.stream()
                                .map(e -> ProductResponseDTO.builder().productId(e.getId())
                                                .productName(e.getName())
                                                .productDesc(e.getDescription())
                                                .category(productCategoriesRepository
                                                                .findById(e.getCategoryId().getId())
                                                                .get().getName())
                                                .build())
                                .toList();

                return ProductPaginatedResponseListDTO.builder().currentPage(page)
                                .totalPage(products.getTotalPages()).products(pList).build();
        }

}
