package ua.nagib.data;

import java.io.IOException;

public class Euro extends Currency {

	public Euro() throws IOException {
		rate = readRate(toString());
	}
	
	public String toString() {
		return "Euro";
	}

}