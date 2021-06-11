import java.util.Scanner;
import model.Diavola;
import model.FreeSample;
import model.QuattroFromaggi;
import model.QuattroStagioni;
import staff.Cook;
import staff.Waiter;
import staff.TableNumber;

public class Restaurant {

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws InterruptedException {

    Waiter waiter = new Waiter();

    TableNumber chooenTable = waiter.greetCustomer();
    startOrder();
    prepareFood();
    Thread.sleep(3000);
    waiter.serveTable(chooenTable);
    Thread.sleep(3000);
    POS.printCheck();
    waiter.cleanTable(chooenTable);


     /*

     Acesta este un program care implementeaza lifecycle ul unui restaurant.
     Cititi cu atentie programul si intelegeti cum functioneaza

     Clientul vine cu urmatoarea cerinta:
     Adaugati doua noi Pizze in meniu:  Regina (pret 20) si Mexicana(pret 22)

     Team leadul iti va asigneaza taskul de a modifica programul restaurantului pentru
     a supora noile tipuri de pizza,avand ca deadline o perioada de 2 ore.

     1) Creati un raport scris care descrie principiile incalcate in structura acestui program.
     2) Refactorizati programul, aplicand principiile S.O.L.I.D, dupa care adaugati cele doua noi tipuri de pizza.

       3 colegi,Alin Marius si Dan, sunt supraincarcati cu munca, prin urmare au apelat la voi pentru a-i ajuta cu un task.
     Alin are nevoie de a sorta un array folosind bubble sort.
     Marius are nevoie de a sorta un array folosind merge sort.
     Dan are nevoie de a sorta un array folosind selection sort.
     Creati un program Sorter, in care sa va folositi de Strategy Design Pattern pentru a putea sorta o lista primita ca parametru
     in cele 3 modalitati diferite, astfel incat cei 3 colegi sa aiba la dispozitie fiecare modalitatea lui dorita de sortare.
     Solutia trebuie livrata de asemenea, in 2 ore

      */
  }


  public static void startOrder() {
    boolean isCustomerReady = false;
    POS.generateCheck();
    while (!isCustomerReady) {
      System.out.println(
          "What can we get you? Choose: Quattro Stagioni, Quattro Fromaggi, Diavola and Free Sample. Type \"Stop\" if you're done");
      String produsAles = scanner.nextLine();
      switch (produsAles) {
        case "Quattro Stagioni":
          POS.addProduct(new QuattroStagioni());
          break;
        case "Quattro Fromaggi":
          POS.addProduct(new QuattroFromaggi());
          break;
        case "Diavola":
          POS.addProduct(new Diavola());
          break;
        //todo case "Regina":
        //todo   POS.adaugaProdus(new Regina());
        //todo   break;
        //todo case "Mexicana":
        //todo  POS.adaugaProdus(new Mexicana());
        //todo break;                               //Uncomment when implemented
        case "Free Sample":
          POS.addProduct(new FreeSample());
          break;
        case "Stop":
          isCustomerReady = true;
          break;
        default:
          System.out.println("We don't have this product");
      }
    }

  }

  public static void prepareFood() {
    Cook cook = new Cook();
    for (String pizza : POS.getCheck().getSoldProducts()) {
      cook.cook(pizza);
    }
  }


}
