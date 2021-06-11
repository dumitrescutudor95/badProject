package staff;


public class Cook implements Staff {

  @Override
  public void cook(String pizzaName) {
    System.out.println(pizzaName+ " is being prepared.");
  }

  @Override
  public void serveTable(TableNumber tableNumber) {
    System.out.println("Error:The cook can't serve a table");
  }

  @Override
  public void cleanTable(TableNumber tableNumber) {
    System.out.println("Error:The cook can't clean a table");
  }

}
