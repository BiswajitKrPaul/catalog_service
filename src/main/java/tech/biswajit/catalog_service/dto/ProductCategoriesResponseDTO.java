package tech.biswajit.catalog_service.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductCategoriesResponseDTO {

    private UUID id;
    private String name;
    private String description;

}
