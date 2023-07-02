package ch.aerztekasse.assignment.controller;

import ch.aerztekasse.assignment.controller.response.BusinessHoursResponseDTO;
import ch.aerztekasse.assignment.controller.response.StoreResponseDTO;
import ch.aerztekasse.assignment.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping("/api/v1/stores/{storeId}")
    public ResponseEntity<StoreResponseDTO> getStoreById(@PathVariable("storeId") int storeId){
        return ResponseEntity.ok(new StoreResponseDTO(storeService.getStoreById(storeId)));
    }

    @GetMapping("/api/v1/stores/{storeId}/business-hours")
    public ResponseEntity<BusinessHoursResponseDTO> getStoreBusinessHoursById(@PathVariable("storeId") int storeId){
        return ResponseEntity.ok(storeService.getBusinessHoursByStoreId(storeId));
    }
}
