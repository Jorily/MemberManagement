package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Group;

public class GroupDao extends BaseDao {

	public List<Group> search() {
		List<Group> list = new ArrayList<Group>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			rs = stat.executeQuery("select * from group1");
			// 6 对结果集进行处理
			while (rs.next()) {
				Group g = new Group();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setgCount(rs.getInt("emp_count"));
				
				list.add(g);
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

	public List<Group> searchByCondition(Group condition) {
		List<Group> list = new ArrayList<>();
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
			if (condition.getgCount() != -1) {
				where += " and emp_count=" + condition.getgCount();
			}
			String sql = "select * from group1 " + where;
			rs = stat.executeQuery(sql);
			// 6 对结果集进行处理
			while (rs.next()) {
				Group g = new Group();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setgCount(rs.getInt("emp_count"));
				list.add(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, stat, rs);
		}
		return list;
	}

	public boolean add(Group g) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			int rs = stat.executeUpdate("insert into group1(name) values('" + g.getName() + "')");
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

	public boolean update(Group g) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			// Statement stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			// String sql = "update department set name='" + selectEmp.getName() + "',sex='"
			// +
			// selectEmp.getSex() + "',age="
			// + selectEmp.getAge() + " where id=" + selectEmp.getId();
			// System.out.println(sql);
			// int rs = stat.executeUpdate(sql);
			String sql = "update group1 set name=? where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, g.getName());
			pstat.setInt(2, g.getId());
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
			String sql = "delete from group1 where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			int rs = pstat.executeUpdate();
			pstat.close();
			sql = "update employee set g_id=null where g_id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			rs = pstat.executeUpdate();

			pstat.close();
			sql = "delete from r_g_c where g_id=?";
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
			String sql = "delete from group1 where id in (" + ids + ")";
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
