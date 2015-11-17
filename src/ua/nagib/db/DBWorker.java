package ua.nagib.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {

	private static DBWorker instance;

	private static final String URL = "jdbc:derby:ratedb;create=true";
	private static final String USER = "root";
	private static final String PASSWORD = "rootdb";
	private static final String TABLE_NAME = "CURRENCIES";

	private Connection connection = null;
	private Statement statement = null;

	private DBWorker() throws SQLException, ReflectiveOperationException {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			shutdown();
			System.err.println("Couldn't get connection");
		} catch (ReflectiveOperationException e) {
			System.err.println("Couldn't register driver");
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static synchronized DBWorker getInstance() throws SQLException,
			ReflectiveOperationException {
		if (instance == null) {
			instance = new DBWorker();
		}
		return instance;
	}

	private void createTable() throws SQLException {
		statement = connection.createStatement();
        statement.execute("create table " + TABLE_NAME + "(name varchar(20), rate double)");
        System.out.println("db is created, all is ok");
        statement.close();
    }
	
	private void dropTable() throws SQLException {
		statement = connection.createStatement();
        statement.execute("drop table " + TABLE_NAME);
        System.out.println("db is dropped, all is ok");
        statement.close();
    }
        
    public double selectCurrencyRate(String currencyName) throws SQLException {
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select rate from " + TABLE_NAME + " where name = '" + currencyName + "'");
			double rate = 0;
			 if (resultSet.next()) {
				rate = resultSet.getDouble("rate");
			 }
			
			resultSet.close();
			statement.close();
			return rate;
		} catch (SQLException e) {
			throw e;
		}
	}
    
    public void updateCurrency(String name, double rate) throws SQLException {
    	statement = connection.createStatement();
    	statement.execute("update " + TABLE_NAME + " set rate = " + rate + " where name = '" + name +"'");
    	statement.close();
    }
    
    public void insertCurrency(String name, double rate) throws SQLException {
    	statement = connection.createStatement();
    	statement.execute("insert into " + TABLE_NAME + " values ('" + name + "', " + rate +")");
    	statement.close();
    }
   
	private void shutdown() throws SQLException {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				DriverManager.getConnection(URL + ";shutdown=true", USER,
						PASSWORD);
				connection.close();
			}
		} catch (SQLException e) {
			System.err.println("Couldn't shutdown connection");
			throw e;
		}

	}

	public static void main(String[] args) throws Exception {
		DBWorker dbWorker = DBWorker.getInstance();
		
		System.out.println("1");
		
//		dbWorker.createTable();
		
		System.out.println("2");
//		dbWorker.insertCurrency("Grzywna", 0.0434);
//		dbWorker.insertCurrency("Dollar", 1.0);
//		dbWorker.insertCurrency("Euro", 1.1);
		System.out.println("3");
		System.out.println(dbWorker.selectCurrencyRate("Euro"));
		System.out.println(dbWorker.selectCurrencyRate("Dollar"));
		System.out.println(dbWorker.selectCurrencyRate("Grzywna"));
		System.out.println("4");
		
		
//		dbWorker.dropTable();
		
	}
	
}