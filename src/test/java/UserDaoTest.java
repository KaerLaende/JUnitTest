import org.example.HomeWork.User;
import org.example.HomeWork.UserDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    private final UserDaoImpl out = new UserDaoImpl();
    private final User USER_TRUE = new User("GubkaBoBa", "GubkaBoBa@mail.ru");
    private final User USER_FALSE = new User("Genka", "genka@mail.ru");


    @Test
    public void shouldReturnTrueIfNameExist(){
//        assertEquals(USER_TRUE,out.getUserByName("GubkaBoBa"));
        assertEquals(USER_TRUE,out.getUserByName(USER_TRUE.getName()));
    }
    @Test
    public void shouldReturnNullIfNameNotExist(){
        assertNull(out.getUserByName(USER_FALSE.getName()));
    }

}
