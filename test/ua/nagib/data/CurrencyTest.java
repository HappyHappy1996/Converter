package ua.nagib.data;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import ua.nagib.db.DBWorker;

public class CurrencyTest {

	@Test(expected = Exception.class)
	public void test() throws Exception {
		Euro euro = new Euro();
		Grzywna dollrywnaar = new Grzywna();
		Dollar dollar = new Dollar();
		Dollar dollar2 = new Dollar(DBWorker.getInstance().getConnection());
	}

}
