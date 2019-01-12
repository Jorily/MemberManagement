package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Car;

public class Group_CarDao extends BaseDao {

	public List<Car> searchByGroup(int gId) {
		List<Car> list = new ArrayList<Car>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			rs = stat.executeQuery("select * from v_g_c where g_id=" + gId);
			// 6 对结果集进行处理
			while (rs.next()) {
				Car c = new Car();
				c.setId(rs.getInt("c_id"));
				c.setName(rs.getString("c_name"));
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

	public List<Car> searchByNotGroup(int gId) {
		List<Car> list = new ArrayList<Car>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			String sql = "select *from car where id not in (select c_id from v_g_c where g_id=" + gId + ")";
			rs = stat.executeQuery(sql);
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

	public boolean add(int gId, int cId) {
		Connection conn = null;
		Statement stat = null;
		int rs = 0;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			String sql = "insert into r_g_c(g_id,c_id) values(" + gId + "," + cId + ")";
			rs = stat.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, stat, null);
		}

		return rs > 0;
	}

	public boolean delete(int gId, int cId) {
		Connection conn = null;
		Statement stat = null;
		int rs = 0;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			String sql = "delete from r_g_c where g_id=" + gId + " and c_id=" + cId;
			rs = stat.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, stat, null);
		}

		return rs > 0;
	}
}
