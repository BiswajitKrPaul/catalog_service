package tech.biswajit.catalog_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDTO {

    private String productName;

    private String productDesc;
}
