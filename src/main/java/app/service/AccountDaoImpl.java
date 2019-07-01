package app.service;

import app.config.DatabaseHandler;
import app.dao.AccountDao;
import app.domain.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static app.config.DataBaseConstants.ACCOUNT_TABLE;
public class AccountDaoImpl implements AccountDao {

    private static AccountDaoImpl instance;

    private AccountDaoImpl(){
    }

    public static AccountDaoImpl getInstance() {
        if (instance == null) {
            return instance = new AccountDaoImpl();
        }
        return instance;
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = databaseHandler.getDbConnection()
                    .prepareStatement("select * from " + ACCOUNT_TABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("accountId"));
                account.setAccount(resultSet.getInt("account"));
                account.setUserId(resultSet.getInt("userId"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
