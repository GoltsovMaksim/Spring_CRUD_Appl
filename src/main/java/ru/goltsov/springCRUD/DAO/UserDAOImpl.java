package ru.goltsov.springCRUD.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.goltsov.springCRUD.config.Util;
import ru.goltsov.springCRUD.models.User;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory = Util.getSessionFactory();

    public UserDAOImpl() {
    }

    @Override
    public List<User> index() {
        return sessionFactory.openSession().createQuery("From User", User.class).list();
    }

    @Override
    public User show(int id) {
        User userTemp = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            userTemp = session.get(User.class, id);
            session.getTransaction().commit();
            return userTemp;
        } catch (Exception e) {
            System.out.printf("Unable to delete user with ID - %d", id);
        }
        return userTemp;
    }


    @Override
    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Unable to save person to the table Users");
        }
    }


    @Override
    public void update(int id, User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User userTemp = session.get(User.class, id);
            userTemp.setName(user.getName());
            userTemp.setSurname(user.getSurname());
            userTemp.setAge(user.getAge());
            userTemp.setEmail(user.getEmail());
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.printf("Unable to delete user with ID - %d", id);
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User userTemp = session.get(User.class, id);
            session.delete(userTemp);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.printf("Unable to delete user with ID - %d", id);
        }
    }
}
