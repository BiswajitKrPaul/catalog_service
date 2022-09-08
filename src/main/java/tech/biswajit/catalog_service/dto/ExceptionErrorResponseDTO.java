package tech.biswajit.catalog_service.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionErrorResponseDTO {

    private Date date;
    private String path;
    private int status;
    private String message;

}
