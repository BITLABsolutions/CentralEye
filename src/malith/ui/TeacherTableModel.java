
package malith.ui;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import prabath.data.Teacher;

/**
 *
 * @author Malith
 */
public class TeacherTableModel extends AbstractTableModel {
         public static final int OBJECT_COL = -1;
	private static final int NAME_WITH_IN_COL = 0;
	private static final int NIC_COL = 1;
	private static final int POSITION_COL = 2;
	private static final int TEL_NO_MOBLIE_COL = 3;

	private String[] columnNames = { "Name with Initials", "NIC", "Position","Mobile No" };// this should come from user input..... user can customize what fields to show
	private List<Teacher> teacher;

	public TeacherTableModel(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return teacher.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Teacher tempTeacher = teacher.get(row);

		switch (col) {
		case NAME_WITH_IN_COL:
			return tempTeacher.getNameWithin();
		case NIC_COL:
			return tempTeacher.getNIC();
		case POSITION_COL:
			return tempTeacher.getPositionInSchool();
		case TEL_NO_MOBLIE_COL:
			return tempTeacher.getTelNoMobile();
                case OBJECT_COL:
			return tempTeacher;
		default:
			return tempTeacher.getNameWithin();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
