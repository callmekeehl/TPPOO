package gayi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_tppoo_ggayi";
    private static final String USERNAME = "justkeehl";
    private static final String PASSWORD = "justkeehl12";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
