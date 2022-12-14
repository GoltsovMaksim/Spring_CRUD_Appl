package ru.goltsov.springCRUD.DAO;

import org.springframework.stereotype.Component;
import ru.goltsov.springCRUD.models.User;

import java.util.List;

@Component
public interface UserDAO {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);

}
