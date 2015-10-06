package ua.nagib;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LauncherTest {

	@Test
	public void test() throws IOException {
		new Launcher();
		Launcher.main(null);
	}

}
