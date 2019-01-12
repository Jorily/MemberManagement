package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class IndexDao{

Connection conn = null;
Statement stat = null;
ResultSet rs = null;
String driver = "com.mysql.jdbc.Driver";
String url  = "jdbc:mysql://localhost:3306/member?characterEncoding=utf-8";
String name = "root";
String passwd = "123456";
	public IndexDao(){
		try{
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url,name,passwd);
		stat = conn.createStatement();
		}catch(ClassNotFoundException e){
			System.out.println("对不起，找不到这个Driver");
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//用户注册功能的实现，添加数据
	public void insert(String username,String password){
		
		String sql = "insert into user values(\""+username+"\",\""+password+"\")";
		try{
			int a = stat.executeUpdate(sql);
			conn.close();
			stat.close();
			if(a==1){
				JOptionPane.showMessageDialog(null,"注册成功！");
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "对不起该用户名已经有了！");
			e.printStackTrace();
		}
	}
	//登录
	public boolean compare(String username,String password){
		
		boolean m = false;
		String sql = "select password from user where username=\""+username+"\"";
	    try{
	    	rs = stat.executeQuery(sql);
	    	if(rs.next()){
	    		String pa = rs.getString(1);
	    		System.out.println(pa+" " +password);
	    		if(pa.equals(password)){
	    			m = true;
	    		}else {
	    			JOptionPane.showMessageDialog(null, "密码错误！");
	        	}
	    	}else {
	    		JOptionPane.showMessageDialog(null, "用户名不存在！");
	    	}
	    	rs.close();
	    	conn.close();
			stat.close();
	    	
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
	    return m;
	}
}
