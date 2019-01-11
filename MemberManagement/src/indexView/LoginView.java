package indexView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView {
	public void init(){
	JFrame jf=new JFrame("赛车小会员管理系统");
	jf.setSize(400, 300);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setLocationRelativeTo(null);
	JPanel mainPanel= (JPanel)jf.getContentPane();
	
	BoxLayout layout=new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
	mainPanel.setLayout(layout);
	JPanel panel1=new JPanel();//上
	panel1.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));//居中，左右间隔，上下间隔
	JPanel panel2=new JPanel();//中
	panel1.setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
	JPanel panel3=new JPanel();//下
	panel3.setLayout(new FlowLayout(FlowLayout.CENTER,55,5));
	mainPanel.add(panel1);
	mainPanel.add(panel2);
	mainPanel.add(panel3);
	
	JLabel idLabel=new JLabel();
	idLabel.setText("账户");
	panel1.add(idLabel);
	
	JTextField idField=new JTextField();
	idField.setPreferredSize(new Dimension(200, 30));
	panel1.add(idField);
	
	JLabel pwdLabel=new JLabel();
	pwdLabel.setText("密码");
	panel2.add(pwdLabel);
	
	JTextField nameField=new JTextField();
	nameField.setPreferredSize(new Dimension(200, 30));
	panel2.add(nameField);
	
	JButton registBtn=new JButton();
	registBtn.setPreferredSize(new Dimension(100, 30));
	registBtn.setText("注册");
	panel3.add(registBtn);
	registBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new RegistView().init();
		}
	});
	
	JButton loginBtn=new JButton();
	loginBtn.setPreferredSize(new Dimension(100, 30));
	loginBtn.setText("登录");
	panel3.add(loginBtn);
	
	loginBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new MainView().init();
			
		}
	});
	jf.setVisible(true);
	
	}
	public static void main(String[] args) {
		new LoginView().init();
	}
	
}
