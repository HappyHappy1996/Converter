package ua.nagib.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ua.nagib.calc.Calculator;

public class EditFrame extends JFrame {

	private JButton change = new JButton("Change");
	private JButton back = new JButton("Back");

	private JLabel valueLabel = new JLabel("Enter new value:");
	private JLabel type = new JLabel("Select type of currency:");

	private JComboBox<String> currency = new JComboBox<String>();

	private JTextField value = new JTextField();

	private Calculator calculator;

	private static EditFrame instance;

	public EditFrame() {
		setTitle("Changes");
		setBounds(100, 100, 290, 200);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		add(valueLabel);
		add(change);
		add(back);
		add(type);
		add(value);
		add(currency);

		try {
			calculator = Calculator.getInstance(null);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		valueLabel.setBounds(10, 20, 150, 25);
		value.setBounds(110, 20, 70, 25);
		type.setBounds(10, 55, 150, 25);
		currency.setBounds(150, 55, 125, 25);
		change.setBounds(50, 120, 100, 25);
		back.setBounds(155, 120, 80, 25);

		currency.addItem(calculator.getGrzywna().toString());
		currency.addItem(calculator.getDollar().toString());
		currency.addItem(calculator.getEuro().toString());

		initializeListeners();

	}

	public static synchronized EditFrame getInstance() {
		if (instance == null) {
			instance = new EditFrame();
		}
		return instance;
	}

	private void initializeListeners() {
		change.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {

			}
		});

		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				EditFrame.this.setVisible(false);
				LoginFrame.getInstance().setVisible(true);
			}
		});
	}

}
