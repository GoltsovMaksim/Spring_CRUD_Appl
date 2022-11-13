package ru.goltsov.springCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.goltsov.springCRUD.DAO.UserDAOImpl;
import ru.goltsov.springCRUD.models.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDAO;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(int id, User user) {
        userDAO.update(id,user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);

    }
}
