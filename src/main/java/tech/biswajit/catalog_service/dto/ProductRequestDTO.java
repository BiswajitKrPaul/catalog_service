package tech.biswajit.catalog_service.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDTO {


    private String productName;

    private String productDesc;

    private UUID categoryId;
}
