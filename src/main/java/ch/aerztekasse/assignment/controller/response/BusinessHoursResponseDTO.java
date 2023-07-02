package ch.aerztekasse.assignment.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class BusinessHoursResponseDTO {
    private List<OperationsDayDTO> businessHours;
}

