import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Diavola;
import model.FreeSample;
import model.Pizza;
import model.QuattroFromaggi;
import model.QuattroStagioni;

public class POS {

  private static Check check;

  public static void generateCheck() {
    check = new Check();
    System.out.println("The check was generated.");
  }

  public static void addProduct(Pizza pizza) {
    if (pizza instanceof Diavola) {
      if (isProductAvailable(pizza.getName())) {
        check.addProduct(pizza.getName(), 20);
      }
    } else if (pizza instanceof QuattroStagioni) {
      if (isProductAvailable(pizza.getName())) {
        check.addProduct(pizza.getName(), 22);
      }
    } else if (pizza instanceof QuattroFromaggi) {
      if (isProductAvailable(pizza.getName())) {
        check.addProduct(pizza.getName(), 19);
      }
    } else if (pizza instanceof FreeSample) {
      if (isProductAvailable(pizza.getName())) {
        removeProductFromDatabase(pizza.getName());
        System.out.println("Free samples should not be included in the check.");
      }
    }
  }

  public static boolean isProductAvailable(String product) {
    try {
      Connection connection = DriverManager
          .getConnection("http://dummyUrl:dummyPort/dummyDatabaseName");
      Statement statement = connection
          .createStatement();
      ResultSet result = statement
          .executeQuery("SELECT quantity FROM pizzas WHERE product = '" + product + "'");
      return result.getInt("quantity") > 0;
    } catch (SQLException e) {
      return true;       //For testing purposes, there will be no error.the product will be in stock
    }
  }

  public static void printCheck() {

      check.printCheck();
      for (String produs : check.getSoldProducts()) {
        removeProductFromDatabase(produs);
      }
    cancelCheck();
  }

  private static void removeProductFromDatabase(String product) {
    try {
      Connection connection = DriverManager
          .getConnection("http://dummyUrl:dummyPort/dummyDatabaseName");
      Statement countStatement = connection.createStatement();
      ResultSet rs = countStatement
          .executeQuery("SELECT quantity FROM pizzas WHERE product = '" + product + "'");
      rs.next();
      int remainingQuantity = rs.getInt("quantity") - 1;

      Statement updateStatement = connection
          .createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
      updateStatement.executeUpdate(
          "ALTER TABLE pizzas SET quantity='" + remainingQuantity + "' WHERE product=" + product);
    }catch(SQLException e){
      //For testing purposes, there will be no error.the product will be removed
    }
  }

  public static void cancelCheck() {
    check = new Check();
    System.out.println("The check was canceled.");
  }

  public static Check getCheck() {
    return check;
  }
}
