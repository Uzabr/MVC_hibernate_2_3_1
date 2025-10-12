package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUsers(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUsers(User users) {
        entityManager.merge(users);
    }

    @Override
    public void removeUsers(long id) {
        User users = entityManager.find(User.class, id);
        if (users != null) {
            entityManager.remove(users);
        }
    }

    @Override
    public User getUsersByid(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }
}
