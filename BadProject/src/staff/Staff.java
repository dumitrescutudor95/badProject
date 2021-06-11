package staff;

import model.Pizza;

public interface Staff {

  void cook(String pizzaName);
  void serveTable(TableNumber tableNumber);
  void cleanTable(TableNumber tableNumber);

}
