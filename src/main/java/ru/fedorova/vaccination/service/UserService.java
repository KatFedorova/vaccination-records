package ru.fedorova.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedorova.vaccination.model.dto.UserDTO;
import ru.fedorova.vaccination.model.entity.User;
import ru.fedorova.vaccination.repo.UserRepository;

/**
 * Сервис-класс для манипуляций с Пользователями
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * Конвертирует объект usertDTO в User (парсит все поля)
     * @param userDTO
     * @return User
     */
    public User userDtoToEntity(UserDTO userDTO) {
        User user = new User();

            String name = userDTO.getName();
            user.setName(name);
            String password = userDTO.getPassword();
            user.setPassword(password);
            user.setRole("USER");

        return user;
    }

    /**
     * Принимает обект usertDTO, конвертирует в User и сохраняет в БД
     * @param userDTO
     */
    public void saveUser(UserDTO userDTO) {
        User user = userDtoToEntity(userDTO);
        userRepository.save(user);
    }
}
