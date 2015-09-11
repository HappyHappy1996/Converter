package ua.nagib.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import ua.nagib.calc.Calculator;

public class Frame extends JFrame {

	private static Frame frame = new Frame();
	
	private JButton swap = new JButton("Swap");
	private JButton calc = new JButton("Calcalute");
	
	private JComboBox<String> firstData = new JComboBox<String>();
	private JComboBox<String> secondData = new JComboBox<String>();
	private JComboBox<String> type = new JComboBox<String>();

	private JTextField firstField = new JTextField();
	private JTextField secondField = new JTextField();
	
	private Calculator calculator = Calculator.getInstance();
	

	public JTextField getFirstField() {
		return firstField;
	}
	
	public JTextField getSecondField() {
		return secondField;
	}


	public Frame() {

		setTitle("Converter");
		setBounds(100, 100, 400, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		add(firstData);
		add(secondData);
		// frame.window.add(type);
		add(swap);
		add(calc);
		add(firstField);
		add(secondField);

		firstData.setBounds(25, 100, 125, 25);
		secondData.setBounds(250, 100, 125, 25);
		swap.setBounds(160, 100, 80, 25);

		firstField.setBounds(25, 25, 125, 25);
		secondField.setEditable(false);
		secondField.setBounds(250, 25, 125, 25);

		calc.setBounds(140, 150, 115, 25);

		firstData.addItem(calculator.getGrzywna().toString());
		firstData.addItem(calculator.getDollar().toString());
		firstData.addItem(calculator.getEuro().toString());
		secondData.addItem(calculator.getGrzywna().toString());
		secondData.addItem(calculator.getDollar().toString());
		secondData.addItem(calculator.getEuro().toString());

		// fill comboBoxes

		swap.addMouseListener(new MouseAdapter() {
			int tempFirst;
			int tempSecond;

			public void mouseClicked(MouseEvent event) {

				tempFirst = firstData.getSelectedIndex();
				tempSecond = secondData.getSelectedIndex();

				firstData.setSelectedIndex(tempSecond);
				secondData.setSelectedIndex(tempFirst);
			}
		});

		calc.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				double result = calculator.convert((String)firstData.getSelectedItem(), (String)secondData.getSelectedItem(), frame);
				secondField.setText(String.valueOf(result));
			}
		});
	}

}
