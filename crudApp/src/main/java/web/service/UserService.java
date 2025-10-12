package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUsers(User users);

    void updateUsers(User users);

    void removeUsers(long id);

    User getUsersById(long id);

    List<User> getAllUsers();
}
