package app.service;

import app.domain.Account;
import app.domain.User;

import java.util.Comparator;
import java.util.List;

public class UserService {
    private static UserService instance;

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            return instance = new UserService();
        }
        return instance;
    }

    private UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
    private AccountDaoImpl accountDaoImpl = AccountDaoImpl.getInstance();

    public User findRichestUser() {
        int richestUser = 0;
        List<Account> accounts = accountDaoImpl.getAllAccounts();
        if (accounts.size() > 0) {
            richestUser = accounts.stream().max(Comparator.comparingInt(Account::getAccount))
                    .get()
                    .getUserId();
        }
        return richestUser > 0 ? userDaoImpl.getUserById(richestUser) : null;
    }
}
