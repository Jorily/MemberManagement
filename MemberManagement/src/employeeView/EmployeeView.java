package employeeView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.EmployeeDao;
import dao.GroupDao;
import entity.Group;
import util.CallBack;
import employeeView.AddEmployeeView;
import employeeView.UpdateEmployeeView;
import entity.Employee;
import employeeView.EmployeeTableModel;

public class EmployeeView {
	List<Employee> list=new ArrayList<Employee>();//存数据
	List<Group> gList;
	EmployeeDao empDao = new EmployeeDao();
	GroupDao gDao = new GroupDao();
	JTable table;
	EmployeeTableModel model;
	JComboBox gBox;
	
	public void init(){
		JFrame jf=new JFrame("赛车俱乐部会员管理系统");
		jf.setSize(700, 500);//程序窗口大小
		jf.setLocationRelativeTo(null);//以屏幕中心为中心点显示
		
		JPanel mainPanel=(JPanel)jf.getContentPane();//初始化一个容器
		//上中下布局
		BoxLayout layout=new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);
		JPanel panel1=new JPanel();//上
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));//居中，左右间隔，上下间隔
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
		nameField.setPreferredSize(new Dimension(60, 30));
		panel1.add(nameField);
		
		JLabel sexLabel=new JLabel();
		sexLabel.setText("性別");
		panel1.add(sexLabel);
		
		JTextField sexField=new JTextField();
		sexField.setPreferredSize(new Dimension(60, 30));
		panel1.add(sexField);
		
		JLabel ageLabel=new JLabel();
		ageLabel.setText("年齡");
		panel1.add(ageLabel);
		
		JTextField ageField=new JTextField();
		ageField.setPreferredSize(new Dimension(60, 30));
		panel1.add(ageField);
		
		JLabel phoneLabel=new JLabel();
		phoneLabel.setText("联系方式");
		panel1.add(phoneLabel);
		
		JTextField phoneField=new JTextField();
		phoneField.setPreferredSize(new Dimension(100, 30));
		panel1.add(phoneField);
		
		JLabel gLabel = new JLabel();
		gLabel.setText("组别");
		panel1.add(gLabel);
		
		gList = gDao.search();//获取group集合
		
		gBox = new JComboBox();//下拉列表
		gBox.addItem("请选择分组");
		for (int i = 0; i < gList.size(); i++) {
			gBox.addItem(gList.get(i).getName());
		}
		gBox.setPreferredSize(new Dimension(100, 30));//使用布局管理器情况下，使用setPreferredSize()更具体设置更优先
		panel1.add(gBox);
		
		JButton  searchBtn=new JButton();
		searchBtn.setPreferredSize(new Dimension(60, 30));
		searchBtn.setText("查询");
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = nameField.getText();
				String sex = sexField.getText();
				String phone=phoneField.getText();
				int age = -1;
				try {
					age = Integer.parseInt(ageField.getText());
				} catch (Exception ex) {
				}
				Employee emp = new Employee();
				emp.setName(name);
				emp.setSex(sex);
				emp.setAge(age);
				emp.setTelephone(phone);
				Group gp = new Group();
				int index = gBox.getSelectedIndex();
				if (index == 0) {
					gp.setId(-1);
				} else {
					gp = gList.get(index - 1);//0开始
				}
				emp.setGp(gp);
				list = empDao.searchByCondition(emp);
				refreshTable(list);
			}
		});
		panel1.add(searchBtn);
		list = empDao.search();
		model=new EmployeeTableModel(list);//
		table=new JTable();
		table.setModel(model);
		//滚动条
		JScrollPane scroll=new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(550, 350));
		panel2.add(scroll);
		
		JButton  addBtn=new JButton();
		addBtn.setPreferredSize(new Dimension(60, 30));
		addBtn.setText("增加");
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddEmployeeView aev = AddEmployeeView.getInstance(new CallBack() {
					@Override
					public void call() {
						refreshTable();
					}
				});
				aev.openFrame();
			}
		});
		panel3.add(addBtn);
		
		JButton  deleteBtn=new JButton();
		deleteBtn.setPreferredSize(new Dimension(60, 30));
		deleteBtn.setText("删除");
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// delete();
				deleteBatch();
			}
		});
		panel3.add(deleteBtn);
		
		JButton  updateBtn=new JButton();
		updateBtn.setPreferredSize(new Dimension(60, 30));
		updateBtn.setText("修改");
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index > -1) {
					Employee selectEmp = list.get(index);
					new UpdateEmployeeView(selectEmp, new CallBack() {
						@Override
						public void call() {
							table.updateUI();
						}
					}).init();
				} else {
					JOptionPane.showMessageDialog(null, "请选中一条数据");
				}
			}
		});
		panel3.add(updateBtn);
		jf.setVisible(true);
	}
	public void delete() {
		int index = table.getSelectedRow();
		if (index > -1) {
			int option = JOptionPane.showConfirmDialog(null, "确认删除吗？", "确认", JOptionPane.YES_NO_OPTION);
			if (option == 0) {
				int id = list.get(index).getId();
				boolean flag = empDao.delete(id);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}
				refreshTable();
			}
		} else {
			JOptionPane.showMessageDialog(null, "请选中一条数据");
		}
	}

	public void deleteBatch() {
		int[] indexs = table.getSelectedRows();
		if (indexs.length > 0) {
			int option = JOptionPane.showConfirmDialog(null, "确认删除吗？", "确认", JOptionPane.YES_NO_OPTION);
			String deleteIds = "";
			if (option == 0) {
				for (int i = indexs.length - 1; i >= 0; i--) {
					deleteIds += list.get(indexs[i]).getId() + ",";
				}
				deleteIds = deleteIds.substring(0, deleteIds.length() - 1);
				empDao.delete(deleteIds);
				refreshTable();
			}
		} else {
			JOptionPane.showMessageDialog(null, "请选中一条数据");
		}
	}
	public void refreshTable() {
		list = empDao.search();
		model.setList(list);
		table.updateUI();
	}
	public void refreshTable(List<Employee> list) {
		model.setList(list);
		table.updateUI();
	}
	
	public static void main(String[] args) {
		new EmployeeView().init();
	}
}
