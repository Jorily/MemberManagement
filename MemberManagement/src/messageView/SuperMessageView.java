package messageView;

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
import dao.MessageDao;

import entity.Group;

public class SuperMessageView {
	JFrame frame;
	JTextField idText;
	JTextField nameText;
	JTextField groupText;
	JTextField carText;
	JTextField timeText;
	JTextField ymdText;
	JButton saveBtn;
	JComboBox gBox;
	MessageDao meDao = new MessageDao();
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
		
		JLabel idLabel = new JLabel();
		idLabel.setText("id");
		panel1.add(idLabel);
		idText = new JTextField();
		idText.setPreferredSize(new Dimension(80, 30));
		panel1.add(idText);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("姓名");
		panel1.add(nameLabel);
		nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameText);

		JLabel groupLabel = new JLabel();
		groupLabel.setText("组别");
		panel2.add(groupLabel);
		gBox = new JComboBox();
		gBox.addItem("请选择组别");
		for (int i = 0; i < gList.size(); i++) {
			gBox.addItem(gList.get(i).getName());
		}
		gBox.setPreferredSize(new Dimension(100, 30));
		panel1.add(gBox);
		
		JLabel carLabel = new JLabel();
		carLabel.setText("车");
		panel3.add(carLabel);
		carText = new JTextField();
		carText.setPreferredSize(new Dimension(80, 30));
		panel3.add(carText);
		
		JLabel timeLabel = new JLabel();
		timeLabel.setText("剩余时间");
		panel4.add(timeLabel);
		timeText = new JTextField();
		timeText.setPreferredSize(new Dimension(80, 30));
		panel4.add(timeText);
		
		
		JLabel ymdLabel = new JLabel();
		ymdLabel.setText("购买日期");
		panel4.add(ymdLabel);
		ymdText = new JTextField();
		ymdText.setPreferredSize(new Dimension(80, 30));
		panel4.add(ymdText);
	
		panel5.add(gBox);

		saveBtn = new JButton();
		saveBtn.setText("保存");
		saveBtn.setPreferredSize(new Dimension(80, 30));
		panel6.add(saveBtn);

		frame.setVisible(true);
	}
	
}
