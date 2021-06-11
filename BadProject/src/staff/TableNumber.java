package staff;

public enum TableNumber {

  TABLE1(false),
  TABLE2(false),
  TABLE3(false),
  TABLE4(false),
  TABLE5(false),
  TABLE6(false);

  boolean reserved;

  TableNumber(boolean reserved) {
    this.reserved = reserved;
  }

  public void setReserved(boolean reserved) {
    this.reserved = reserved;
  }

  public boolean isReserved() {
    return reserved;
  }

  public static void printAvailableTables() {
    for (TableNumber tableNumber : TableNumber.values()) {
      if (!tableNumber.isReserved()) {
        System.out.print(tableNumber.name() + " ");
      }
    }
    System.out.println();
  }
}
