package group_carView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import dao.Group_CarDao;
import entity.Group;
import entity.Car;

public class G_C_View {
	List<Car> list = new ArrayList<>();
	Group_CarDao g_cDao = new Group_CarDao();
	JTable table;
	G_C_TableModel model;
	Group g;
	JComboBox proBox;
	List<Car> notProList;

	public G_C_View(Group g) {
		this.g = g;
	}

	public void init() {
		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);

		JLabel nameLabel = new JLabel();
		nameLabel.setText(g.getName());
		nameLabel.setFont(new Font(null, Font.BOLD, 20));
		panel1.add(nameLabel);

		// 查出所有的员工来
		list = g_cDao.searchByGroup(g.getId());

		model = new G_C_TableModel(list);
		table = new JTable();
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(400, 200));
		panel2.add(scroll);
		proBox = new JComboBox();
		notProList = g_cDao.searchByNotGroup(g.getId());
		for (int i = 0; i < notProList.size(); i++) {
			proBox.addItem(notProList.get(i).getName());
		}
		proBox.setPreferredSize(new Dimension(120, 30));
		panel3.add(proBox);

		JButton addBtn = new JButton();
		addBtn.setText("增加");
		addBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(addBtn);

		// addBtn.addActionListener(new ActionListenerClass());
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = proBox.getSelectedIndex();
				int proId = notProList.get(index).getId();
				boolean flag = g_cDao.add(g.getId(), proId);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}
				refresh();
			}
		});

		JButton deleteBtn = new JButton();
		deleteBtn.setText("删除");
		deleteBtn.setPreferredSize(new Dimension(80, 30));
		panel3.add(deleteBtn);

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delete();

				// deleteBatch();
			}
		});

		frame.setVisible(true);

	}

	public void delete() {

		int index = table.getSelectedRow();
		if (index > -1) {
			int option = JOptionPane.showConfirmDialog(null, "确认删除吗？", "确认", JOptionPane.YES_NO_OPTION);
			if (option == 0) {
				int id = list.get(index).getId();
				int depId = g.getId();
				int proId = list.get(index).getId();
				boolean flag = g_cDao.delete(depId, proId);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}

				refresh();
			}

		} else {
			JOptionPane.showMessageDialog(null, "请选中一条数据");

		}
	}

	public void refresh() {
		list = g_cDao.searchByGroup(g.getId());
		proBox.removeAllItems();
		notProList = g_cDao.searchByNotGroup(g.getId());
		for (int i = 0; i < notProList.size(); i++) {
			proBox.addItem(notProList.get(i).getName());
		}
		model.setList(list);
		table.updateUI();
	}

}
