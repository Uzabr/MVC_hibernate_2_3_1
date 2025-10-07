package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {


    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUsers(Users user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUsers(Users users) {
        entityManager.merge(users);
    }

    @Override
    public void removeUsers(long id) {
        Users users = entityManager.find(Users.class, id);
        if (users != null) {
            entityManager.remove(users);
        }
    }

    @Override
    public Users getUsersByid(long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Users> listUsers() {
        return (List<Users>) entityManager.createQuery("from Users").getResultList();
    }
}
