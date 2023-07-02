package ch.aerztekasse.assignment.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class StoreNotFoundException extends RuntimeException{
    private String message;
}
