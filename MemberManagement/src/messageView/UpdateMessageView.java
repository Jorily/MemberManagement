package messageView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Group;
import entity.Message;
import entity.Employee;
import util.CallBack;

public class UpdateMessageView extends SuperMessageView {
	CallBack callBack;
	Message selectMess;

	public UpdateMessageView(Message selectMess, CallBack callBack) {
		this.callBack = callBack;
		this.selectMess = selectMess;
	}

	public void init() {
		super.init();
		nameText.setText(selectMess.getEmp().getName());
		carText.setText(selectMess.getCar().getName());
		gBox.setSelectedItem(selectMess.getEmp().getGp().getName());
		timeText.setText(String.valueOf(selectMess.getTime()));
		ymdText.setText(selectMess.getYmd());
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Employee emp=new Employee();
				String name = nameText.getText();
				int time = Integer.parseInt(timeText.getText());
				String ymd=ymdText.getText();
				emp.setName(name);
				selectMess.setEmp(emp);
				selectMess.setTime(time);
				selectMess.setYmd(ymd);

				Group gp =gList.get(gBox.getSelectedIndex());
				selectMess.getEmp().setGp(gp);
				// list.add(emp);
				boolean flag = meDao.update(selectMess);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}

				frame.dispose();
				callBack.call();

			}
		});

		frame.setVisible(true);
	}

}
