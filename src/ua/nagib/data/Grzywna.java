package ua.nagib.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Grzywna extends Currency {

	public Grzywna() throws IOException {
		super();
	}

	public Grzywna(Connection connection) throws SQLException {
		super(connection);
	}

	public String toString() {
		return "Grzywna";
	}

}