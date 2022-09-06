import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class JDBCConnect {
	private static final String INSERT_MULTIPLE_USERS_SQL = "insert into hemus values(102,'mohansingh')";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
		Statement smt=con.createStatement();
		//smt.execute("create table hemus(empno number(3), empname varchar2(15))");
		int result = smt.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
    System.out.println("No. of records affected : " + result);
		System.out.println("Data inserted successfully");
		//con.close();    
	}catch(Exception e)
	{
		System.err.println(e);
	}

	}

}
