import org.example.HomeWork.User;
import org.example.HomeWork.UserDaoImpl;
import org.example.HomeWork.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    private UserService out;
    private final User USER_TRUE = new User("GubkaBoBa", "GubkaBoBa@mail.ru");
    private final User USER_FALSE = new User("Genka", "genka@mail.ru");

    @Mock
    private UserDaoImpl userDao;

    @BeforeEach
    public void setUp(){
        out = new UserService(userDao);
    }
//    или:
//    @InjectMocks
//    private UserService out;

    @Test
    public void shouldReturnTrueIfUserExist(){
        Mockito.when(userDao.getUserByName(USER_TRUE.getName())).thenReturn(USER_TRUE);
        assertTrue(out.checkUserExist(USER_TRUE));
    }
    @Test
    public void shouldReturnFalseIfUserNotExist(){
        Mockito.when(userDao.getUserByName(USER_FALSE.getName())).thenReturn(null);
        assertFalse(out.checkUserExist(USER_FALSE));
    }


}
