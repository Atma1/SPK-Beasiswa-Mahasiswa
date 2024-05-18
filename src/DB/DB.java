package DB;

import java.sql.*;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/spk_bsw";
    
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL);
            return con;
        } catch (SQLException error) {
            System.out.println("Error " + error);
        }
        return null;
    }
    
    
}
