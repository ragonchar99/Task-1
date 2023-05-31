package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userService = new UserServiceImpl(new UserDaoJDBCImpl());
        userService.createUsersTable();

        userService.saveUser("Roman", "Gonchar", (byte) 23);
        userService.saveUser("Sergey", "Sitnikov", (byte) 23);
        userService.saveUser("Kirill", "Lukashin", (byte) 22);
        userService.saveUser("Ivan", "Gonchar", (byte) 15);

        List<User> list = userService.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }

        userService.removeUserById(3);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
