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

import dao.DaoOrders;
import db.DB;
import entity.Orders;

public class UserFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7273869499381054308L;
	private JPanel panel;
	private JButton add;
	private JButton del;
	private JButton finish;
	private Table table;
	private JScrollPane scroll;
	private Table table_order;
	private JScrollPane scroll_order;
	private int current_user;
	private static int orderNumber = 1;

	public UserFrame(int id_user) {
		current_user = id_user;
		setTitle("UserFrame");
		setSize(600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);
	}

	public void initComponents() {
		panel = new JPanel();
		panel.setBackground(Color.GREEN);

		add = new JButton("Добавить");
		del = new JButton("Удалить");
		finish = new JButton("Оплатить");

		try {
			table = new Table(DB.getDb().query("SELECT * FROM books"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(400, 300));

		panel.add(add);
		panel.add(del);
		panel.add(finish);
		panel.add(scroll);

		try {
			table_order = new Table(DB.getDb().query("SELECT * FROM orders WHERE id_user='" + current_user + "'"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		scroll_order = new JScrollPane(table_order);
		scroll_order.setPreferredSize(new Dimension(400, 300));

		panel.add(scroll_order);

		add(panel);

	}

	public void action() {
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					try {
						DaoOrders dOrders = new DaoOrders();
						int id_book = Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));

						Orders addedOrder = new Orders(orderNumber, current_user, id_book);
						dOrders.insert(addedOrder);

						updatetable();
					} catch (Exception q) {
						JOptionPane.showMessageDialog(panel, "Неправильный ввод!", "Неправильный ввод!",
								JOptionPane.ERROR_MESSAGE);
						new UserFrame(current_user);
						dispose();
					}
				}
			}
		});

		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					try {
						DaoOrders dOrders = new DaoOrders();
						int id_order = Integer
								.valueOf(String.valueOf(table_order.getValueAt(table_order.getSelectedRow(), 0)));
						dOrders.delete(id_order);
						updatetable();
					} catch (Exception q) {
						JOptionPane.showMessageDialog(panel, "Неправильный ввод!", "Неправильный ввод!",
								JOptionPane.ERROR_MESSAGE);
						new UserFrame(current_user);
						dispose();
					}
				}
			}
		});

		finish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DaoOrders dOrders = new DaoOrders();
				for (int i = 0; i < table_order.getRowCount(); i++) {

					int id_order = Integer.valueOf(String.valueOf(table_order.getValueAt(i, 0)));
					int order_number = Integer.valueOf(String.valueOf(table_order.getValueAt(i, 1)));
					int id_userOrder = Integer.valueOf(String.valueOf(table_order.getValueAt(i, 2)));
					int id_bookOrder = Integer.valueOf(String.valueOf(table_order.getValueAt(i, 3)));
					// int order_status =
					// Integer.valueOf(String.valueOf(table_order.getValueAt(i,
					// 4)));

					dOrders.update(new Orders(id_order, order_number, id_userOrder, id_bookOrder, 1));
				}

				updatetable();
				orderNumber += 1;
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
		// du.update(new Users(id_user, login, pass, role, del_status));
		// updatetable();
		// }
		// }
		// });
	}

	public void updatetable() {
		panel.remove(scroll_order);
		try {
			table_order = new Table(DB.getDb().query("SELECT * FROM orders WHERE id_user='" + current_user + "'"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scroll_order = new JScrollPane(table_order);
		scroll_order.setPreferredSize(new Dimension(400, 400));
		panel.add(scroll_order);
		panel.updateUI();
	}

}
