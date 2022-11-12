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
        listUsers.add(new User(++USER_COUNT, "Aser", "Qwerty",22,"aser@ya.ru"));
        listUsers.add(new User(++USER_COUNT, "Bob", "Tompson",26,"btomompson@google.com"));
        listUsers.add(new User(++USER_COUNT, "Charles", "Loly",43, "lolyta@yahoo.com"));
        listUsers.add(new User(++USER_COUNT, "Doka", "Carl",32,"carlusha@gmail.com"));
        listUsers.add(new User(++USER_COUNT, "Elena", "Ivanova",50, "qwerty@drmom.com"));
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
        userToUpdate.setAge(user.getAge());
        userToUpdate.setEmail(user.getEmail());
    }

    @Override
    public void delete(int id) {
        listUsers.removeIf(u -> u.getId() == id);
    }
}
