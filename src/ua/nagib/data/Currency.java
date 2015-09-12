package ua.nagib.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class Currency {

	protected double rate;

	private static final String FILE_NAME = "rateOfExchange.txt";

	public double getPrice() {
		return rate;
	}

	protected double readRate(String currencyName) throws IOException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(FILE_NAME), "UTF-8");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File isn't exists!");
			throw e;
		}
		StringBuilder sb = new StringBuilder();
		while (scanner.hasNextLine()) {
			sb.append(scanner.nextLine());
			int index = sb.indexOf(currencyName);
			if (index != -1) {
				scanner.close();
				return Double.parseDouble(sb.substring(index
						+ currencyName.length() + 1));
			}
			sb.delete(0, sb.length());
		}
		scanner.close();
		throw new IOException("Invalid currency data in file!");
	}

}