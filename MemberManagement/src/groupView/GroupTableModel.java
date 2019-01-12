package groupView;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Group;

public class GroupTableModel extends AbstractTableModel {

	private List<Group> list;
	private String[] columnNames = { "id", "名称" ,"人数"};

	public GroupTableModel(List<Group> list) {
		this.list = list;
	}

	public void setList(List<Group> list) {
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

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return list.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return list.get(rowIndex).getName();
		} else if (columnIndex == 2) {
			return list.get(rowIndex).getgCount();
		} else {
			return "";
		}

	}

}
