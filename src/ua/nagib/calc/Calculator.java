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
			break;
		case "Grzywna":
			fromCurrency = getGrzywna();
			break;
		case "Euro":
			fromCurrency = getEuro();
			break;
		}
		
		switch (to) {
		case "Dollar":
			toCurrency = getDollar();
			break;
		case "Grzywna":
			toCurrency = getGrzywna();
			break;
		case "Euro":
			toCurrency = getEuro();
			break;
		}
		
		try {
			value = Double.parseDouble(frame.getFirstField().getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid data!");
			return 0;
		}
		double result = fromCurrency.getPrice() * value / toCurrency.getPrice();
		return result;
	}
}