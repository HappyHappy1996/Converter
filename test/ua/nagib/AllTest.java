package ua.nagib;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class AllTest {

	@Test
	public void testMain() {
		try {
			Launcher.main(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
