import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JdbcInsertFileOne {
 
    public static void main(String[] args) {
        String url = "jdbc:oracle://localhost:1521/xe";
        String user = "SYSTEM";
        String password = "root";
 
        String filePath = "D:/Photos/Gru.png";
 
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
 
            String sql = "INSERT INTO person (first_name, last_name, photo) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "Minions");
            statement.setString(2, "Gru");
            InputStream inputStream = new FileInputStream(new File(filePath));
 
            statement.setBlob(3, inputStream);
 
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("A contact was inserted with photo image.");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
