import java.util.Scanner;
import java.text.NumberFormat;

public class TestScoreApp
{
    public static void main(String[] args)
    {
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        double averageScore = 0;

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            //System.out.print("Enter score: ");
            
            testScore = TestScoreApp.getIntWithinRange(sc, "Enter score: ", 1, 100);

            scoreCount += 1;
            scoreTotal += testScore;

            averageScore = (double) scoreTotal / (double) scoreCount;

            // see if the user wants to enter more test scores
            System.out.print("Enter another test score? (y/n): ");
            choice = sc.nextLine();
        }

        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMaximumFractionDigits(1);
        String message = "\n" +
                         "Score count:   " + scoreCount + "\n"
                       + "Score total:   " + scoreTotal + "\n"
                       + "Average score: " + number.format(averageScore) + "\n";
        System.out.println(message);
    }
    
    
     public static int getIntWithinRange(Scanner sc, String prompt,
    int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = TestScoreApp.getInt(sc, prompt);
            if (i <= min)
                System.out.println(
                    "Error! Number must be greater than " + min + ".");
            else if (i >= max)
                System.out.println(
                    "Error! Number must be less than " + max + ".");
            else
                isValid = true;
        }
        return i;
    }
 
    public static int getInt(Scanner sc, String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
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
}