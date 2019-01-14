package messageView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import dao.GroupDao;
import dao.MessageDao;
import employeeView.UpdateEmployeeView;
import entity.Car;
import entity.Employee;
import entity.Group;
import entity.Message;
import util.CallBack;

public class MessageView {
	List<Message> list = new ArrayList<>();
	MessageDao mDao = new MessageDao();
	GroupDao gDao = new GroupDao();
	JTable table;
	MessageTableModel model;
	JComboBox gBox;

	List<Group> gList;

	public void init() {
		JFrame frame = new JFrame("赛车俱乐部会员管理系统");
		frame.setSize(650, 500);
		frame.setLocationRelativeTo(null);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("姓名");
		panel1.add(nameLabel);
		JTextField nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameText);

		JLabel carLabel = new JLabel();
		carLabel.setText("车");
		panel1.add(carLabel);
		JTextField carText = new JTextField();
		carText.setPreferredSize(new Dimension(80, 30));
		panel1.add(carText);

		JLabel depLabel = new JLabel();
		depLabel.setText("组别");
		panel1.add(depLabel);
		gList = gDao.search();
		gBox = new JComboBox();
		gBox.addItem("请选择组别");
		for (int i = 0; i < gList.size(); i++) {
			gBox.addItem(gList.get(i).getName());
		}
		gBox.setPreferredSize(new Dimension(100, 30));
		panel1.add(gBox);

		JButton searchBtn = new JButton();
		searchBtn.setText("搜索");
		searchBtn.setPreferredSize(new Dimension(80, 30));
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = nameText.getText();
				String car = carText.getText();
				Employee em=new Employee();
				em.setName(name);
				Message mess = new Message();
				Car c=new  Car();
				c.setName(car);
				Group g = new Group();
				int index = gBox.getSelectedIndex();
				if (index == 0) {
					g.setId(-1);
				} else {
					g = gList.get(index - 1);
				}
				 em.setGp(g);
				 mess.setEmp(em);
				 mess.setCar(c);
				 list = mDao.searchByCondition(mess);
				 refreshTable(list);
			}
		});
		panel1.add(searchBtn);
		// 查出所有的员工来
		list = mDao.search();

		model = new MessageTableModel(list);
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(600, 300));
		panel2.add(scroll);

		JButton  updateBtn=new JButton();
		updateBtn.setPreferredSize(new Dimension(60, 30));
		updateBtn.setText("编辑");
		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index > -1) {
					Message selectMess = list.get(index);
					new UpdateMessageView(selectMess, new CallBack() {
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

		frame.setVisible(true);

	}

	public void refreshTable() {
		list = mDao.search();
		model.setList(list);
		table.updateUI();
	}
	public void refreshTable(List<Message> list) {
		model.setList(list);
		table.updateUI();
	}

	public static void main(String[] args) {
		new MessageView().init();
	}
}
