package indexView;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistView {
	public void init(){
		JFrame jf=new JFrame();	
		jf.setSize(500, 400);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel=(JPanel)jf.getContentPane();
		
		BoxLayout layout=new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);
		JPanel panel1=new JPanel();//上
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));//居中，左右间隔，上下间隔
		JPanel panel2=new JPanel();//下
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel panel3=new JPanel();//下
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
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
		
		JTextField pwdField=new JTextField();
		pwdField.setPreferredSize(new Dimension(200, 30));
		panel2.add(pwdField);
		

		JButton loginBtn=new JButton();
		loginBtn.setPreferredSize(new Dimension(100, 30));
		loginBtn.setText("注册");
		panel3.add(loginBtn);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new RegistView().init();
	}
}
