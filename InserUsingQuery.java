import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Demo {
	public static void main(String[] args)throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
			Statement smt=con.createStatement();
			smt.execute("insert into hemus values(101,'mohan')");
			System.out.println("Record Inserted Successfully");
			con.close();
		}catch(Exception e)
		{
			System.err.println(e);
		}
	}
}
