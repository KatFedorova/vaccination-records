package ru.fedorova.vaccination.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.fedorova.vaccination.model.entity.Vaccination;



public interface VaccinationRepository extends CrudRepository<Vaccination, Integer> {
    Page<Vaccination> findAll(Pageable pageable);

    Page<Vaccination> findBySnils(Long snils, Pageable pageable);
}