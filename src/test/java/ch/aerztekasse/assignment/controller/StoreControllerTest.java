package ch.aerztekasse.assignment.controller;

import ch.aerztekasse.assignment.controller.response.BusinessHoursResponseDTO;
import ch.aerztekasse.assignment.controller.response.OperationsDayDTO;
import ch.aerztekasse.assignment.controller.response.OperationsHoursDTO;
import ch.aerztekasse.assignment.exceptions.StoreNotFoundException;
import ch.aerztekasse.assignment.service.StoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StoreControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoreService storeService;

    @Test
    public void getBusinessHoursByIdReturn200() throws Exception {

        List<OperationsHoursDTO> operationsHoursDTOList = asList(new OperationsHoursDTO(1L, "09:00","21:00"));
        BusinessHoursResponseDTO businessHoursDTO = new BusinessHoursResponseDTO(asList(new OperationsDayDTO("MONDAY", operationsHoursDTOList )));
        when(storeService.getBusinessHoursByStoreId(12)).thenReturn(businessHoursDTO);
        this.mockMvc.perform(get("/api/v1/stores/12")).andExpect(status().isOk());
    }

    @Test
    public void getBusinessHoursReturn404() throws Exception {
        when(storeService.getBusinessHoursByStoreId(2)).thenThrow(new StoreNotFoundException("Store 2 not found"));
        this.mockMvc.perform(get("/api/v1/stores/2/business-hours")).andExpect(status().isNotFound());
    }
}
