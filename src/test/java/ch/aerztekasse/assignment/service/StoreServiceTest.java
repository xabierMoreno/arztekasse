package ch.aerztekasse.assignment.service;

import ch.aerztekasse.assignment.controller.response.BusinessHoursResponseDTO;
import ch.aerztekasse.assignment.data.BusinessHours;
import ch.aerztekasse.assignment.data.Store;
import ch.aerztekasse.assignment.exceptions.StoreNotFoundException;
import ch.aerztekasse.assignment.repository.BusinessHoursRepository;
import ch.aerztekasse.assignment.repository.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class StoreServiceTest {

    StoreService storeService;
    @Mock
    StoreRepository storeRepositoryMock;
    @Mock
    BusinessHoursRepository businessHoursRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        storeService = new StoreServiceImpl(storeRepositoryMock, businessHoursRepository);
    }

    @Test
    public void testGetBusinessHours(){
        when(storeRepositoryMock.findById(1)).thenReturn(Optional.empty());
        assertThrows(StoreNotFoundException.class, () -> storeService.getBusinessHoursByStoreId(1));
    }

    @Test
    public void testGetBusinessHoursExceptionIsThrown(){
        when(storeRepositoryMock.findById(1)).thenReturn(Optional.of(new Store(1L, "Store1", "Address", new HashSet<>())));
        List<BusinessHours> businessHoursList = Arrays.asList(new BusinessHours(1L, 1, "17:00", "21:30",null),
                new BusinessHours(1L, 1, "09:00", "13:30",null),
                new BusinessHours(1L, 5, "09:00", "21:30", null));
        when(businessHoursRepository.findByStoreId(1)).thenReturn(businessHoursList);
        BusinessHoursResponseDTO businessHoursDTO = storeService.getBusinessHoursByStoreId(1);
        assertEquals(2, businessHoursDTO.getBusinessHours().size());
        assertEquals(DayOfWeek.MONDAY.toString(),  businessHoursDTO.getBusinessHours().get(0).getDay());
        assertEquals(2,  businessHoursDTO.getBusinessHours().get(0).getOperationHours().size());
        assertEquals("09:00",  businessHoursDTO.getBusinessHours().get(0).getOperationHours().get(0).getStartTime());
        assertEquals("13:30",  businessHoursDTO.getBusinessHours().get(0).getOperationHours().get(0).getEndTime());
        assertEquals("17:00",  businessHoursDTO.getBusinessHours().get(0).getOperationHours().get(1).getStartTime());
        assertEquals(DayOfWeek.FRIDAY.toString(),  businessHoursDTO.getBusinessHours().get(1).getDay());
    }
}
