package ru.fedorova.vaccination.repo;

import org.springframework.data.repository.CrudRepository;
import ru.fedorova.vaccination.model.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}