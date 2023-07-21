package org.shopManager.model.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.shopManager.model.entity.User;

import java.sql.SQLException;

public class DatabaseUtilsTest {

    DatabaseUtils databaseUtils;

    @BeforeEach
    void setUp() throws SQLException {
        databaseUtils = new DatabaseUtils();
    }

    @Test
    public void authenticationTest() throws Exception {
        User user = databaseUtils.authenticateUser("admin", "admin");

        Assertions.assertNotNull(user);
        Assertions.assertTrue(user.getId() > 0);
    }
}
