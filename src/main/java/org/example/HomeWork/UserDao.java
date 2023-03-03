package org.example.HomeWork;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);

    List<User> findAllUsers();
}
