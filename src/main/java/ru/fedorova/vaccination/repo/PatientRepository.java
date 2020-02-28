package ru.fedorova.vaccination.repo;

import org.springframework.data.repository.CrudRepository;
import ru.fedorova.vaccination.model.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}