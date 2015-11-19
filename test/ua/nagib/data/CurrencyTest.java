package ua.nagib.data;

import java.io.IOException;

import org.junit.Test;

public class CurrencyTest {

	@Test(expected = IOException.class)
	public void test() throws Exception {
		new Euro();
		new Grzywna();
		new Dollar().readRate("WRONG");
	}

}
