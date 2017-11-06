import java.util.Scanner;
import java.lang.Math; 

class project_B_Main {
  
  public static void main(String args[]) {
   
    System.out.print("Welcome to the Guess the Number Game");
      System.out.print("\n++++++++++++++++++++++++++++++++++++\n" ); 

    
    int attempts = 0; 
    int guess, ans; 
    
    Scanner sc = new Scanner(System.in);
    String choice = "y";
    while(choice.equalsIgnoreCase("y")){
      
      
      System.out.println("I'm thinking of a number from 1 to 100.");
      System.out.println("Try to guess it."); 

      guess = (int) (Math.random() * 100);
      //System.out.println(guess); 
      do {
        
        System.out.print("Enter Number: ");
        ans = (int) Validator.getIntWithinRange(sc);
        
        attempts ++; 
        String message = Validator.answer(ans, guess, attempts);
        System.out.println(message); 
      
      }while(ans != guess);  
            
            
      
       
      System.out.print("Continue? (y/n): ");
      choice = sc.next();
      attempts = 0;
      System.out.println();
    } 
    
    System.out.print("\nBye - Come back soon!\n"); 
  }
  
  
  
}