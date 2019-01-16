package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Member;
import entity.Group;

public class MemberDao extends BaseDao {
	//查所有
	public List<Member> search() {
		List<Member> list = new ArrayList<Member>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			String sql = "select m.*,g.name as gName,mem_count from member as m left join "
					+ " group1 as g on m.g_id=g.id";
			rs = stat.executeQuery(sql);
			// 6 对结果集进行处理
			while (rs.next()) {
				Member mem = new Member();
				mem.setId(rs.getInt("id"));
				mem.setName(rs.getString("name"));
				mem.setSex(rs.getString("sex"));
				mem.setAge(rs.getInt("age"));
				mem.setTelephone(rs.getString("telephone"));
				Group gp = new Group();
				gp.setId(rs.getInt("g_id"));
				gp.setName(rs.getString("gName"));
				gp.setgCount(rs.getInt("mem_count"));//?
				mem.setGp(gp);
				list.add(mem);
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
	public List<Member> searchByCondition(Member condition) {
		List<Member> list = new ArrayList<Member>();
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
				where += " and m.name='" + condition.getName() + "'";
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
			String sql = "select m.*,g.name as gName,mem_count from member as m left join  group1 as g on m.g_id=g.id "
					+ where;
			rs = stat.executeQuery(sql);

			// 6 对结果集进行处理
			while (rs.next()) {
				Member mem = new Member();
				mem.setId(rs.getInt("id"));
				mem.setName(rs.getString("name"));
				mem.setSex(rs.getString("sex"));
				mem.setAge(rs.getInt("age"));
				mem.setTelephone(rs.getString("telephone"));
				Group gp = new Group();
				gp.setId(rs.getInt("g_id"));
				gp.setName(rs.getString("gName"));
				gp.setgCount(rs.getInt("mem_count"));
				mem.setGp(gp);
				list.add(mem);
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
	public boolean add(Member mem) {
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			int rs = stat.executeUpdate("insert into member(name,sex,age,telephone,g_id) values('" + mem.getName() + "','"
					+ mem.getSex() + "'," + mem.getAge() + "," +mem.getTelephone()+","+ mem.getGp().getId() + ")");
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
	public boolean update(Member mem) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			// Statement stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			// String sql = "update Member set name='" + selectmem.getName() + "',sex='" +
			// selectmem.getSex() + "',age="
			// + selectmem.getAge() + " where id=" + selectmem.getId();
			// System.out.println(sql);
			// int rs = stat.executeUpdate(sql);
			String sql = "update member set name=?,sex=?,age=?,g_id=? where id=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, mem.getName());
			pstat.setString(2, mem.getSex());
			pstat.setInt(3, mem.getAge());
			pstat.setInt(4, mem.getGp().getId());
			pstat.setInt(5, mem.getId());
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
			String sql = "delete from member where id=?";
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
			String sql = "delete from member where id in (" + ids + ")";
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
