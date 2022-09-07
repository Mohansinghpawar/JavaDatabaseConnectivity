import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
public class InsertMulti {
		private static final String STR_INSERT = "insert into emp values(?,?,?)";
		public static void main(String[] args) throws SQLException, IOException {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
			PreparedStatement pstmt = con.prepareStatement(STR_INSERT);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("enter employee ID");
				String id1 = br.readLine();
				int id = Integer.parseInt(id1);
				System.out.println("enter employee name");
				String name = br.readLine();
				System.out.println("enter employee sal");
				String sal1 = br.readLine();
				int sal = Integer.parseInt(sal1);
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, sal);
				pstmt.addBatch();
				
				System.out.println("IF You Want to add more records : Enter Yes otherwise no");
				
				String add = br.readLine();
				
				if (add.equalsIgnoreCase("no")) {
					break;
				}
			}
			int[] Counts = pstmt.executeBatch();
			System.out.println(Arrays.toString(Counts));
			
    }
	}
