package ru.goltsov.springCRUD.DAO;

import org.springframework.stereotype.Component;
import ru.goltsov.springCRUD.models.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAOImpl implements UserDAO {
    private static int USER_COUNT;
    private List<User> listUser = new ArrayList<>();
    {
        listUser.add(new User(++USER_COUNT,"Aser","Qwerty"));
        listUser.add(new User(++USER_COUNT,"Bob","Tompson"));
        listUser.add(new User(++USER_COUNT,"Charles","Loly"));
        listUser.add(new User(++USER_COUNT,"Doka","Carl"));
        listUser.add(new User(++USER_COUNT,"Elena","Ivanova"));
    }

    @Override
    public List<User> index() {
        return null;
    }

    @Override
    public User show(int id) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
