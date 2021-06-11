import java.util.ArrayList;

public class Check {

  int totalProducts = 0;
  private ArrayList<String> soldProducts = new ArrayList<>();
  private ArrayList<Double> prices = new ArrayList<>();

  public ArrayList<String> getSoldProducts() {
    return soldProducts;
  }

  public void addProduct(String product, double price) {
    soldProducts.add(product);
    prices.add(price);
    totalProducts++;
  }

  public void printCheck() {
    for (int i = 0; i < totalProducts; i++) {
      System.out.println(soldProducts.get(i) + " .... " + prices.get(i) + "LEI");
    }
    double total = 0;
    for (double pret : prices) {
      total += pret;
    }
    System.out.println("Total .... " + total + " LEI.");
  }

}
