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

import db.DB;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6136948687364113497L;
	private JPanel panel;
	private JTextField login;
	private JPasswordField password;
	private JLabel labelLogin, labelPassword;
	private JButton ok, registration;

	public LoginFrame() {
		setTitle("LoginFrame");
		setSize(280, 120);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);
	}

	public void initComponents() {
		panel = new JPanel();
		login = new JTextField("admin", 20);
		password = new JPasswordField("admin", 20);
		labelLogin = new JLabel("login");
		labelPassword = new JLabel("pass");

		ok = new JButton("Войти");
		registration = new JButton("Рега");

		panel.add(labelLogin);
		panel.add(login);
		panel.add(labelPassword);
		panel.add(password);
		panel.add(ok);
		panel.add(registration);

		add(panel);
	}

	public void action() {

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					ResultSet rs = DB.getDb().query("SELECT * FROM users WHERE login ='" + login.getText() + "'");
					if (rs.next()) {
						if (rs.getString("pass").equals(String.valueOf(password.getPassword()))) {
							if (rs.getInt("del_status") == 1) {
								if (rs.getInt("role") == 1) {
									JOptionPane.showMessageDialog(panel, "User!", "User!",
											JOptionPane.INFORMATION_MESSAGE);
									new UserFrame(rs.getInt("id_user"));
								} else {
									JOptionPane.showMessageDialog(panel, "Admin!", "Admin!",
											JOptionPane.INFORMATION_MESSAGE);
									new AdminFrame();
									// dispose();
								}
							} else {
								JOptionPane.showMessageDialog(panel, "Пользователь заблокирован!", "Ошибка!",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(panel, "Пароль отстой!", "Ошибка!",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(panel, "Не существует такого пользователя!", "Ошибка!",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		registration.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new RegistrationFrame();
				dispose();

			}
		});

	}

}
