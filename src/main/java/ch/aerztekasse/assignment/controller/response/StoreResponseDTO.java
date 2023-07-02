package ch.aerztekasse.assignment.controller.response;

import ch.aerztekasse.assignment.data.Store;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreResponseDTO {
    private StoreDTO data;
}
