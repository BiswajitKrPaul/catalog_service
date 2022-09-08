package tech.biswajit.catalog_service.exceptions;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.biswajit.catalog_service.dto.ExceptionErrorResponseDTO;

@ControllerAdvice
public class ErrorException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest webRequest) {

        return new ResponseEntity<Object>(
                ExceptionErrorResponseDTO.builder().message(ex.getLocalizedMessage())
                        .date(new Date()).status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .path(webRequest.getDescription(false).replace("uri=", "")).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
