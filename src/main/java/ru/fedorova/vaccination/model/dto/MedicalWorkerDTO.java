package ru.fedorova.vaccination.model.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MedicalWorkerDTO {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String patronymic;
    @NonNull
    private String position;
    @NonNull
    private String medicalInstitutionCode;
}
