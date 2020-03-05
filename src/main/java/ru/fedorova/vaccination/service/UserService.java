package ru.fedorova.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fedorova.vaccination.model.dto.UserDTO;
import ru.fedorova.vaccination.model.entity.User;
import ru.fedorova.vaccination.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User userDtoToEntity(UserDTO userDTO) {
        User user = new User();

            String name = userDTO.getName();
            user.setName(name);
            String password = userDTO.getPassword();
            user.setPassword(password);
            user.setRole("USER");

        return user;
    }

    public void saveUser(UserDTO userDTO) {
        User user = userDtoToEntity(userDTO);
        userRepository.save(user);
    }
}
