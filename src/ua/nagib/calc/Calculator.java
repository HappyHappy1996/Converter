package ua.nagib.calc;

import java.sql.SQLException;

import ua.nagib.GUI.ConvertFrame;
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

	private Calculator() throws SQLException, ReflectiveOperationException {
		dollar = new Dollar();
		grzywna = new Grzywna();
		euro = new Euro();
	}

	public static synchronized Calculator getInstance() throws SQLException, ReflectiveOperationException {
		if (instance == null) {
			instance = new Calculator();
		}
		return instance;
	}

	public double convert(String from, String to, double value) {

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
		double result = fromCurrency.getPrice() * value / toCurrency.getPrice();
		return result;
	}
}