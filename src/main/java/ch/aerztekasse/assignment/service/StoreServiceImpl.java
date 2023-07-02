package ch.aerztekasse.assignment.service;

import ch.aerztekasse.assignment.controller.response.OperationsDayDTO;
import ch.aerztekasse.assignment.controller.response.OperationsHoursDTO;
import ch.aerztekasse.assignment.controller.response.BusinessHoursResponseDTO;
import ch.aerztekasse.assignment.controller.response.StoreDTO;
import ch.aerztekasse.assignment.data.BusinessHours;
import ch.aerztekasse.assignment.data.Store;
import ch.aerztekasse.assignment.exceptions.StoreNotFoundException;
import ch.aerztekasse.assignment.repository.BusinessHoursRepository;
import ch.aerztekasse.assignment.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService{

    private StoreRepository storeRepository;
    private BusinessHoursRepository businessHoursRepository;

    StoreServiceImpl(StoreRepository storeRepository, BusinessHoursRepository businessHoursRepository){
        this.storeRepository = storeRepository;
        this.businessHoursRepository = businessHoursRepository;
    }
    @Override
    public StoreDTO getStoreById(int storeId) {
        Store storeDao = storeRepository.findById(storeId).orElseThrow(() -> new StoreNotFoundException(String.format("Store %s not found", storeId)));
        return StoreDTO.mapper(storeDao);
    }

    @Override
    public BusinessHoursResponseDTO getBusinessHoursByStoreId(int storeId){
        getStoreById(storeId);
        List<BusinessHours> businessHoursList = businessHoursRepository.findByStoreId(storeId);
        Map<Integer, List<BusinessHours>> businessHoursMap = businessHoursList.stream().sorted(Comparator.comparing(BusinessHours::getDayOfWeek)
                .thenComparing(BusinessHours::getStartTime))
                .collect(Collectors.groupingBy(BusinessHours::getDayOfWeek));
        return new BusinessHoursResponseDTO(setBusinessHoursPerDay(businessHoursMap));
    }

    private static List<OperationsDayDTO> setBusinessHoursPerDay(Map<Integer, List<BusinessHours>> businessHoursMap) {
        List<OperationsDayDTO> operationsDayDTOList = new ArrayList<>();
        for(Map.Entry<Integer, List<BusinessHours>> entry : businessHoursMap.entrySet()){
            OperationsDayDTO operationDayDTO = new OperationsDayDTO();
            operationDayDTO.setDay(DayOfWeek.of(entry.getKey()).toString());
            operationDayDTO.setOperationHours(entry.getValue().stream().map(OperationsHoursDTO::map).collect(Collectors.toList()));
            operationsDayDTOList.add(operationDayDTO);
        }
        return operationsDayDTOList;
    }
}
