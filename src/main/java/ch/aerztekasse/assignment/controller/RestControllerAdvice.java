package ch.aerztekasse.assignment.controller;

import ch.aerztekasse.assignment.controller.response.ApiErrorResponseDTO;
import ch.aerztekasse.assignment.exceptions.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

        @ExceptionHandler({ StoreNotFoundException.class })
        public ResponseEntity<ApiErrorResponseDTO> handleNotFoundException(
                StoreNotFoundException ex) {
            return  ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiErrorResponseDTO(HttpStatus.NOT_FOUND.value(),ex.getMessage()));
        }
}
