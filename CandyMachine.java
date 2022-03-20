package LaraBSIS;

import java.util.InputMismatchException;
import java.util.Scanner; 


public class CandyMachine {
   public static void main(String[] args) {
      System.out.println("--- Welcome to Candy Machine --");
      
      //Creating dispenser objects:
      ProductDispenser Candy = new ProductDispenser(0.50, 12);
      ProductDispenser Chips = new ProductDispenser(0.65, 12);
      ProductDispenser Gum = new ProductDispenser(0.45, 12);
      ProductDispenser Cookies = new ProductDispenser(0.85, 12);
      
      //Creating cash register object:
      CashRegister CR = new CashRegister();
           
                //For selection of Item
      int select = 0;
      do {
          ,select = getIntInput("\n To select an item, enter \n" + "1 for Candy\n" 
         + "2 for Chips\n" + "3 for Gum\n" + "4 for Cookies\n" 
         + "9 to exit \n");
        switch (select) {
          case 1:
             purchase(Candy, CR);
             break;
          case 2:
             purchase(Chips, CR);
             break;
          case 3:
             purchase(Gum, CR);
             break;
          case 4:
             purchase(Cookies, CR);
             break;
          default:
              System.out.println("Invalid Selectin");
          }
      } while (select != 9);
 }
 
 //Method to execute a purchase:
 public static void purchase(ProductDispenser product, CashRegister cashreg) {
   Scanner input = new Scanner(System.in);
   if (product.getProdQty() > 0) {
       double pmt = 0;
       //Collection of coin to purchase product.
       do {
           System.out.print("Please deposit " + (product.getProdCost() * 100 - pmt) + " cents.");
           pmt =+ input.nextDouble();
       } while (pmt < product.getProdCost() * 100);
       product.setProdQty(1);
       cashreg.setCashOnHand(product.getProdCost());
       System.out.print("Collect your item at the bottom and enjoy.");
       
       
   }
  
 }
 }



 
