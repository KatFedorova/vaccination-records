package ru.fedorova.vaccination.repo;

import org.springframework.data.repository.CrudRepository;
import ru.fedorova.vaccination.model.entity.User;
import ru.fedorova.vaccination.model.entity.Vaccination;

import java.util.List;

public interface VaccinationRepository extends CrudRepository<Vaccination, Integer> {
    List<Vaccination> findBySnils(Long snils);
}