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
	 * в данном блоке создаём объект проперти и в него заносим всю информацию из
	 * проперти файла
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
	 * В конструкторе создаём соединение с БД. Сначала загружаем класс Driver в
	 * память нашего проекта. Затем создаём объект коннекшен. Затем создаём
	 * объект класса statement с помощью которого отправляются запросы в БД
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
	 * реализация шаблона Singleton. Данный шаблон делает так, чтоб нельзя было
	 * создать несколько объектов данного класса. ТОЛЬКО ОДИН ОБЪЕКТ!
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
	 * Данный метод отправляет запрос в БД. Этим методом отправляются только те
	 * запросы, которые НЕ возвращают результат.
	 */
	public void update(String sql) throws SQLException {
		st.executeUpdate(sql);
	}

	/**
	 * Данный метод отправляет запрос в БД. Этим методом отправляются только те
	 * запросы, которые возвращают результат.
	 */

	public ResultSet query(String sql) throws SQLException {
		return st.executeQuery(sql);
	}

	/**
	 * в данном методе выводим табличку на консоль. В метод передаём RS в
	 * котором хранится табличка из БД
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
