package groupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.GroupDao;
import entity.Group;
import util.CallBack;

public class AddGroupView extends SuperGroupView {

	CallBack callBack;
	private static AddGroupView instance;

	private AddGroupView(CallBack callBack) {
		this.callBack = callBack;
	}

	public static AddGroupView getInstance(CallBack callBack) {
		if (instance == null) {
			instance = new AddGroupView(callBack);
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
				
				Group g = new Group();
				g.setName(name);

				GroupDao gDao = new GroupDao();
				boolean flag = gDao.add(g);
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
