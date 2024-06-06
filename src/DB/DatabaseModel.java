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
    
    public static void resetAll() {
        try {
            Connection con = DatabaseModel.getConnection();
            Statement stmt = con.createStatement();
            stmt.addBatch("TRUNCATE TABLE mahasiswa;");
            stmt.addBatch("TRUNCATE TABLE ranking;");
            stmt.addBatch("TRUNCATE TABLE datakriteria;");
            stmt.addBatch("UPDATE kriteria SET bobot = 0");
            stmt.addBatch("DELETE FROM account WHERE role = 'mahasiswa';");
            stmt.executeBatch();
            con.close();
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }
}
