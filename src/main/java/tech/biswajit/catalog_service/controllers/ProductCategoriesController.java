package tech.biswajit.catalog_service.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import tech.biswajit.catalog_service.data.ProductCategories;
import tech.biswajit.catalog_service.dto.ProductCategoriesRequestDTO;
import tech.biswajit.catalog_service.dto.ProductCategoriesResponseDTO;
import tech.biswajit.catalog_service.service.ProductCategoriesServiceImpl;

@RestController
@RequestMapping("/v1/categories")
@Slf4j
public class ProductCategoriesController {

    @Autowired
    private ProductCategoriesServiceImpl productCategoriesServiceImpl;

    @PostMapping
    public ProductCategoriesResponseDTO saveProductCategories(
            @Valid @RequestBody ProductCategoriesRequestDTO productCategories) {
        log.debug("Request Data : {}", productCategories);

        return productCategoriesServiceImpl
                .saveProductCategory(ProductCategories.builder().name(productCategories.getName())
                        .description(productCategories.getDescription()).build());
    }

    @GetMapping("/{page}")
    public List<ProductCategoriesResponseDTO> getAllProducts(@PathVariable int page) {
        return productCategoriesServiceImpl.getProducts(page);
    }
}
