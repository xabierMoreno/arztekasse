package ch.aerztekasse.assignment.service;

import ch.aerztekasse.assignment.controller.response.BusinessHoursResponseDTO;
import ch.aerztekasse.assignment.controller.response.StoreDTO;

public interface StoreService {
    StoreDTO getStoreById(int storeId);
    BusinessHoursResponseDTO getBusinessHoursByStoreId(int storeId);
}
