package ua.nagib.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	private JLabel pass = new JLabel("Password");

	private JTextField password = new JTextField();

	private JButton logIn = new JButton("LogIn");
	private JButton back = new JButton("Back");

	public LoginFrame() {
		setTitle("LogIn");
		setBounds(100, 100, 250, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		add(pass);
		add(password);
		add(logIn);
		add(back);

		pass.setBounds(90, 25, 100, 25);
		password.setBounds(50, 60, 150, 25);
		logIn.setBounds(75, 100, 100, 25);
		back.setBounds(75, 150, 100, 25);

		initializeListeners();

	}

	private void initializeListeners() {
		logIn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				// check admin
				try {
					new ConvertFrame(true);
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				LoginFrame.this.setVisible(false);
				SignInTypeFrame.getInstance().setVisible(true);
			}
		});
	}

}
