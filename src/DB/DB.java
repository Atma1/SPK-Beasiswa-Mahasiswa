package DB;

import java.sql.*;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/spk_bsw";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER,
                    PASSWORD);
        } catch (SQLException error) {
            System.out.println("Error " + error);
        }
        return null;
    }
    
    public static void addUser(Connection con) {
        
    }
    
    
}
