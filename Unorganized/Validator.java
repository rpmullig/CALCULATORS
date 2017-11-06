import java.util.Scanner;
import java.lang.Math;

class Validator {
  
  private int max = 10; 
  private int min = 0; 
  
  public static double getIntWithinRange(Scanner sc){
    
    int choice = getInt(sc); 
    
    while(!(choice >= 1 && choice <= 100)){
    
      System.out.println("Error! Invalid integer value. Try again.");      
      System.out.print("Enter Number: ");
      choice = getInt(sc); 
    }
    return choice; 
  }
   public static int getInt(Scanner sc)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }
   
   
   public static String answer(int ans, int guess, int attempts){
     String message = ""; 

     if(ans > guess) {
       if(Math.abs(guess - ans) >= 10) {message =  "\nWay too high! Guess again.\n";}
       else{message =  "\nToo high! Guess again.\n";}
     }
     
     if(ans < guess) {
       if(Math.abs(guess - ans) >= 10) {message =  "\nWay too Low! Guess again.\n";}    
       else{ message = "\nToo Low! Guess again.\n";}
     }
     

     if(ans == guess) {
       message = "you got it in " + attempts + " tries."; 
       if(attempts <= 3) {message += "\nGreat work! You are a mathematical wizard.\n";}
       else if(attempts > 3 && attempts <= 7) {message += "\nNot too bad! You've got some potential.\n";}
       else if(attempts > 7) {message += "\nWhat took you so long? Maybe you should take some lessons.\n";}

     }

     return message;   
   }
}