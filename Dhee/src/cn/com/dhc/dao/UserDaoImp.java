package cn.com.dhc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import cn.com.dhc.bean.User;
import cn.com.dhc.utils.DButils;

public class UserDaoImp {

	public static boolean insert(User u) {
		Connection con = DButils.getCon();
		PreparedStatement pst = null;
		boolean flag = false;
		int max_id = 0;
		ResultSet rs_max = null;
		String sql = "insert into t_user values(?,?,?,?,?,?)";
		String sql_max = "select MAX(t_id) as max_id from t_user";
		try {
			PreparedStatement pst_max = con.prepareStatement(sql_max);
			rs_max = pst_max.executeQuery();
			if (rs_max.next()) {
				max_id = rs_max.getInt("max_id");
			}
			pst = con.prepareStatement(sql);
			int t_id = max_id+1;
			pst.setInt(1, t_id);
			pst.setString(2, u.getName());
			pst.setString(3, u.getPwd());
			pst.setInt(4, u.getSex());
			pst.setString(5, u.getEmail());
			pst.setInt(6, 0);
			int i = pst.executeUpdate();
			System.out.println("i");
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DButils.close(rs_max, pst, con);
		return flag;
	}

	public static ArrayList<User> selectDep() {
		Connection con = DButils.getCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from t_user";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("t_id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getInt("sex"));
				u.setEmail(rs.getString("email"));
				u.setPower(rs.getInt("power"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		DButils.close(rs, pst, con);
		return list;
	}

	public static User select_name(String name) {
		Connection con = DButils.getCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		User u = new User();
		String sql = "select * from t_user where name = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("t_id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getInt("sex"));
				u.setEmail(rs.getString("email"));
				u.setPower(rs.getInt("power"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DButils.close(rs, pst, con);
		}

		return u;
	}

	public static boolean isName(String name) {
		User u = select_name(name);
		return u == null ? false : true;
	}

	public static boolean delete(String name) {
		boolean flag = false;
		Connection con = DButils.getCon();
		String sql = "delete from t_user where name = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			int i = pst.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean update(String name, User u) {
		boolean flag = false;
		Connection con = DButils.getCon();
		String sql = "update t_user set name = ?, pwd = ?, sex = ?, email = ?, power = ? where name = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u.getName());
			pst.setString(2, u.getPwd());
			pst.setInt(3, u.getSex());
			pst.setString(4, u.getEmail());
			pst.setInt(5, 0);
			pst.setString(6, name);
			int i = pst.executeUpdate();
			if(i > 0) {
				flag = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}