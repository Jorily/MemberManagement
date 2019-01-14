package carView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.CarDao;
import entity.Car;
import util.CallBack;

public class AddCarView extends SuperCarView {

	CallBack callBack;
	private static AddCarView instance;

	private AddCarView(CallBack callBack) {
		this.callBack = callBack;
	}

	public static AddCarView getInstance(CallBack callBack) {
		if (instance == null) {
			instance = new AddCarView(callBack);
		}
		return instance;
	}

	public void openFrame() {
		if (frame == null) {
			init();
		} else {
			nameText.setText("");

			frame.setVisible(true);
		}
	}

	public void init() {
		super.init();
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				Car c = new Car();
				c.setName(name);
				CarDao proDao = new CarDao();
				boolean flag = proDao.add(c);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}

				frame.dispose();
				callBack.call();

			}
		});
	}

}
