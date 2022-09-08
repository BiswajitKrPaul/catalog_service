package tech.biswajit.catalog_service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.biswajit.catalog_service.data.ProductCategories;
import tech.biswajit.catalog_service.dto.ProductCategoriesPaginatedResponseListDTO;
import tech.biswajit.catalog_service.dto.ProductCategoriesResponseDTO;
import tech.biswajit.catalog_service.repositories.ProductCategoriesRepository;

@Service
public class ProductCategoriesServiceImpl implements ProductCategoriesService {
        @Autowired
        private ProductCategoriesRepository productCategoriesRepository;

        @Override
        public ProductCategoriesResponseDTO saveProductCategory(ProductCategories p) {
                ProductCategories pCategories = productCategoriesRepository.save(p);
                ProductCategoriesResponseDTO productCategoriesResponseDTO =
                                ProductCategoriesResponseDTO.builder().id(pCategories.getId())
                                                .name(pCategories.getName())
                                                .description(pCategories.getDescription()).build();
                return productCategoriesResponseDTO;
        }

        @Override
        public ProductCategoriesPaginatedResponseListDTO getProducts(int page, int pageSize) {
                Pageable pageable = PageRequest.of(page - 1, pageSize);
                Page<ProductCategories> pList = productCategoriesRepository.findAll(pageable);
                List<ProductCategoriesResponseDTO> pDto = pList.stream()
                                .map(e -> ProductCategoriesResponseDTO.builder().id(e.getId())
                                                .description(e.getDescription()).name(e.getName())
                                                .build())
                                .toList();
                return ProductCategoriesPaginatedResponseListDTO.builder()
                                .currentPage(pList.getNumber() + 1).totalPage(pList.getTotalPages())
                                .productCategories(pDto).build();
        }
}
