package br.com.sample.factory.pattern.exception;

import br.com.sample.factory.pattern.exception.entity.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(final RuntimeException exception,
                                                          final WebRequest request) {
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .status(HttpStatus.UNPROCESSABLE_ENTITY.toString())
                .message(exception.getMessage())
                .build();
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
