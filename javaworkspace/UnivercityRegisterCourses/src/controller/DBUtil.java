package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";

	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "hr", "1234");
		//System.out.println("DB ���� ����");
		return con;
	}
}
