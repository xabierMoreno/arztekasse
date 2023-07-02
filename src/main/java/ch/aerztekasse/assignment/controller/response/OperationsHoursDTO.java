package ch.aerztekasse.assignment.controller.response;

import ch.aerztekasse.assignment.data.BusinessHours;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperationsHoursDTO {
    private Long id;
    private String startTime;
    private String endTime;

    public static OperationsHoursDTO map(BusinessHours businessHours) {
        return new OperationsHoursDTO(businessHours.getId(), businessHours.getStartTime(), businessHours.getEndTime());
    }
}
