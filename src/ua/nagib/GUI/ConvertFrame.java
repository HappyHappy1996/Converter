package ua.nagib.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ua.nagib.calc.Calculator;

public class ConvertFrame extends JFrame {

	private JButton swap = new JButton("Swap");

	private JComboBox<String> firstData = new JComboBox<String>();
	private JComboBox<String> secondData = new JComboBox<String>();
	private JTextField firstField = new JTextField();
	private JTextField secondField = new JTextField();

	private Calculator calculator;

	public JTextField getFirstField() {
		return firstField;
	}

	public JTextField getSecondField() {
		return secondField;
	}

	public ConvertFrame() {

		setTitle("Converter");
		setBounds(100, 100, 400, 220);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		add(firstData);
		add(secondData);
		add(swap);
		add(firstField);
		add(secondField);

		initializeElements();
		initializeListeners();
	}

	private void initializeElements() {

		firstData.setBounds(25, 100, 125, 25);
		secondData.setBounds(250, 100, 125, 25);
		swap.setBounds(160, 100, 80, 25);

		firstField.setBounds(25, 25, 125, 25);
		secondField.setBounds(250, 25, 125, 25);
		secondField.setEditable(false);

		try {
			calculator = Calculator.getInstance();
		} catch (SQLException | ReflectiveOperationException e) {
			JOptionPane.showMessageDialog(null, "Could not select currencies rates!");
			e.printStackTrace();
		}
		
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
				calc();
			}

		});

		secondData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				calc();
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

				calc();
			}
		});
	}

	private void calc() {
		double value = 0;
		try {
			value = Double.parseDouble(getFirstField().getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid data!");
		}
		String result = String.valueOf(calculator.convert((String) firstData.getSelectedItem(),
				(String) secondData.getSelectedItem(), value));
		int index = result.length() - result.lastIndexOf('.');
		index = index > 4 ? 4 : index;
		secondField.setText(result.substring(0, result.indexOf('.') + index));
	}

}