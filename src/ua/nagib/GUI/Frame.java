package ua.nagib.GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frame extends JFrame{
	
	JButton swap = new JButton("Swap");
	JButton calc = new JButton("Calcalute");
	
	JComboBox<String> firstData = new JComboBox <String>();
	JComboBox<String> secondData = new JComboBox<String>();
	JComboBox<String> type = new JComboBox<String>();
	
	JTextField firstField = new JTextField();
	JTextField secondField = new JTextField();

	public Frame(){
		
		JFrame window = new JFrame("Converter");
		window.setBounds(100, 100, 400, 250);
		window.setVisible(true);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setLayout(null);
		window.setResizable(false);
		
		window.add(firstData);
		window.add(secondData);
		//window.add(type);
		window.add(swap);
		window.add(calc);
		window.add(firstField);
		window.add(secondField);
		
		firstData.setBounds(25, 100, 125, 25);
		secondData.setBounds(250, 100, 125, 25);
		swap.setBounds(160, 100, 80, 25);
		
		firstField.setBounds(25, 25, 125, 25);
		secondField.setBounds(250, 25, 125, 25);
		
		calc.setBounds(140, 150, 115, 25);
		
		//fill comboBoxes
		
		swap.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent event){
				secondData.set
			}
		});
		
	}
	
	
}
