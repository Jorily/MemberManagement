package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.sql.PreparedStatement;

import entity.Group;
import entity.Employee;
import entity.Car;
import entity.Message;

public class MessageDao extends BaseDao {

	public List<Message> search() {
		List<Message> list = new ArrayList<>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 4 建立statement sql语句执行器
			stat = conn.createStatement();
			// 5 执行sql语句并得到结果
			String sql = "select * from v_emp_mess ";
			rs = stat.executeQuery(sql);
			// 6 对结果集进行处理
			while (rs.next()) {
				Message mess = new Message();
				mess.setId(rs.getInt("mess_id"));
				mess.setTime((Integer) rs.getObject("time"));
				mess.setYmd(rs.getString("ymd"));
				
				Employee emp = new Employee();
				emp.setId(rs.getInt("e_id"));
				emp.setName(rs.getString("e_name"));

				Group g = new Group();
				g.setId(rs.getInt("g_id"));
				g.setName(rs.getString("g_name"));

				emp.setGp(g);
				mess.setEmp(emp);

				Car c = new Car();
				c.setId(rs.getInt("c_id"));
				c.setName(rs.getString("c_name"));

				mess.setCar(c);

				list.add(mess);
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

	public void save(Set<Message> set) {
		for (Message mess : set) {
			if (mess.getId() == 0) {
				add(mess);
			} else {
				update(mess);
			}
		}

	}

	public boolean add(Message mess) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();

			// 5 执行sql语句并得到结果
			String sql = "insert into message(e_id,c_id,time) times(?,?,?) ";
			// 4 建立statement sql语句执行器
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, mess.getEmp().getId());
			pstat.setInt(2, mess.getCar().getId());
			pstat.setInt(3, mess.getTime());
			rs = pstat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, pstat, null);
		}

		return rs > 0;
	}

	public boolean update(Message mess) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			conn = getConnection();

			// 5 执行sql语句并得到结果
			String sql = "update score set time=? where id=?";
			// 4 建立statement sql语句执行器
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, mess.getTime());
			pstat.setInt(2, mess.getId());
			rs = pstat.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7 关闭
			closeAll(conn, pstat, null);
		}

		return rs > 0;
	}
}
