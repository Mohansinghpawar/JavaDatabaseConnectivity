import java.sql.*;
public class StoredProcedureCallExample1 {
    public static void main(String[] args) {
        String dbURL = "jdbc:oracle://localhost:15221/xe";
        String user = "SYSTEM";
        String password = "root";
 
 
        try (
 
            Connection conn = DriverManager.getConnection(dbURL, user, password);
 
            CallableStatement statement = conn.prepareCall("{call create_author(?, ?)}");
        ) {
 
            statement.setString(1, "Mohan Singh");
            statement.setString(2, "mohansingh@clayfin.com");
 
            statement.execute();
            statement.close();
 
            System.out.println("Stored procedure called successfully!");
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
