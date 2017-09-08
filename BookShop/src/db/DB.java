package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	public static Properties prop;
	private Connection cn;
	private Statement st;
	private static DB db;
	private static boolean dbUse = false;
	/**
	 * � ������ ����� ������ ������ �������� � � ���� ������� ��� ���������� ��
	 * �������� �����
	 */
	static {
		prop = new Properties();
		try {
			prop.load(DB.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * � ������������ ������ ���������� � ��. ������� ��������� ����� Driver �
	 * ������ ������ �������. ����� ������ ������ ���������. ����� ������
	 * ������ ������ statement � ������� �������� ������������ ������� � ��
	 */

	private DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.login"),
					prop.getProperty("db.password"));
			st = cn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���������� ������� Singleton. ������ ������ ������ ���, ���� ������ ����
	 * ������� ��������� �������� ������� ������. ������ ���� ������!
	 */
	public static DB getDb() {
		if (db == null) {
			db = new DB();
		}
		if (!dbUse) {
			try {
				db.update("USE " + prop.getProperty("db.name"));
				dbUse = true;
			} catch (SQLException e) {
				// e.printStackTrace();
			}
		}
		return db;
	}

	/**
	 * ������ ����� ���������� ������ � ��. ���� ������� ������������ ������ ��
	 * �������, ������� �� ���������� ���������.
	 */
	public void update(String sql) throws SQLException {
		st.executeUpdate(sql);
	}

	/**
	 * ������ ����� ���������� ������ � ��. ���� ������� ������������ ������ ��
	 * �������, ������� ���������� ���������.
	 */

	public ResultSet query(String sql) throws SQLException {
		return st.executeQuery(sql);
	}

	/**
	 * � ������ ������ ������� �������� �� �������. � ����� ������� RS �
	 * ������� �������� �������� �� ��
	 */
	public void showTable(ResultSet rs) {
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			while (rs.next()) {
				System.out.println();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					System.out.print(rs.getString(i) + "\t");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCn() {
		return cn;
	}
}
