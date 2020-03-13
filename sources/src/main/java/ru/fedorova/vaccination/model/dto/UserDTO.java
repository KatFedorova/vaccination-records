package ru.fedorova.vaccination.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;

/**
 * Класс представляет собой модель для передачи данных от представления в модель объекта БД и наоборот
 * строковое поле name проверяется на не пустое (и не пробелы) значение
 * строковое поле password проверяется на:
 * -не пустое, не пробелы, длина 6-12 символов, содержит заглавные, строчные латинские буквы и цифры
 * Геттеры и сеттеры генерируются автоматически
 * Аннотация @RequiredArgsConstructor создаёт конструктор для полей с аннотацией @NonNull
 */
@Getter
@Size
@RequiredArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NonNull
    @NotNull
    @NotBlank
    private String name;
    @NonNull
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,12}$",
            message = "Пароль должен быть 6-12 символов, включать заглавную и строчную латинскую букву, а также цифру")
    private String password;
}
