package tech.biswajit.catalog_service.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoriesPaginatedResponseListDTO {
    private int currentPage;
    private int totalPage;
    private List<ProductCategoriesResponseDTO> productCategories;
}
