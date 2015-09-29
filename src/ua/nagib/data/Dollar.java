package ua.nagib.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Dollar extends Currency {

	public Dollar() throws IOException {
		super();
	}

	public Dollar(Connection connection) throws SQLException {
		super(connection);
	}

	public String toString() {
		return "Dollar";
	}

}