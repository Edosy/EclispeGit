package cn.com.dhc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButils {
	public static final String URL = "jdbc:mysql://127.0.0.1/dhee";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(ResultSet rs, PreparedStatement pst, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
