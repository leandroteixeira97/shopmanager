package org.shopManager.model.service;

import org.shopManager.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService extends AbstractService {

    public UserService() throws SQLException {
        super();
    }

    public User authenticateUser(String username, String password) throws Exception {
        String sql = "SELECT * FROM public.user WHERE username = '" + username + "' AND password = '" + password + "' AND expire_date IS NULL;";
        ResultSet resultSet = databaseUtils.executeQuery(sql);

        if (resultSet.next()) {
            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"));
        }

        throw new Exception("Unable to perform the user authentication based on the given credentials!");
    }

}
