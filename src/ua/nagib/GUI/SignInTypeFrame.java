package ua.nagib.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SignInTypeFrame extends JFrame {
	
	private JButton admin = new JButton("Admin");
	private JButton guest = new JButton("Guest");
	
	private JLabel enter = new JLabel("Sign in as:");
	
	private static SignInTypeFrame instance;
	
	public SignInTypeFrame(){
		setTitle("Sign In");
		setBounds(100, 100, 200, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		add(enter);
		add(admin);
		add(guest);
		
		enter.setBounds(50, 20, 150, 25);
		admin.setBounds(30, 60, 120, 25);
		guest.setBounds(30, 110, 120, 25);
		
		initializeListeners();
	}
	
	public static synchronized SignInTypeFrame getInstance() {
		if (instance == null) {
			instance = new SignInTypeFrame();
		}
		return instance;
	}
	
	private void initializeListeners(){
		guest.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				try {
					new ConvertFrame(false);
					SignInTypeFrame.this.setVisible(false);
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		admin.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				new LoginFrame();
				SignInTypeFrame.this.setVisible(false);
			}
		});
	}

}
