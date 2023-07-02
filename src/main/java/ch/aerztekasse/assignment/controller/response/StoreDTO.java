package ch.aerztekasse.assignment.controller.response;

import ch.aerztekasse.assignment.data.Store;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreDTO {
    private Long id;

    private String name;

    private String address;

    public static StoreDTO mapper(Store store){
       return new StoreDTO(store.getId(), store.getName(), store.getAddress());
    }
}
