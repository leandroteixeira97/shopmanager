package org.shopManager.model.service;

import org.shopManager.model.entity.Profile;
import org.shopManager.model.entity.User;
import org.shopManager.model.utils.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileService {

    private DatabaseUtils databaseUtils;

    public ProfileService() throws SQLException {
        this.databaseUtils = new DatabaseUtils();
    }

    public Profile getProfileByUser(User user) throws SQLException {
        String sql = "SELECT * FROM public.profile WHERE user_id = " + user.getId() + ";";
        ResultSet resultSet = databaseUtils.executeQuery(sql);

        if (resultSet.next()) {
            return new Profile(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("phone"),
                    user
            );
        }

        throw new RuntimeException("No profile was found to the given User");
    }
}
