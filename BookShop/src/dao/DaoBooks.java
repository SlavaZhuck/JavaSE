package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import entity.Books;

public class DaoBooks implements DaoInterface<Books> {

	@Override
	public void insert(Books ob) {
		try {
			PreparedStatement ps = DB.getDb().getCn().prepareStatement("INSERT INTO books VALUES (?,?,?,?,?)");
			ps.setInt(1, ob.getId_book());
			ps.setString(2, ob.getAuthor());
			ps.setString(3, ob.getName());
			ps.setInt(4, ob.getPrice());
			ps.setInt(5, ob.getDel_status());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement ps = DB.getDb().getCn()
					.prepareStatement("UPDATE books SET del_status = 2 WHERE id_book = ?");
			ps.setInt(1, id);

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int update(Books ob) {
		try {
			PreparedStatement ps = DB.getDb().getCn().prepareStatement(
					"UPDATE books SET author = ?, name = ?, price = ? , del_status = ? WHERE id_book = ?");
			ps.setString(1, ob.getAuthor());
			ps.setString(2, ob.getName());
			ps.setInt(3, ob.getPrice());
			ps.setInt(4, ob.getDel_status());
			ps.setInt(5, ob.getId_book());

			ps.execute();
			return 1;
		} catch (SQLException e) {
			return 0;
		}
	}

	@Override
	public Books get(int id) {
		Books book = null;
		try {
			ResultSet rs = DB.getDb().query("SELECT * FROM books WHERE id_book = " + id);
			if (rs.next()) {
				book = new Books(rs.getInt("id_book"), rs.getString("author"), rs.getString("name"), rs.getInt("price"),
						rs.getInt("del_status"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

}
