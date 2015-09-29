package ua.nagib.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
	
	private JLabel log = new JLabel("Login");
	private JLabel pass = new JLabel("Password");
	
	private JTextField login = new JTextField();
	private JTextField password = new JTextField();
	
	private JButton logIn = new JButton("LogIn");
	
	public LoginFrame(){
		setTitle("LogIn");
		setBounds(100, 100, 250, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		add(log);
		add(pass);
		add(login);
		add(password);
		add(logIn);
		
		log.setBounds(100, 20, 100, 25);
		login.setBounds(50, 50, 150, 25);
		pass.setBounds(90, 90, 100, 25);
		password.setBounds(50, 120, 150, 25);
		logIn.setBounds(75, 180, 100, 25);
		
		
		logIn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				//check admin
				LoginFrame.this.setVisible(false);
				try {
					ConvertFrame frame = new ConvertFrame();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

}
