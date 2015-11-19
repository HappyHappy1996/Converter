package ua.nagib.calc;

import java.sql.SQLException;

import org.junit.Test;

public class CalculatorTest {
	
	private final String fromCurrency = "Dollar";
	private final String toCurrency = "Euro";

	@Test
	public void testConvert() throws SQLException, ReflectiveOperationException {
		Calculator.getInstance().convert(fromCurrency, toCurrency, 0);
	}

}
