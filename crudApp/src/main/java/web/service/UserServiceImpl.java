package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUsers(User users) {
        userDao.addUsers(users);
    }

    @Override
    @Transactional
    public void updateUsers(User users) {
        userDao.updateUsers(users);
    }

    @Override
    @Transactional
    public void removeUsers(long id) {
        userDao.removeUsers(id);
    }

    @Override
    public User getUsersById(long id) {
        return userDao.getUsersByid(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
