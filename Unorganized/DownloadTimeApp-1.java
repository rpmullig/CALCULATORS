import java.util.Scanner;

public class DownloadTimeApp {
  
  public static void main( String[] args){ 
  
    // welcome method
    System.out.print("Welcome to the Download Time Estimator\n");
    
    // initialize a scanner
    Scanner input = new Scanner(System.in);
    
    // the inputs, for while loop usage, start with "y"
    String continuation = "y"; 
    int file_size;
    int download_speed; 
    
    // floating point to input from a scanner
    float hours, minutes, seconds; 
      
    // anything other than y, ignoring case, stop
    while("y".equalsIgnoreCase(continuation)){
      
      // input file_size 
      System.out.print("\nEnter file size (MB): ");
      file_size = input.nextInt(); 
      
      // input download_speed
      System.out.print("\nEnter download speed (MB/sec): ");
      download_speed = input.nextInt();
      
      // calculate the variables
      seconds = (int) file_size / download_speed;
      hours = (int) seconds / (60*60);
      minutes = (int) (seconds / 60) % 60; // limits to 60 minutes
      seconds = (int) seconds % 60;
      
      // output the calculations
      System.out.printf("\n\n This download will take appoximately %.0f hours %.0f minutes %.0f seconds",
                       hours,
                       minutes,
                       seconds);
      
      // take inpute to continue the loop
      System.out.print("\n\nContinue? (y/n): ");
      continuation = input.next();
                          
    }
  }
}