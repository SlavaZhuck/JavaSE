package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.WorkDB;

public class StartFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -637384556033663039L;
	private JPanel panel;
	private JTextField url, name, login;
	private JPasswordField password;
	private JLabel labelUrl, labelName, labelLogin, labelPassword;
	private JButton create, delete, connect;

	public StartFrame() {
		setTitle("StartFrame");
		setSize(280, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		action();
		setVisible(true);
	}

	public void initComponents() {
		panel = new JPanel();

		url = new JTextField("jdbc:mysql://127.0.0.1/", 20);
		name = new JTextField("shop", 20);
		login = new JTextField("root", 20);

		password = new JPasswordField("root", 20);

		labelUrl = new JLabel("url");
		labelName = new JLabel("name");
		labelLogin = new JLabel("login");
		labelPassword = new JLabel("pass");

		create = new JButton("Создать");
		delete = new JButton("Удалить");
		connect = new JButton("Войти");

		panel.add(labelUrl);
		panel.add(url);
		panel.add(labelName);
		panel.add(name);
		panel.add(labelLogin);
		panel.add(login);
		panel.add(labelPassword);
		panel.add(password);
		panel.add(create);
		panel.add(delete);
		panel.add(connect);

		add(panel);
	}

	public void action() {
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (WorkDB.createDB() == 2) {
						JOptionPane.showMessageDialog(panel, "БД уже существует!", "БД уже существует!",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception q) {
					JOptionPane.showMessageDialog(panel, "Ошибка!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
					new StartFrame();
					dispose();
				}
			}
		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (WorkDB.deleteDB() == 2) {
					JOptionPane.showMessageDialog(panel, "БД не существует!", "БД не существует!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (WorkDB.createDB() == 2) {
						// JOptionPane.showMessageDialog(panel, "БД уже
						// существует!", "БД уже существует!",
						// JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (Exception q) {
					JOptionPane.showMessageDialog(panel, "Ошибка!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
					new StartFrame();
					dispose();
				}
				new LoginFrame();
				dispose();
			}
		});

	}

}
