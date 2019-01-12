package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import entity.Group;

public class EmployeeDao extends BaseDao {
	//查所有
	public List<Employee> search() {
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			String sql = "select e.*,g.name as gName,emp_count from employee as e left join "
					+ " group1 as g on e.g_id=g.id";
			rs = stat.executeQuery(sql);
			// 6 对结果集进行处理
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAge(rs.getInt("age"));
				emp.setTelephone(rs.getString("telephone"));
				Group gp = new Group();
				gp.setId(rs.getInt("g_id"));
				gp.setName(rs.getString("gName"));
				gp.setgCount(rs.getInt("emp_count"));//?
				emp.setGp(gp);
				list.add(emp);
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
	//根据条件查询
	public List<Employee> searchByCondition(Employee condition) {
		List<Employee> list = new ArrayList<Employee>();
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
				where += " and e.name='" + condition.getName() + "'";
			}
			if (!condition.getSex().equals("")) {
				where += " and sex='" + condition.getSex() + "'";
			}
			if (condition.getAge() != -1) {
				where += " and age=" + condition.getAge();
			}
			if (condition.getGp().getId() != -1) {
				where += " and g_id=" + condition.getGp().getId();
			}
			String sql = "select e.*,g.name as gName,emp_count from employee as e left join  group1 as g on e.d_id=g.id "
					+ where;
			rs = stat.executeQuery(sql);

			// 6 对结果集进行处理
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSex(rs.getString("sex"));
				emp.setAge(rs.getInt("age"));
				emp.setTelephone(rs.getString("telephone"));
				Group gp = new Group();
				gp.setId(rs.getInt("g_id"));
				gp.setName(rs.getString("gName"));
				gp.setgCount(rs.getInt("emp_count"));
				emp.setGp(gp);
				list.add(emp);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, stat, rs);
		}

		return list;
	}
	//增加一个会员
	public boolean add(Employee emp) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			int rs = stat.executeUpdate("insert into employee(name,sex,age,telephone,g_id) values('" + emp.getName() + "','"
					+ emp.getSex() + "'," + emp.getAge() + "," + emp.getGp().getId() + ")");
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
	//修改会员的信息
	public boolean update(Employee emp) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			// Statement stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			// String sql = "update employee set name='" + selectEmp.getName() + "',sex='" +
			// selectEmp.getSex() + "',age="
			// + selectEmp.getAge() + " where id=" + selectEmp.getId();
			// System.out.println(sql);
			// int rs = stat.executeUpdate(sql);
			String sql = "update employee set name=?,sex=?,age=?,g_id=? where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, emp.getName());
			pstat.setString(2, emp.getSex());
			pstat.setInt(3, emp.getAge());
			pstat.setInt(4, emp.getGp().getId());
			pstat.setInt(5, emp.getId());
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
	//删除一个会员
	public boolean delete(int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			String sql = "delete from employee where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
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
	//删除多个
	public boolean delete(String ids) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			String sql = "delete from employee where id in (" + ids + ")";
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
