package ch.aerztekasse.assignment.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorResponseDTO {
    private int errorCode;
    private String errorMessage;
}
