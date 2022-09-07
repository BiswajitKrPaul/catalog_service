package tech.biswajit.catalog_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoriesRequestDTO {

    private String name;
    private String description;

}
