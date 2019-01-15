package memberView;

import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.GroupDao;
import dao.MemberDao;
import entity.Group;

public class SuperMemberView {
	JFrame frame;
	JTextField nameText;
	JComboBox sexBox;
	JTextField ageText;
	JTextField phoneText;
	JButton saveBtn;
	JComboBox gBox;
	MemberDao memDao = new MemberDao();
	GroupDao gDao = new GroupDao();
	List<Group> gList;

	public void init() {
		frame = new JFrame();
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
		JLabel nameLabel = new JLabel();
		nameLabel.setText("姓名");
		panel1.add(nameLabel);
		nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameText);

		JLabel sexLabel = new JLabel();
		sexLabel.setText("性别");
		panel2.add(sexLabel);
		sexBox = new JComboBox();
		sexBox.addItem("男");
		sexBox.addItem("女");
		sexBox.setPreferredSize(new Dimension(80, 30));
		panel2.add(sexBox);
		
		JLabel ageLabel = new JLabel();
		ageLabel.setText("年龄");
		panel3.add(ageLabel);
		ageText = new JTextField();
		ageText.setPreferredSize(new Dimension(80, 30));
		panel3.add(ageText);
		
		JLabel phoneLabel = new JLabel();
		phoneLabel.setText("联系方式");
		panel4.add(phoneLabel);
		phoneText = new JTextField();
		phoneText.setPreferredSize(new Dimension(80, 30));
		panel4.add(phoneText);
		
		JLabel gLabel = new JLabel();
		gLabel.setText("组别");
		panel5.add(gLabel);
		gList = gDao.search();
		gBox = new JComboBox();
		for (int i = 0; i < gList.size(); i++) {
			gBox.addItem(gList.get(i).getName());
		}
		gBox.setPreferredSize(new Dimension(80, 30));
		panel5.add(gBox);

		saveBtn = new JButton();
		saveBtn.setText("保存");
		saveBtn.setPreferredSize(new Dimension(80, 30));
		panel6.add(saveBtn);

		frame.setVisible(true);
	}
	
}
