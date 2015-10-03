package ua.nagib.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Euro extends Currency {

 public Euro() throws IOException {
  super();
 }
 
 public Euro(Connection connection) throws SQLException {
  super(connection);
 }
 
 public String toString() {
  return "Euro";
 }

}