package ru.fedorova.vaccination.repo;

import javafx.concurrent.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fedorova.vaccination.model.entity.Drug;
import ru.fedorova.vaccination.model.entity.MedicalWorker;

@Repository
public interface DrugRepository extends CrudRepository<Drug, Integer> {
    Drug findByDrugId(Integer drugId);
}