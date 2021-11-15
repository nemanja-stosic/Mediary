package main.utill;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseUtil {
    private String url = "jdbc:mysql://localhost:3306/library_storage";
    private String user = "Nemanja";
    private String password = "necka1";

    private static Connection connection;

    //inner class to provide instance
    private static class DatabaseUtilSingleton {
        private static final DatabaseUtil INSTANCE = new DatabaseUtil();
    }

    public static DatabaseUtil getInstance() {
        return DatabaseUtilSingleton.INSTANCE;
    }

    private DatabaseUtil() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean add(String title, String entriesText, FileInputStream fileInputStream, File file) {
        String q = "INSERT INTO DIARY_ENTRIES (title, entriesText, backgroundImage) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(q)) {
            statement.setString(1, title);
            statement.setString(2, entriesText);
            statement.setBinaryStream(3, fileInputStream, (int) file.length());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, "add diary entry method failed!", e);
            return false;
        }

    }

    public void delete(String title) {
        String q = "DELETE FROM DIARY_ENTRIES WHERE title = ?";
        try (PreparedStatement statement = connection.prepareStatement(q)) {
            statement.setString(1, title);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, "delete diary entry method failed!", e);
        }

    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
