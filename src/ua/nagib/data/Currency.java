package ua.nagib.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import ua.nagib.db.DBWorker;

public abstract class Currency {

	protected double rate;

	private static final String FILE_NAME = "rateOfExchange.txt";

	public Currency() throws SQLException, ReflectiveOperationException {
		rate = selectRate(toString());
	}

	public double getPrice() {
		return rate;
	}

	protected double readRate(String currencyName) throws IOException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(FILE_NAME), "UTF-8");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "file not found!");
			throw e;
		}
		StringBuilder sb = new StringBuilder();
		while (scanner.hasNextLine()) {
			sb.append(scanner.nextLine());
			int index = sb.indexOf(currencyName);
			if (index != -1) {
				scanner.close();
				return Double.parseDouble(sb.substring(index + currencyName.length() + 1));
			}
			sb.delete(0, sb.length());
		}
		scanner.close();
		throw new IOException("There are no rate for " + toString() + "in file");
	}

	protected double selectRate(String currencyName) throws SQLException, ReflectiveOperationException {
		DBWorker dbWorker = DBWorker.getInstance();
		return dbWorker.selectCurrencyRate(currencyName);
	}
	
}