
package malith.ui;



import chamin.data.Club;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Malith
 */
public class ClubTableModel extends AbstractTableModel {
        public static final int OBJECT_COL = -1;
	private static final int CLUB_ID = 0;
	private static final int CLUB_NAME = 1;
	private static final int TEACHER_IN_CHARGE = 2;
	private static final int PRESIDENT = 3;

	private String[] columnNames = { "Club ID", "Club Name", "Teacher InCharge","President" };
	private List<Club> club;

	public ClubTableModel(List<Club> club) {
		this.club = club;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return club.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Club tempClub = club.get(row);

		switch (col) {
		case CLUB_ID:
			return tempClub.getClubId();
		case CLUB_NAME:
			return tempClub.getClubName();
		case TEACHER_IN_CHARGE:
			return tempClub.getTeacherInchargeId();
		case PRESIDENT:
			return tempClub.getPresidentId();
                case OBJECT_COL:
			return tempClub;
		default:
			return tempClub.getClubName();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
