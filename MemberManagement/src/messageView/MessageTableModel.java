package messageView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import entity.Message;

public class MessageTableModel extends AbstractTableModel {

	private List<Message> list;
	private Set<Message> saveSet = new HashSet<>();

	private String[] columnNames = { "id", "姓名", "组别", "车", "剩余玩车时间", "购买年份" };

	public MessageTableModel(List<Message> list) {
		this.list = list;
	}

	public void setList(List<Message> list) {
		this.list = list;
	}

	public String getColumnName(int column) {

		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 4) {

			if (list.get(rowIndex).getCar().getId() != 0) {
				return true;
			}
		}
		return false;
	}

	public void setTimeAt(Object aTime, int rowIndex, int columnIndex) {
		if (!aTime.equals("")) {
			list.get(rowIndex).setTime(Integer.parseInt((String) aTime));
			saveSet.add(list.get(rowIndex));
		}

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return list.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return list.get(rowIndex).getEmp().getName();
		} else if (columnIndex == 2) {
			return list.get(rowIndex).getEmp().getGp().getName();
		} else if (columnIndex == 3) {
			return list.get(rowIndex).getCar().getName();
		} else if (columnIndex == 4) {
			return list.get(rowIndex).getTime();
		} else if (columnIndex == 5) {
			return list.get(rowIndex).getYmd();
		} else {
			return "";
		}

	}

	public Set<Message> getSaveSet() {
		return saveSet;
	}

}
