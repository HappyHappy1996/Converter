package ua.nagib.data;

import java.io.IOException;

public class Grzywna extends Currency {

	public Grzywna() throws IOException {
		rate = readRate(toString());
	}
	
	public String toString() {
		return "Grzywna";
	}
	
}