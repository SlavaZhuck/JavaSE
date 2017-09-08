package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import entity.Orders;

public class DaoOrders implements DaoInterface<Orders> {

	@Override
	public void insert(Orders ob) {
		try {

			PreparedStatement ps = DB.getDb().getCn().prepareStatement("INSERT INTO orders VALUES (?,?,?,?,?)");
			ps.setInt(1, ob.getId_order());
			ps.setInt(2, ob.getOrder_number());
			ps.setInt(3, ob.getId_user());
			ps.setInt(4, ob.getId_book());
			ps.setInt(5, ob.getOrder_status());

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			PreparedStatement ps = DB.getDb().getCn().prepareStatement("DELETE FROM orders WHERE id_order = ?");
			ps.setInt(1, id);

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int update(Orders ob) {
		try {
			PreparedStatement ps = DB.getDb().getCn().prepareStatement(
					"UPDATE orders SET order_number = ?, id_user = ?, id_book = ? , order_status = ? WHERE id_order = ?");
			ps.setInt(1, ob.getOrder_number());
			ps.setInt(2, ob.getId_user());
			ps.setInt(3, ob.getId_book());
			ps.setInt(4, ob.getOrder_status());
			ps.setInt(5, ob.getId_order());

			ps.execute();
			return 1;
		} catch (SQLException e) {
			return 0;
		}
	}

	@Override
	public Orders get(int id) {
		Orders order = null;
		try {
			ResultSet rs = DB.getDb().query("SELECT * FROM orders WHERE id_order = " + id);
			if (rs.next()) {
				order = new Orders(rs.getInt("id_order"), rs.getInt("order_number"), rs.getInt("id_user"),
						rs.getInt("id_book"), rs.getInt("order_status"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

}
