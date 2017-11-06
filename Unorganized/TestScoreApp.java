import java.util.Scanner;

public class TestScoreApp
{
    public static void main(String[] args)  
    {
        // display operational messages
        System.out.print("\nPlease enter test scores that range from 0 to 100.");
        System.out.print("\nTo end the program enter 999.\n");        
        
        String more_tests;
          
        do{
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nEnter the number of test scores to be enered: ");
        int scoreCount =  sc.nextInt();
          
        // initialize variables and create a Scanner object
        int scoreTotal = 0;
        int testScore = 0;
         
        int min = 100, max = 0; 
        
        // get a series of test scores from the user
        for(int i = 0; i < scoreCount; i++){
            // get the input from the user
            System.out.print("Enter score: ");
            testScore = sc.nextInt();
            

            // accumulate score count and score total
            if (testScore <= 100)
            {

                scoreTotal = scoreTotal + testScore;
                if(testScore < min){ min = testScore;}
                if(testScore > max) {max = testScore;}
            }
            else if (testScore != 999){
                System.out.println("Invalid entry, not counted");
                i--;
            }
        } 
        // display the score count, score total, and average score
        double averageScore = scoreTotal / scoreCount;
        String message = "\n" +
                         "Score count:   " + scoreCount + "\n"
                       + "Score total:   " + scoreTotal + "\n"
                       + "Average score: " + averageScore + "\n"
                       + "Minimum score: " + min + "\n"
                       + "Maximum score: " + max + "\n";
        System.out.println(message);
        
        System.out.println("\n\nEnter more test scores? (y/n): ");
        more_tests = sc.next();
        
      } while ("y".equalsIgnoreCase(more_tests));
    }
}