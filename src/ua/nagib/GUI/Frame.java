package ua.nagib.GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frame extends JFrame{
	
	JButton swap = new JButton("Swap");
	JButton calc = new JButton("Calcalute");
	
	JComboBox<String> firstData = new JComboBox <String>();
	JComboBox<String> secondData = new JComboBox<String>();
	
	JTextField firstField = new JTextField();
	JTextField secondField = new JTextField();

	public Frame(){
		
		JFrame window = new JFrame("Converter");
		window.setBounds(100, 100, 400, 300);
		window.setVisible(true);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setResizable(false);
		
		window.add(firstData);
		window.add(secondData);
		window.add(swap);
		window.add(calc);
		window.add(firstField);
		window.add(secondField);
		
		firstData.setBounds(25, 75, 125, 25);
		
		//fill comboBoxes
		
		
	}
}
