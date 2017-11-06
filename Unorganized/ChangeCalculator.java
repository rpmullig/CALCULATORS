import java.util.Scanner;
  
  public class ChangeCalculator {

  public static void main(String[] args){

    System.out.print("\nWelcome to the Change Calculator\n\n");
        
    int quarters = 0, nickels = 0, dimes = 0, pennies = 0, cents = 0; 
     
    Scanner input = new Scanner(System.in);
    String continuation = "y";
    
// anything other than y, ignoring case, stop
    while("y".equalsIgnoreCase(continuation)){
      
    System.out.print("\nEnter number of cents (0-99): ");   
    cents = input.nextInt();
    
    quarters = cents / 25; 
    cents %= 25;
    
    dimes = cents / 10; 
    cents %= 10;
    
    nickels = cents / 5; 
    cents %= 5; 
    
    pennies = cents;
      
    cents = 0; 
       
    
    System.out.printf("\nQuarters:  %d", quarters);
    System.out.printf("\nDimes:     %d", dimes);
    System.out.printf("\nNickels:   %d", nickels);
    System.out.printf("\nPennies:   %d", pennies);
    
    
    System.out.print("\n\nContinue? (y/n): ");
    continuation = input.next();
    }
      
  }
}