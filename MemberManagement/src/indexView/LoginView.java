package indexView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.IndexDao;
import mainView.MainView;

public class LoginView {
	JFrame jf = new JFrame("赛车小会员管理系统");

	JPanel mainPanel = (JPanel) jf.getContentPane();
	BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
	JPanel panel1 = new JPanel();// 上
	JPanel panel2 = new JPanel();// 中
	JPanel panel3 = new JPanel();// 下
	JLabel idLabel = new JLabel();
	JTextField idField = new JTextField();
	JLabel pwdLabel = new JLabel();
	JPasswordField pwdField = new JPasswordField();
	

	public void init() {
		jf.setSize(400, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		mainPanel.setLayout(layout);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));// 居中，左右间隔，上下间隔
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 55, 5));
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		idLabel.setText("账户");
		panel1.add(idLabel);
		idField.setPreferredSize(new Dimension(200, 30));
		panel1.add(idField);
		pwdLabel.setText("密码");
		panel2.add(pwdLabel);
		pwdField.setPreferredSize(new Dimension(200, 30));
		panel2.add(pwdField);
		JButton registBtn = new JButton();
		registBtn.setPreferredSize(new Dimension(100, 30));
		registBtn.setText("注册");
		panel3.add(registBtn);
		registBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zhuce();
			}
		});

		JButton loginBtn = new JButton();
		loginBtn.setPreferredSize(new Dimension(100, 30));
		loginBtn.setText("登录");
		panel3.add(loginBtn);

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				denglu();
				new MainView().init();
			}
		});
		jf.setVisible(true);
	}

	public void denglu() {
		IndexDao d = new IndexDao();
		String username = idField.getText();
		String password = pwdField.getText();
		if (d.compare(username, password)) {
			JOptionPane.showMessageDialog(null, "登录成功！");
			// super.setVisible(false);
		}
	}
	//注册按钮触发后的事件处理函数
		public void zhuce(){
			IndexDao d = new IndexDao();
			String username = idField.getText();
			String password = pwdField.getText();
			d.insert(username,password);
			JOptionPane.showMessageDialog(null, "注册成功！");
		}


	public static void main(String[] args) {
		new LoginView().init();
	}

}
