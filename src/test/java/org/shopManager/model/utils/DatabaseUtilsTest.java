package org.shopManager.model.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtilsTest {

    DatabaseUtils databaseUtils;

    @BeforeEach
    void setUp() throws SQLException {
        databaseUtils = new DatabaseUtils();
    }

    @Test
    public void executeQueryTest() throws Exception {
        ResultSet resultSet = databaseUtils.executeQuery("select * from user");

        Assertions.assertNotNull(resultSet);
        Assertions.assertTrue(resultSet.next());
    }
}
