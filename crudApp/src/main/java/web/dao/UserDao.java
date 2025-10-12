package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    void addUsers(User user);

    void updateUsers(User users);

    void removeUsers(long id);

    User getUsersByid(long id);

    List<User> getAllUsers();

}
