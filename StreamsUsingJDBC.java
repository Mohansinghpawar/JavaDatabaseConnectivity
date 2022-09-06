import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApplication {
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
   static final String USER = "SYSTEM";
   static final String PASS = "root";
   static final String QUERY = "SELECT Data FROM XML_Data WHERE id=100";
   static final String INSERT_QUERY="INSERT INTO XML_Data VALUES (?,?)";
   static final String CREATE_TABLE_QUERY = "CREATE TABLE XML_Data (id INTEGER, Data LONG)";
   static final String DROP_TABLE_QUERY = "DROP TABLE XML_Data";
   static final String XML_DATA = "<Employee><id>100</id><first>MohanSingh</first><last>Pawar</last><Salary>20000</Salary><Dob>07-10-1999</Dob></Employee>";
   public static void createXMLTable(Statement stmt) 
      throws SQLException{
      System.out.println("Creating XML_Data table..." );
      //Drop table first if it exists.
      try{
         stmt.executeUpdate(DROP_TABLE_QUERY);
      }catch(SQLException se){
      }
      stmt.executeUpdate(CREATE_TABLE_QUERY);
   }
 public static void main(String[] args) {
      // Open a connection try-with-resources
     try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         PreparedStatement pstmt = conn.prepareStatement(INSERT_QUERY); ) 
      {		      
         createXMLTable(stmt);
         ByteArrayInputStream bis = new ByteArrayInputStream(XML_DATA.getBytes());
         pstmt.setInt(1,100);
         pstmt.setAsciiStream(2,bis,XML_DATA.getBytes().length);
         pstmt.execute();
         //Close input stream
         bis.close();
         ResultSet rs = stmt.executeQuery(QUERY);
         // Get the first row
         if (rs.next ()){
            //Retrieve data from input stream
            InputStream xmlInputStream = rs.getAsciiStream (1);
            int c;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while (( c = xmlInputStream.read ()) != -1)
               bos.write(c);
            //Print results
            System.out.println(bos.toString());
         }
         // Clean-up environment
         rs.close();

      } catch (SQLException | IOException e) {
         e.printStackTrace();
      } 
   }
}
