package DBAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
   private static String driverClass = "org.hsqldb.jdbcDriver";
   private static String url = "jdbc:hsqldb:hsql://localhost/bookdb";
   private static String username = "sa";
   private static String password = "";

   static {
      try {
         Class.forName(driverClass);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }   }

   public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(url, username, password);
   }
}
