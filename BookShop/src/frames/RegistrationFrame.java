package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DaoUsers;
import db.DB;
import entity.Users;

public class RegistrationFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2198785878385337617L;
	private JPanel panel;
	private JTextField login;
	private JPasswordField password;
	private JLabel labelLogin, labelPassword;
	private JButton registration, cancel;

	public RegistrationFrame() {
		setTitle("RegistrationFrame");
		setSize(300, 130);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);
	}

	public void initComponents() {
		panel = new JPanel();
		login = new JTextField("newuser", 20);
		password = new JPasswordField("password", 20);

		labelLogin = new JLabel("newuser");
		labelPassword = new JLabel("pass");

		registration = new JButton("registration");
		cancel = new JButton("cancel");

		panel.add(labelLogin);
		panel.add(login);
		panel.add(labelPassword);
		panel.add(password);
		panel.add(registration);
		panel.add(cancel);

		add(panel);
	}

	public void action() {

		registration.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DaoUsers du = new DaoUsers();
				try {
					try {
						ResultSet rs = DB.getDb().query("SELECT * FROM users WHERE login ='" + login.getText() + "'");
						if (rs.next()) {
							JOptionPane.showMessageDialog(panel, "Такой пользователь уже существует!", "Ошибка!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							du.insert(new Users(login.getText(), String.valueOf(password.getPassword())));
							JOptionPane.showMessageDialog(panel, "Новый пользователь зарегестрирован", "Ок!",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (Exception q) {
					JOptionPane.showMessageDialog(panel, "Неправильный ввод!", "Неправильный ввод!",
							JOptionPane.ERROR_MESSAGE);
					new RegistrationFrame();
					dispose();
				}
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame();
				dispose();
			}
		});

	}

}
