package tech.biswajit.catalog_service.dto;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoriesRequestDTO {
    @NotBlank
    private String name;
    private String description;
}
