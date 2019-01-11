package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

	public Connection getConnection() {
		Connection conn = null;
		// 2 利用反射，加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 3 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root",
					"123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void closeAll(Connection conn, Statement stat, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

