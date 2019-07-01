package app.dao;

import app.domain.User;

public interface UserDao {
    User getUserById(int id);
}
