package tech.biswajit.catalog_service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.biswajit.catalog_service.data.ProductCategories;
import tech.biswajit.catalog_service.dto.ProductCategoriesResponseDTO;
import tech.biswajit.catalog_service.repositories.ProductCategoriesRepository;

@Service
public class ProductCategoriesServiceImpl implements ProductCategoriesService {
    @Autowired
    private ProductCategoriesRepository productCategoriesRepository;

    @Override
    public ProductCategoriesResponseDTO saveProductCategory(ProductCategories p) {
        ProductCategories pCategories = productCategoriesRepository.save(p);
        ProductCategoriesResponseDTO productCategoriesResponseDTO = ProductCategoriesResponseDTO
                .builder().id(pCategories.getId()).name(pCategories.getName())
                .description(pCategories.getDescription()).build();
        return productCategoriesResponseDTO;
    }

    @Override
    public List<ProductCategoriesResponseDTO> getProducts(int page) {
        List<ProductCategories> pList = productCategoriesRepository.findAll();
        List<ProductCategoriesResponseDTO> pDto =
                pList.stream()
                        .map(e -> ProductCategoriesResponseDTO.builder().id(e.getId())
                                .description(e.getDescription()).name(e.getName()).build())
                        .toList();
        return pDto;
    }
}
