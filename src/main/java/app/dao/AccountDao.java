package app.dao;

import app.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getAllAccounts();
}
