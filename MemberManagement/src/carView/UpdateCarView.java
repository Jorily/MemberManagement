package carView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CarDao;
import entity.Car;
import util.CallBack;

public class UpdateCarView extends SuperCarView {
	CallBack callBack;
	Car selectEmp;

	public UpdateCarView(Car selectEmp, CallBack callBack) {
		this.callBack = callBack;
		this.selectEmp = selectEmp;
	}

	public void init() {
		super.init();
		nameText.setText(selectEmp.getName());

		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();

				// Project pro = new Project();
				selectEmp.setName(name);

				// list.add(pro);
				CarDao cDao = new CarDao();
				boolean flag = cDao.update(selectEmp);
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
