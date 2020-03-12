package ru.fedorova.vaccination.model.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Класс представляет собой модель для передачи данных от представления в модель объекта БД и наоборот
 * Геттеры и сеттеры генерируются автоматически
 * Аннотация @RequiredArgsConstructor создаёт конструктор для полей с аннотацией @NonNull
 */
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
