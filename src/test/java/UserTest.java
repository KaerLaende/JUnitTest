import org.example.HomeWork.User;

import org.example.HomeWork.ValidateEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.HomeWork.User.users;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;
    private final ValidateEmail validateEmail = new ValidateEmail();

    @BeforeEach
    public void addUser() {
        User user1 = new User("GubkaBoB", "GubkaBoB@mail.ru");
        User user2 = new User("Genna", "genna@mail.ru");
        User user3 = new User("genna@mail.ru", "genna@mail.ru");
        User user4 = new User("Neznaika", "nuznaikaWTF");
        User userNull = new User(null, "@null");
    }


    @Test
    public void testCreateUser() {
        users.forEach(Assertions::assertNotNull);
    }

    @Test
    public void testCreateUserNull() {
        users.stream().peek(x -> System.out.println("Проверяется: " + x.getLogin())).peek(x -> assertNotNull(x.getEmail(), "Null в Email ")).forEach(x -> assertNotNull(x.getLogin(), "Null в Login "));
    }

    @Test
    public void testCorrectEmail() {
        users.stream().peek(x -> System.out.println(x.getLogin() + " email is correct -> " + validateEmail.validate(x.getEmail()))).forEach(x -> assertTrue(validateEmail.validate(x.getEmail())));
    }

    @Test
    public void testIsEqualsEmailAndLogin() {
        users.stream().peek(x->System.out.println("Проверяется на не равенство Login & Email у -"+x.getLogin())).forEach(x -> assertNotEquals(x.getLogin(), x.getEmail()));
    }
}
