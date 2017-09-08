package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import entity.Users;

public class DaoUsers implements DaoInterface<Users> {

	@Override
	public void insert(Users ob) {
		try {

			PreparedStatement ps = DB.getDb().getCn().prepareStatement("INSERT INTO users VALUES (?,?,?,?,?)");
			ps.setInt(1, ob.getId_user());
			ps.setString(2, ob.getLogin());
			ps.setString(3, ob.getPass());
			ps.setInt(4, ob.getRole());
			ps.setInt(5, ob.getDel_status());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * DB db = DB.getDb(); Connection cn = db.getCn(); PreparedStatement ps
		 * = cn.prepareStatement("");
		 */
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement ps = DB.getDb().getCn()
					.prepareStatement("UPDATE users SET del_status = 2 WHERE id_user = ?");
			ps.setInt(1, id);

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int update(Users ob) {
		try {
			PreparedStatement ps = DB.getDb().getCn().prepareStatement(
					"UPDATE users SET login = ?, pass = ?, role = ?, del_status = ? WHERE id_user = ?");
			ps.setString(1, ob.getLogin());
			ps.setString(2, ob.getPass());
			ps.setInt(3, ob.getRole());
			ps.setInt(4, ob.getDel_status());
			ps.setInt(5, ob.getId_user());

			ps.execute();
			return 1;
		} catch (SQLException e) {
			// e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Users get(int id) {
		Users user = null;
		try {
			ResultSet rs = DB.getDb().query("SELECT * FROM users WHERE id_user = " + id);
			if (rs.next()) {
				user = new Users(rs.getInt("id_user"), rs.getString("login"), rs.getString("pass"), rs.getInt("role"),
						rs.getInt("del_status"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
