package ru.fedorova.vaccination.model.dto;

import javax.validation.constraints.*;

public class UserDTO {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,12}$",
            message = "Пароль должен быть 6-12 символов, включать заглавную и строчную латинскую букву, а также цифру")
    private String password;

    public UserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
