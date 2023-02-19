package DAOLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class SinglotonContext{
	private static Connection connectoin;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connectoin = DriverManager.getConnection("jdbc:mysql://localhost:3306/jeedb","root","1234");
		} catch (Exception e) {
			System.out.println("__ERROR__"+e);
		        e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		System.out.println("getting connection object.");
		return connectoin;
	}
}
