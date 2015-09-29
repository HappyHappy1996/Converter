package ua.nagib.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.fabric.jdbc.FabricMySQLDriver;


public class DBWorker {

 private final String URL = "jdbc:mysql://localhost:3306/ratedb";
 private final String USER = "root";
 private final String PASSWORD = "root";

 private static DBWorker instance;
 private Connection connection;

 private DBWorker() throws SQLException {
  try {
   System.out.println("1");
   Driver driver = new FabricMySQLDriver();
   System.out.println("2");
   DriverManager.registerDriver(driver);
   System.out.println("3");
   connection = DriverManager.getConnection(URL, USER, PASSWORD);
  } catch (SQLException e) {
   connection = null;
   System.err.println("Couldn't get connection");
  }
 }

 public Connection getConnection() {
  return connection;
 }

 public static synchronized DBWorker getInstance() throws SQLException {
  if (instance == null) {
   instance = new DBWorker();
  }
  return instance;
 }

}