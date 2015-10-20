package ua.nagib.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	private JCheckBox isAdmin = new JCheckBox("I'm admin");

	private JLabel pass = new JLabel("Password");

	private JTextField password = new JTextField();

	private JButton logIn = new JButton("LogIn");

	private static LoginFrame instance;

	public LoginFrame() {
		setTitle("LogIn");
		setBounds(100, 100, 250, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		add(pass);
		add(password);
		add(isAdmin);
		add(logIn);

		pass.setBounds(90, 25, 100, 25);
		password.setBounds(50, 60, 150, 25);
		password.setEditable(false);
		isAdmin.setBounds(75, 100, 100, 25);
		logIn.setBounds(75, 150, 100, 25);

		initializeListeners();

	}

	public static synchronized LoginFrame getInstance() {
		if (instance == null) {
			instance = new LoginFrame();
		}
		return instance;
	}

	private void initializeListeners() {
		logIn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (!isAdmin.isSelected()) {
					try {
						new ConvertFrame();
						LoginFrame.this.setVisible(false);
					} catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (isAdmin.isSelected()) {
					EditFrame.getInstance();
					EditFrame.getInstance().setVisible(true);
					LoginFrame.this.setVisible(false);
				}
			}
		});

		isAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (isAdmin.isSelected()) {
					password.setEditable(true);
				} else {
					password.setEditable(false);
				}
			}
		});
	}

}
