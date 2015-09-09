package ua.nagib.calc;

import javax.swing.JOptionPane;

import ua.nagib.GUI.Frame;
import ua.nagib.data.Currency;
import ua.nagib.data.Dollar;
import ua.nagib.data.Euro;
import ua.nagib.data.Grzywna;

public class Calculator {

	private static Calculator instance;
	private Dollar dollar;
	private Grzywna grzywna;
	private Euro euro;

	public Dollar getDollar() {
		return dollar;
	}

	public Grzywna getGrzywna() {
		return grzywna;
	}

	public Euro getEuro() {
		return euro;
	}

	private Calculator() {
		dollar = new Dollar();
		grzywna = new Grzywna();
		euro = new Euro();
	}

	public static synchronized Calculator getInstance() {
		if (instance == null) {
			instance = new Calculator();
		}
		return instance;
	}

	public double convert(String from, String to, Frame frame) {

		double value = 0;
		Currency fromCurrency = null;
		Currency toCurrency = null;
		
		switch (from) {
		case "Dollar":
			fromCurrency = getDollar();
		case "Grzywna":
			fromCurrency = getGrzywna();
		case "Euro":
			fromCurrency = getEuro();
		}
		
		switch (to) {
		case "Dollar":
			toCurrency = getDollar();
		case "Grzywna":
			toCurrency = getGrzywna();
		case "Euro":
			toCurrency = getEuro();
		}
		
		try {
			value = Double.valueOf(frame.getFirstField().getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid data!");
			return 0;
		}
		double result = fromCurrency.getPrice() * value * toCurrency.getPrice();
		return result;
	}
}