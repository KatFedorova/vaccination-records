package ru.fedorova.vaccination.model.dto;


import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import ru.fedorova.vaccination.service.Snils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class VaccinationDTO implements Serializable {
    @NonNull
    @NotNull
    @NotBlank
    @Size (min = 11, max = 11, message = "Введите 11 знаков")
    @Pattern(regexp = "^[0-9]+", message = "Введите цифры")
    @Snils(message = "Проверьте контрольную сумму СНИЛС")
    private String snils;

    @NonNull
    @NotNull
    private Boolean consent;

    @NonNull
    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private String date;

    @NonNull
    @NotNull
    @Pattern(regexp = "^[0-9]+", message = "Введите цифры")
    private String drugId;

    @NonNull
    @NotNull
    @Pattern(regexp = "^[0-9]+", message = "Введите цифры")
    private String medicalWorkerId;
    private String medicalInstitutionCode;


    @Override
    public String toString() {
        String consentToStr = (consent) ? "да" : "нет";
        return "Прививка: " +
                "согласие - " + consentToStr +
                ", дата: " + date +
                ", СНИЛС: " + snils +
                ", препарат: " + drugId +
                ", работник: " + medicalWorkerId;
    }

}
