package app.service;

import app.config.DatabaseHandler;
import app.dao.UserDao;
import app.domain.Account;
import app.domain.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;


import static app.config.DataBaseConstants.USER_ID;
import static app.config.DataBaseConstants.USER_TABLE;

public class UserDaoImpl implements UserDao{
    private static UserDaoImpl instance;
    private AccountDaoImpl accountService = AccountDaoImpl.getInstance();

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            return instance = new UserDaoImpl();
        }
        return instance;
    }



    @Override
    public User getUserById(int id) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = null;
        try {
            PreparedStatement preparedStatement = dbHandler.getDbConnection()
                    .prepareStatement("select * from " + USER_TABLE + " where " + USER_ID + " = " + id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setSureName(resultSet.getString("sureName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}

