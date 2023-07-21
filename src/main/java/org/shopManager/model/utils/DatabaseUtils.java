package org.shopManager.model.utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.shopManager.model.entity.User;

import java.sql.*;

public class DatabaseUtils {

    private final String dbUsername;
    private final String dbPassword;
    private final String dbHost;
    private final String dbPort;
    private final String dbName;
    private final Connection connection;

    public DatabaseUtils() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        this.dbName = dotenv.get("DB_NAME");
        this.dbUsername = dotenv.get("DB_USERNAME");
        this.dbPassword = dotenv.get("DB_PASSWORD");
        this.dbHost = dotenv.get("DB_HOST");
        this.dbPort = dotenv.get("DB_PORT");
        this.connection = getConnection();
    }

    private Connection getConnection() throws SQLException {
        try {
            String connUri = "//" + this.dbHost + ":" + this.dbPort + "/" + this.dbName;
            return DriverManager.getConnection("jdbc:postgresql:" + connUri, this.dbUsername, this.dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        return preparedStatement.executeQuery();
    }
}
