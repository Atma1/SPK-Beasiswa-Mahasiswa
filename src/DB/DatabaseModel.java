package DB;

import java.sql.*;

public class DatabaseModel {
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
    
    public static void addUser(Connection con, String username, String password) {
        String query = "INSERT INTO user (username, password) VALUES (?, ?);";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            System.out.println(statement.getParameterMetaData());
            
            System.out.println("Inserted sucessfully");
        } catch (SQLException error) {
            System.out.println("Error while executing query " + error);
        }
    }
    
    public static boolean checkUser(Connection con,  String inputtedUsername,
            String inputtedPassword) {
        String query = "SELECT * FROM user WHERE username=? AND password=?;";
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, inputtedUsername);
            statement.setString(2, inputtedPassword);
            
            ResultSet result = statement.executeQuery();
           
            return result.next();
        } catch (SQLException error) {
            System.out.println("Error while executing query " + error);
        } 
        return false;
    }
}
