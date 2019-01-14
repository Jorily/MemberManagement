package mainView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import groupView.GroupView;
import employeeView.EmployeeView;
import carView.CarView;
import messageView.MessageView;

public class MainView {

	public void init() {
		JFrame frame = new JFrame("赛车俱乐部会员管理系统");
		frame.setSize(400, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new FlowLayout());
		
		JButton empBtn = new JButton();
		empBtn.setText("员工管理");
		empBtn.setPreferredSize(new Dimension(180, 90));
		panel.add(empBtn);
		empBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EmployeeView().init();

			}
		});
		JButton gBtn = new JButton();
		gBtn.setText("组别管理");
		gBtn.setPreferredSize(new Dimension(180, 90));
		panel.add(gBtn);
		gBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GroupView().init();

			}
		});
		JButton cBtn = new JButton();
		cBtn.setText("赛车管理");
		cBtn.setPreferredSize(new Dimension(180, 90));
		panel.add(cBtn);
		cBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CarView().init();

			}
		});
		JButton messBtn = new JButton();
		messBtn.setText("会员信息管理");
		messBtn.setPreferredSize(new Dimension(180, 90));
		panel.add(messBtn);
		messBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MessageView().init();
			}
		});
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		new MainView().init();
	}
}
