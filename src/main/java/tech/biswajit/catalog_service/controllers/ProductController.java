package tech.biswajit.catalog_service.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.biswajit.catalog_service.dto.ProductPaginatedResponseListDTO;
import tech.biswajit.catalog_service.dto.ProductRequestDTO;
import tech.biswajit.catalog_service.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> createProduct(
            @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.create(productRequestDTO));

    }

    @GetMapping
    public ProductPaginatedResponseListDTO getProductList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "50") int size) {
        return productService.getPageList(page, size);
    }

}
