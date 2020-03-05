package ru.fedorova.vaccination.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;

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
