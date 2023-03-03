package org.example.HomeWork;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class UserDaoImpl implements UserDao{
    private final List<User> users = new ArrayList<>();


    public UserDaoImpl() {
        User user1 = new User("GubkaBoBa", "GubkaBoBa@mail.ru");
        User user2 = new User("Genna", "genna@mail.ru");
        User user3 = new User("genna@mail.ru", "genna@mail.ru");
        User user4 = new User("Neznaika", "nuznaikaWTF");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    @Override
    public User getUserByName(String name){
        return users.stream()
                .filter(x->name.equalsIgnoreCase(x.getName()))
                .findFirst().orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

//    //внутренняя проверка
//    public static void main(String[] args) {
//        UserDaoImpl userDao = new UserDaoImpl();
//        System.out.println(userDao.getUserByName("Genna"));
//    }
}
