package carView;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SuperCarView {
	JFrame frame;
	JTextField nameText;

	JButton saveBtn;

	public void init() {
		frame = new JFrame();
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		mainPanel.add(panel1);
		mainPanel.add(panel2);

		JLabel nameLabel = new JLabel();
		nameLabel.setText("名称");
		panel1.add(nameLabel);
		nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameText);

		saveBtn = new JButton();
		saveBtn.setText("保存");
		saveBtn.setPreferredSize(new Dimension(80, 30));
		panel2.add(saveBtn);

		frame.setVisible(true);
	}
}
