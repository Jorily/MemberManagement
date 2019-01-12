package groupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dao.GroupDao;
import entity.Group;
import util.CallBack;

public class UpdateGroupView extends SuperGroupView {
	CallBack callBack;
	Group selectEmp;

	public UpdateGroupView(Group selectEmp, CallBack callBack) {
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
				selectEmp.setName(name);
				GroupDao depDao = new GroupDao();
				boolean flag = depDao.update(selectEmp);
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
