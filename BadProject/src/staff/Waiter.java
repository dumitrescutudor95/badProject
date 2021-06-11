package staff;

import java.util.Scanner;

public class Waiter implements Staff {

  @Override
  public void cook(String pizzaName) {
    System.out.println("Error:The waiter can't cook");
  }

  @Override
  public void serveTable(TableNumber tableNumber) {
    tableNumber.setReserved(true);
    System.out.println("The table " + tableNumber.name() + " is being served\n");
  }

  @Override
  public void cleanTable(TableNumber tableNumber) {
    tableNumber.setReserved(false);
    System.out.println("The table " + tableNumber.name() + " was cleaned\n");
  }

  public TableNumber greetCustomer() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome.");
    TableNumber.printAvailableTables();
    System.out.print("Please choose your table:");
    return TableNumber.valueOf(sc.nextLine());
  }
}
