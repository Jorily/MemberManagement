package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import entity.Employee;

public class EmployeeView {
	ArrayList<Employee> emps=new ArrayList<Employee>();//存数据
	private static final String fileName="c:/test/stus.txt";//路径
	public void init(){
		JFrame jf=new JFrame("赛车小会员管理系统");
		jf.setSize(600, 500);//程序窗口大小
		jf.setLocationRelativeTo(null);//以屏幕中心为中心点显示
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭程序
		
		JPanel mainPanel=(JPanel)jf.getContentPane();//初始化一个容器
		//上中下布局
		BoxLayout layout=new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);
		JPanel panel1=new JPanel();//上
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,15,5));//居中，左右间隔，上下间隔
		JPanel panel2=new JPanel();//中
		JPanel panel3=new JPanel();//下
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER,55,5));
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		
		JLabel nameLabel=new JLabel();
		nameLabel.setText("姓名");
		panel1.add(nameLabel);
		
		JTextField nameField=new JTextField();
		nameField.setPreferredSize(new Dimension(100, 30));
		panel1.add(nameField);
		
		JLabel sexLabel=new JLabel();
		sexLabel.setText("性別");
		panel1.add(sexLabel);
		
		JTextField sexField=new JTextField();
		sexField.setPreferredSize(new Dimension(100, 30));
		panel1.add(sexField);
		
		JLabel ageLabel=new JLabel();
		ageLabel.setText("年齡");
		panel1.add(ageLabel);
		
		JTextField ageField=new JTextField();
		ageField.setPreferredSize(new Dimension(100, 30));
		panel1.add(ageField);
		
		JButton  searchBtn=new JButton();
		searchBtn.setPreferredSize(new Dimension(60, 30));
		searchBtn.setText("查询");
		panel1.add(searchBtn);
		
		load();
		
		EmployeeTableModel model=new EmployeeTableModel(emps);
		JTable table=new JTable();
		table.setModel(model);
		//滚动条
		JScrollPane scroll=new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(550, 350));
		panel2.add(scroll);
		
		JButton  addBtn=new JButton();
		addBtn.setPreferredSize(new Dimension(60, 30));
		addBtn.setText("增加");
		panel3.add(addBtn);
		JButton  deleteBtn=new JButton();
		deleteBtn.setPreferredSize(new Dimension(60, 30));
		deleteBtn.setText("删除");
		panel3.add(deleteBtn);
		JButton  updateBtn=new JButton();
		updateBtn.setPreferredSize(new Dimension(60, 30));
		updateBtn.setText("修改");
		panel3.add(updateBtn);
		
		
		
		jf.setVisible(true);
	}
	public void load(){
		try {
			File file=new File(fileName);
			if(file.exists()){
			FileInputStream	fis = new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			emps=(ArrayList<Employee>) ois.readObject();
			ois.close();
			fis.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EmployeeView().init();
	}
}
