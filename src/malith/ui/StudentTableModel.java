
package malith.ui;


import chanaka.data.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Malith
 */
public class StudentTableModel extends AbstractTableModel {
         public static final int OBJECT_COL = -1;
	private static final int ADMISSION_NO = 0;
	private static final int NAME = 1;
	private static final int DOB = 2;
	private static final int GENDER = 3;

	private String[] columnNames = { "Admission No", "Name", "DOB","Gender" };
	private List<Student> student;

	public StudentTableModel(List<Student> student) {
		this.student = student;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return student.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Student tempStudent = student.get(row);

		switch (col) {
		case ADMISSION_NO:
			return tempStudent.getAdmissionNumber();
		case NAME:
			return tempStudent.getFullNameEnglish();
		case DOB:
			return tempStudent.getBirthDate();
		case GENDER:
			return tempStudent.getGender();
                case OBJECT_COL:
			return tempStudent;
		default:
			return tempStudent.getFullNameEnglish();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
