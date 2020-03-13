package ru.fedorova.vaccination.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.fedorova.vaccination.service.Snils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Класс представляет собой модель для передачи данных от представления в модель объекта БД и наоборот
 * строковое поле snils проверяется на:
 * -не пустое, не пробелы, длина 11, содержит только цифры, контрольная сумма верна
 * булево поле consent проверяется на не пустое значение
 * поле date проверяется на маску ввода даты дд.мм.гггг
 * строковое поле drugId проверяется на:
 * -не пустое, содержит только цифры
 *
 * Геттеры и сеттеры генерируются автоматически
 * Аннотация @NoArgsConstructor создаёт конструктор без параметров
 * Аннотация @RequiredArgsConstructor создаёт конструктор для полей с аннотацией @NonNull
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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
    private String medicalWorkerId;
    private String medicalInstitutionCode;

    /**
     * Метод возвращает строку со всеми параметрами Прививки на русском языке
     * @return
     */
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
