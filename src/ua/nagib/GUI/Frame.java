package ua.nagib.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frame extends JFrame {

	private JButton swap = new JButton("Swap");
	private JButton calc = new JButton("Calcalute");
	
	private JComboBox<String> firstData = new JComboBox<String>();
	private JComboBox<String> secondData = new JComboBox<String>();
	private JComboBox<String> type = new JComboBox<String>();

	private JTextField firstField = new JTextField();
	private JTextField secondField = new JTextField();
	

	public JTextField getFirstField() {
		return firstField;
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
		// window.add(type);
		add(swap);
		add(calc);
		add(firstField);
		add(secondField);

		firstData.setBounds(25, 100, 125, 25);
		secondData.setBounds(250, 100, 125, 25);
		swap.setBounds(160, 100, 80, 25);

		firstField.setBounds(25, 25, 125, 25);
		secondField.setBounds(250, 25, 125, 25);

		calc.setBounds(140, 150, 115, 25);

		firstData.addItem("Hryvnias");
		firstData.addItem("Dollars");
		firstData.addItem("Tugrik");
		secondData.addItem("Hryvnias");
		secondData.addItem("Dollars");
		secondData.addItem("Tugrik");

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
				
			}
		});
	}

}
