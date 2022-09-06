import java.sql.*;
public class JDBC2 {
	   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	   static final String USER = "SYSTEM";
	   static final String PASS = "root";
	   static final String QUERY = "SELECT PersonId FROM Persons";

	   public static void main(String[] args) throws SQLException {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	            System.out.print("PersonID: " + rs.getInt("PersonID"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
	}
