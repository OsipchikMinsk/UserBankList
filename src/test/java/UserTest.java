import app.domain.Account;
import app.domain.User;
import app.service.AccountDaoImpl;
import app.service.UserDaoImpl;
import app.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {
    private User user;
    private User user2;
    private Account account;
    private Account account2;

    @Mock
    public AccountDaoImpl accountDaoImpl = AccountDaoImpl.getInstance();
    @Mock
    public UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
    @InjectMocks
    public UserService service = UserService.getInstance();


    @Before
    public void setup() {
        user = new User(1, "name1", "sureName1");
        user2 = new User(2, "name2", "sureName2");
        account = new Account(1, 111, user.getId());
        account2 = new Account(2, 222, user2.getId());

    }

    @Test
    public void testTheRichestUser() {
        int id = 0;
        List<Account> accounts = Arrays.asList(account, account2);
        when(accountDaoImpl.getAllAccounts()).thenReturn(accounts);
        when(userDaoImpl.getUserById(id)).thenReturn(user2);

        Assert.assertEquals(service.findRichestUser(), user2);
    }
}
