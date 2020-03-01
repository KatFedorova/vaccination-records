package ru.fedorova.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.fedorova.vaccination.model.entity.Drug;
import ru.fedorova.vaccination.model.entity.Vaccination;
import ru.fedorova.vaccination.repo.DrugRepository;

import java.util.Optional;

public class TestServ {
    @Autowired
    static DrugRepository drugRepository;

    public static void main(String[] args) {
        Optional<Drug> drug = drugRepository.findById(1);
       // Drug drug = drugRepository.findByDrugId(1);
        System.out.println(drug);
    }
}
