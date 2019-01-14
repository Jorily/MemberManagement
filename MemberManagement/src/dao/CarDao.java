package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Car;

public class CarDao extends BaseDao {

	public List<Car> search() {
		List<Car> list = new ArrayList<Car>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			rs = stat.executeQuery("select * from car");
			// 6 对结果集进行处理
			while (rs.next()) {
				Car c = new Car();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, stat, rs);
		}

		return list;
	}

	public List<Car> searchByCondition(Car condition) {
		List<Car> list = new ArrayList<Car>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			String where = " where 1=1 ";
			if (!condition.getName().equals("")) {
				where += " and name='" + condition.getName() + "'";
			}

			String sql = "select * from car " + where;
			rs = stat.executeQuery(sql);
			// 6 对结果集进行处理
			while (rs.next()) {
				Car c = new Car();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, stat, rs);
		}
		return list;
	}

	public boolean add(Car c) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			int rs = stat.executeUpdate("insert into car(name) values('" + c.getName() + "')");
			// 6 对结果集进行处理
			if (rs > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return flag;
	}

	public boolean update(Car c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			// Statement stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			// String sql = "update project set name='" + selectEmp.getName() + "',sex='"
			// +
			// selectEmp.getSex() + "',age="
			// + selectEmp.getAge() + " where id=" + selectEmp.getId();
			// System.out.println(sql);
			// int rs = stat.executeUpdate(sql);
			String sql = "update car set name=? where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, c.getName());
			pstat.setInt(2, c.getId());
			int rs = pstat.executeUpdate();
			// 6 对结果集进行处理
			if (rs > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstat, null);
		}
		return flag;
	}

	public boolean delete(int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			String sql = "delete from car where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			int rs = pstat.executeUpdate();
			pstat.close();
			sql = "delete from r_g_c where c_id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			rs = pstat.executeUpdate();
			conn.commit();
			// conn.setAutoCommit(true);
			// 6 对结果集进行处理
			if (rs > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			closeAll(conn, pstat, null);
		}
		return flag;
	}

	public boolean delete(String ids) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "delete from car where id in (" + ids + ")";
			stat = conn.createStatement();
			int rs = stat.executeUpdate(sql);
			// 6 对结果集进行处理
			if (rs > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, stat, null);
		}
		return flag;
	}

}
