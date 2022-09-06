import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
   static final String USER = "SYSTEM";
   static final String PASS = "root";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "DROP TABLE REGISTRATION";
         stmt.executeUpdate(sql);
         System.out.println("Table deleted in given database...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
