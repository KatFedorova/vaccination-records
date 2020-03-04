package ru.fedorova.vaccination.model.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class PatientDTO implements Serializable {
    @NonNull
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11, message = "Введите 11 цифр СНИЛС")
    @Pattern(regexp = "^[0-9]+", message = "Введите цифры")
    private String snils;

    @NonNull
    @NotNull
    @NotBlank
    @Size(min = 2, max = 16)
    private String name;

    @NonNull
    @NotNull
    @NotBlank
    @Size(min = 2, max = 16)
    private String surname;

    @NonNull
    private String patronymic;

    @NonNull
    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private String birthDate;

    private String medicalInstitutionCode;

}