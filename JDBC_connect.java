import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Exception;
import java.sql.SQLSyntaxErrorException;
public class JDBC_connect {
	public static void main(String[] args)throws SQLException{
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","root");
		Statement stmt=con.createStatement();
		stmt.execute("CREATE TABLE Person (PersonsID Number)");
		System.out.println("Table created successfully....");
		con.close();
	    }catch(Exception e) {
	    	System.out.println(e);
	    }
    }
}
