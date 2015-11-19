package ua.nagib.cryptographic;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class CryptographerTest {
	
	private final String algorithm = "MD5";
	private final String string = "qwer";

	@Test
	public void testHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		new Cryptographer();
		Cryptographer.hash(string, algorithm);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHashIllegalArg() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Cryptographer.hash(null, algorithm);
	}

}
