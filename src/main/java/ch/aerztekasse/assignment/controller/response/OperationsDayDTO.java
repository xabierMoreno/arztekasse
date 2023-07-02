package ch.aerztekasse.assignment.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationsDayDTO {
    private String day;
    private List<OperationsHoursDTO> operationHours;
}
