package jdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // 연결 생성
        	try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded successfully");
            } catch (ClassNotFoundException e) {
                System.err.println("Error loading JDBC driver: " + e.getMessage());
                e.printStackTrace();
            }

            String url = "jdbc:mysql://localhost:3306/wptest?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
            String username = "root";
            String password = "0000";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static Connection getConnection(String url, String userName, String password) throws SQLException {
        if (connection == null || connection.isClosed()) {
            // 연결 생성
        	try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded successfully");
            } catch (ClassNotFoundException e) {
                System.err.println("Error loading JDBC driver: " + e.getMessage());
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }
}
