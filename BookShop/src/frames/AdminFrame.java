package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dao.DaoBooks;
import dao.DaoOrders;
import dao.DaoUsers;
import db.DB;
import entity.Books;
import entity.Orders;
import entity.Users;

public class AdminFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3301307927960004118L;
	private JPanel panel;
	private JButton update;
	private Table table;
	private JScrollPane scroll;
	private Table table_books;
	private JScrollPane scroll_books;
	private Table table_orders;
	private JScrollPane scroll_orders;

	public AdminFrame() {
		setTitle("AdminFrame");
		setSize(500, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);
	}

	public void initComponents() {
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		update = new JButton("Обновить");

		try {
			table = new Table(DB.getDb().query("SELECT * FROM users"));
			table_books = new Table(DB.getDb().query("SELECT * FROM books"));
			table_orders = new Table(DB.getDb().query("SELECT * FROM orders"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(400, 150));
		scroll_books = new JScrollPane(table_books);
		scroll_books.setPreferredSize(new Dimension(400, 150));
		scroll_orders = new JScrollPane(table_orders);
		scroll_orders.setPreferredSize(new Dimension(400, 150));

		panel.add(update);
		panel.add(scroll);
		panel.add(scroll_books);
		panel.add(scroll_orders);

		add(panel);

	}

	public void action() {
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DaoUsers du = new DaoUsers();
					for (int i = 0; i < table.getRowCount(); i++) {

						int id_user = Integer.valueOf(String.valueOf(table.getValueAt(i, 0)));
						String login = String.valueOf(table.getValueAt(i, 1));
						String pass = String.valueOf(table.getValueAt(i, 2));
						int role = Integer.valueOf(String.valueOf(table.getValueAt(i, 3)));
						int del_status = Integer.valueOf(String.valueOf(table.getValueAt(i, 4)));

						if (du.update(new Users(id_user, login, pass, role, del_status)) == 0) {
							JOptionPane.showMessageDialog(panel, "Неправильный ввод!", "Неправильный тип данных!",
									JOptionPane.ERROR_MESSAGE);
							new AdminFrame();
							dispose();
						}
						;
					}

					DaoBooks dBooks = new DaoBooks();
					for (int i = 0; i < table_books.getRowCount(); i++) {

						int id_book = Integer.valueOf(String.valueOf(table_books.getValueAt(i, 0)));
						String author = String.valueOf(table_books.getValueAt(i, 1));
						String name = String.valueOf(table_books.getValueAt(i, 2));
						int price = Integer.valueOf(String.valueOf(table_books.getValueAt(i, 3)));
						int del_status_b = Integer.valueOf(String.valueOf(table_books.getValueAt(i, 4)));

						if (dBooks.update(new Books(id_book, author, name, price, del_status_b)) == 0) {
							JOptionPane.showMessageDialog(panel, "Неправильный ввод!", "Неправильный тип данных!",
									JOptionPane.ERROR_MESSAGE);
							new AdminFrame();
							dispose();
						}
						;
					}

					DaoOrders dOrders = new DaoOrders();
					for (int i = 0; i < table_orders.getRowCount(); i++) {

						int id_order = Integer.valueOf(String.valueOf(table_orders.getValueAt(i, 0)));
						int order_number = Integer.valueOf(String.valueOf(table_orders.getValueAt(i, 1)));
						int id_userOrder = Integer.valueOf(String.valueOf(table_orders.getValueAt(i, 2)));
						int id_bookOrder = Integer.valueOf(String.valueOf(table_orders.getValueAt(i, 3)));
						int del_status_o = Integer.valueOf(String.valueOf(table_orders.getValueAt(i, 4)));

						if (dOrders.update(
								new Orders(id_order, order_number, id_userOrder, id_bookOrder, del_status_o)) == 0) {
							JOptionPane.showMessageDialog(panel, "Неправильный ввод!", "Неправильный тип данных!",
									JOptionPane.ERROR_MESSAGE);
							new AdminFrame();
							dispose();
						}
						;
					}
				} catch (Exception q) {
					JOptionPane.showMessageDialog(panel, "Неправильный ввод!", "Неправильный ввод!",
							JOptionPane.ERROR_MESSAGE);
					new AdminFrame();
					dispose();
				}
			}
		});

		// table.addKeyListener(new KeyAdapter() {
		//
		// @Override
		// public void keyReleased(KeyEvent e) {
		// if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		// DaoUsers du = new DaoUsers();
		// int id_user =
		// Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(),
		// 0)));
		// String login =
		// String.valueOf(table.getValueAt(table.getSelectedRow(), 1));
		// String pass = String.valueOf(table.getValueAt(table.getSelectedRow(),
		// 2));
		// int role =
		// Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(),
		// 3)));
		// int del_status =
		// Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(),
		// 4)));
		//
		// DaoBooks dbooks = new DaoBooks();
		// int id_book =
		// Integer.valueOf(String.valueOf(table_books.getValueAt(table_books.getSelectedRow(),
		// 0)));
		// String author =
		// String.valueOf(table_books.getValueAt(table_books.getSelectedRow(),
		// 1));
		// String name =
		// String.valueOf(table_books.getValueAt(table_books.getSelectedRow(),
		// 2));
		// int price =
		// Integer.valueOf(String.valueOf(table_books.getValueAt(table_books.getSelectedRow(),
		// 3)));
		// int del_status_b =
		// Integer.valueOf(String.valueOf(table_books.getValueAt(table_books.getSelectedRow(),
		// 4)));
		//
		// DaoOrders dorders = new DaoOrders();
		// int id_order =
		// Integer.valueOf(String.valueOf(table_orders.getValueAt(table_orders.getSelectedRow(),
		// 0)));
		// int order_number =
		// Integer.valueOf(String.valueOf(table_orders.getValueAt(table_orders.getSelectedRow(),
		// 1)));
		// int id_userOrder =
		// Integer.valueOf(String.valueOf(table_orders.getValueAt(table_orders.getSelectedRow(),
		// 2)));
		// int id_bookOrder =
		// Integer.valueOf(String.valueOf(table_orders.getValueAt(table_orders.getSelectedRow(),
		// 3)));
		// int del_status_o =
		// Integer.valueOf(String.valueOf(table_orders.getValueAt(table_orders.getSelectedRow(),
		// 4)));
		//
		// du.update(new Users(id_user, login, pass, role, del_status));
		// dbooks.update(new Books(id_book, author, name, price, del_status_b));
		// dorders.update(new Orders(id_order, order_number, id_userOrder,
		// id_bookOrder, del_status_o));
		// updatetable();
		// }
		// }
		// });
	}

	public void updatetable() {
		panel.remove(scroll);
		panel.remove(scroll_books);
		panel.remove(scroll_orders);
		try {
			table = new Table(DB.getDb().query("SELECT * FROM users"));
			table_books = new Table(DB.getDb().query("SELECT * FROM books"));
			table_orders = new Table(DB.getDb().query("SELECT * FROM orders"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(400, 150));
		scroll_books = new JScrollPane(table_books);
		scroll_books.setPreferredSize(new Dimension(400, 150));
		scroll_orders = new JScrollPane(table_orders);
		scroll_orders.setPreferredSize(new Dimension(400, 150));

		panel.add(scroll);
		panel.add(scroll_books);
		panel.add(scroll_orders);
		panel.updateUI();
	}

}
