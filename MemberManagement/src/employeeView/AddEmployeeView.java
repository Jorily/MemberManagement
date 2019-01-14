package employeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Group;
import entity.Employee;
import util.CallBack;

public class AddEmployeeView extends SuperEmployeeView {

	CallBack callBack;
	private static AddEmployeeView instance;

	private AddEmployeeView(CallBack callBack) {
		this.callBack = callBack;
	}

	public static AddEmployeeView getInstance(CallBack callBack) {
		if (instance == null) {
			instance = new AddEmployeeView(callBack);
		}
		return instance;
	}

	public void openFrame() {
		if (frame == null) {
			init();
		} else {//不为空则把其值初始化
			nameText.setText("");
			sexBox.setSelectedItem("男");
			ageText.setText("");
			phoneText.setText("");
			
			frame.setVisible(true);
		}
	}

	public void init() {
		super.init();
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String sex = (String) sexBox.getSelectedItem();
				int age = Integer.parseInt(ageText.getText());
				String phone=phoneText.getText();
				int index = gBox.getSelectedIndex();
				Group gp = gList.get(index);
				Employee emp = new Employee();
				emp.setName(name);
				emp.setAge(age);
				emp.setSex(sex);
				emp.setTelephone(phone);
				emp.setGp(gp);
				boolean flag = empDao.add(emp);
				if (flag) {
					JOptionPane.showMessageDialog(null, "保存成功！");
				} else {
					JOptionPane.showMessageDialog(null, "保存失败！");
				}
				//释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源。即这些 Component 的资源将被破坏，它们使用的所有内存都将返回到操作系统，并将它们标记为不可显示。
				frame.dispose();
				callBack.call();

			}
		});
	}

}
