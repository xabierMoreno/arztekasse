package ch.aerztekasse.assignment.repository;

import ch.aerztekasse.assignment.data.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

    Optional<Store> findById(Integer integer);
}
