import java.util.Scanner;

public class InvoiceApp
{
    public static void main(String[] args)
    {
        // welcomes the user to the program - "\n" special char to add line
        System.out.println("\n\nWelcome to the Invoice Total Calculator\n");

        // create a Scanner object named sc
        Scanner sc = new Scanner(System.in);
        
        //variables to keep track and return after while loop
        int invoiceCount = 0;
        double discount_total = 0.0, invoice_total = 0.0; 

        // perform invoice calculations until choice isn't equal to "N" or "n"
        String choice = "y";
        while (!(choice.equalsIgnoreCase("n"))){
          
            invoiceCount++;
            // adds to the invoiceCount
            
            // get the invoice subtotal from the user
            System.out.print("\nEnter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and total
            double discountPercent = 0.0; // initialize it as 0             
            if (subtotal >= 100 && subtotal < 200 ){ discountPercent = 0.1; }     
            else if (subtotal >= 200 && subtotal < 500) { discountPercent = 0.2; } 
            else if (subtotal >= 500) { discountPercent = 0.25; } 
            else { discountPercent = 0.0; } // not really needed line of code
            
            // caculate the values
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;
            
            // add the totals to computer averages after the while loop
            discount_total = discount_total + discountAmount;
            invoice_total = invoice_total + total; 
            
            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                    + "Discount amount:  " + discountAmount + "\n"
                    + "Invoice total:    " + total + "\n";
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
        }
        
        System.out.println("\n-------------------------");
        System.out.print("Number of invoices: " + invoiceCount);
        
        System.out.printf("\nAverage invoice: %.2f", invoice_total/invoiceCount);
        
        System.out.printf("\nAverage discount: %.2f", discount_total/invoiceCount);
        System.out.println("\n-------------------------");
    }
}