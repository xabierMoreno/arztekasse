package ch.aerztekasse.assignment.repository;

import ch.aerztekasse.assignment.data.BusinessHours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessHoursRepository extends CrudRepository<BusinessHours, Integer> {

    List<BusinessHours> findByStoreId(int storeId);
}
