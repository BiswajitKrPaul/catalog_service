package tech.biswajit.catalog_service.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.biswajit.catalog_service.data.ProductCategories;
import tech.biswajit.catalog_service.dto.ProductCategoriesPaginatedResponseListDTO;
import tech.biswajit.catalog_service.dto.ProductCategoriesRequestDTO;
import tech.biswajit.catalog_service.dto.ProductCategoriesResponseDTO;
import tech.biswajit.catalog_service.service.ProductCategoriesServiceImpl;

@RestController
@RequestMapping("/v1/categories")
public class ProductCategoriesController {

    @Autowired
    private ProductCategoriesServiceImpl productCategoriesServiceImpl;

    @PostMapping()
    public ProductCategoriesResponseDTO saveProductCategories(
            @Valid @RequestBody ProductCategoriesRequestDTO productCategories) {
        return productCategoriesServiceImpl
                .saveProductCategory(ProductCategories.builder().name(productCategories.getName())
                        .description(productCategories.getDescription()).build());
    }

    @GetMapping()
    public ProductCategoriesPaginatedResponseListDTO getAllProducts(
            @RequestParam(defaultValue = "1", required = false, name = "page") int page,
            @RequestParam(defaultValue = "50", required = false, name = "size") int pageSize) {
        return productCategoriesServiceImpl.getProducts(page, pageSize);
    }
}
