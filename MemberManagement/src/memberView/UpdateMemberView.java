package memberView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Group;
import entity.Member;
import util.CallBack;

public class UpdateMemberView extends SuperMemberView {
	CallBack callBack;
	Member selectMem;

	public UpdateMemberView(Member selectMem, CallBack callBack) {
		this.callBack = callBack;
		this.selectMem = selectMem;
	}

	public void init() {
		super.init();
		nameText.setText(selectMem.getName());
		sexBox.setSelectedItem(selectMem.getSex());
		ageText.setText(String.valueOf(selectMem.getAge()));

		gBox.setSelectedItem(selectMem.getGp().getName());

		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String sex = (String) sexBox.getSelectedItem();
				int age = Integer.parseInt(ageText.getText());
				// Memloyee Mem = new Memloyee();
				selectMem.setName(name);
				selectMem.setAge(age);
				selectMem.setSex(sex);

				Group gp =gList.get(gBox.getSelectedIndex());
				selectMem.setGp(gp);;
				// list.add(Mem);

				boolean flag = memDao.update(selectMem);
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
