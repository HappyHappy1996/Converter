package ua.nagib.data;

import java.io.FileNotFoundException;

import org.junit.Test;

public class CurrencyTest {

	@Test(expected = FileNotFoundException.class)
	public void test() throws Exception {
		new Euro();
		new Grzywna();
		new Dollar().readRate("WRONG");
	}

}
