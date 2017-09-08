package frames;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6253391184794113872L;

	public Table(ResultSet rs) {

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			DefaultTableModel dtm = new DefaultTableModel();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				dtm.addColumn(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					v.add(rs.getString(i));
				}
				dtm.addRow(v);
			}
			setModel(dtm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
