package ru.fedorova.vaccination.repo;

import javafx.concurrent.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fedorova.vaccination.model.entity.MedicalWorker;

@Repository
public interface MedicalWorkerRepository extends CrudRepository<MedicalWorker, Integer> {
    MedicalWorker findByMedicalWorkerId (Integer medicalWorkerId);
}