package group_carView;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import entity.Car;

public class G_C_TableModel extends AbstractTableModel {

	private List<Car> list;
	private String[] columnNames = { "id", "名称" };

	public G_C_TableModel(List<Car> list) {
		this.list = list;
	}

	public void setList(List<Car> list) {
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
		} else {
			return "";
		}

	}

}
