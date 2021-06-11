package gai.data.springcourse.bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class DataDAO {

  private static final String URL = "jdbc:jtds:sybase://zhytomyr:5000/gai";
  private static final String USERNAME = "view_user";
  private static final String PASSWORD = "view_user";

  public static Connection connectionSa;

  static {
    try {
      Class.forName("net.sourceforge.jtds.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      connectionSa = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      System.out.println("connectionSa-Ok");

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      System.out.println("connectionSa-Error");
    }
  }
}
