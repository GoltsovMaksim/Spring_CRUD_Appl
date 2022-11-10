package ru.goltsov.springCRUD.DAO;

import org.springframework.stereotype.Component;
import ru.goltsov.springCRUD.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private static int USER_COUNT;
    private final List<User> listUsers = new ArrayList<>();

    {
        listUsers.add(new User(++USER_COUNT, "Aser", "Qwerty"));
        listUsers.add(new User(++USER_COUNT, "Bob", "Tompson"));
        listUsers.add(new User(++USER_COUNT, "Charles", "Loly"));
        listUsers.add(new User(++USER_COUNT, "Doka", "Carl"));
        listUsers.add(new User(++USER_COUNT, "Elena", "Ivanova"));
    }

    public UserDAOImpl() {
    }

    @Override
    public List<User> index() {
        return listUsers;
    }

    @Override
    public User show(int id) {
        return listUsers.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++USER_COUNT);
        listUsers.add(user);
    }

    @Override
    public void update(int id, User user) {
        User userToUpdate = show(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());
    }
}
