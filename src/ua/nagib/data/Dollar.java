package ua.nagib.data;

import java.io.IOException;

public class Dollar extends Currency {

	public Dollar() throws IOException {
		rate = readRate(toString());
	}
	
	public String toString() {
		return "Dollar";
	}
	
}