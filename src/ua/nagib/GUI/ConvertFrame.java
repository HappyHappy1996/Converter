package ua.nagib.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import ua.nagib.calc.Calculator;
import ua.nagib.db.DBWorker;

public class ConvertFrame extends JFrame {

	private JButton swap = new JButton("Swap");
	private JButton edit = new JButton("Edit");

	private JComboBox<String> firstData = new JComboBox<String>();
	private JComboBox<String> secondData = new JComboBox<String>();
	private JComboBox<String> type = new JComboBox<String>();

	private JTextField firstField = new JTextField();
	private JTextField secondField = new JTextField();

	private Calculator calculator;
	private Connection connection;

	public JTextField getFirstField() {
		return firstField;
	}

	public JTextField getSecondField() {
		return secondField;
	}

	public ConvertFrame(boolean isAdmin) throws IOException, SQLException {

		setTitle("Converter");
		setBounds(100, 100, 400, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		add(firstData);
		add(secondData);
		// add(type);
		add(swap);
		add(firstField);
		add(secondField);
		if (isAdmin) {
			add(edit);
		}

		initializeElements();
		initializeListeners();
	}

	private void initializeElements() throws SQLException, IOException {

		firstData.setBounds(25, 100, 125, 25);
		secondData.setBounds(250, 100, 125, 25);
		swap.setBounds(160, 100, 80, 25);

		firstField.setBounds(25, 25, 125, 25);
		secondField.setBounds(250, 25, 125, 25);
		secondField.setEditable(false);

		edit.setBounds(25, 150, 125, 30);

		connection = DBWorker.getInstance().getConnection();//
		calculator = Calculator.getInstance(connection);//

		firstData.addItem(calculator.getGrzywna().toString());
		firstData.addItem(calculator.getDollar().toString());
		firstData.addItem(calculator.getEuro().toString());
		secondData.addItem(calculator.getGrzywna().toString());
		secondData.addItem(calculator.getDollar().toString());
		secondData.addItem(calculator.getEuro().toString());
	}

	private void initializeListeners() {
		firstField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent event) {
				if (firstField.getText().length() == 0) {
					firstField.setText("");
					secondField.setText("0.0");
					return;
				}
				if (event.getKeyCode() != 0) {
					calc();
				}
			}
		});

		firstData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// calc();
			}

		});

		secondData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// calc();
			}

		});

		swap.addMouseListener(new MouseAdapter() {

			int tempFirst;
			int tempSecond;

			public void mouseClicked(MouseEvent event) {

				tempFirst = firstData.getSelectedIndex();
				tempSecond = secondData.getSelectedIndex();

				firstData.setSelectedIndex(tempSecond);
				secondData.setSelectedIndex(tempFirst);

				firstField.setText(secondField.getText());

				System.out.println(secondField.getText());

				calc();
				System.out.println("After calc: " + secondField.getText());
			}
		});
	}

	private void calc() {
		String result = String.valueOf(calculator.convert((String) firstData.getSelectedItem(),
				(String) secondData.getSelectedItem(), ConvertFrame.this));
		int index = result.length() - result.lastIndexOf('.');
		index = index > 4 ? 4 : index;
		secondField.setText(result.substring(0, result.indexOf('.') + index));
	}

}