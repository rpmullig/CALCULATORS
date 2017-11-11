import java.util.*;
import java.text.*;
import java.time.*;

public class AgeCalculatorApp
{
    public static void main(String[] args)
    {
        //Get the user's birthdate
        System.out.println("Welcome to the age calculator.");
        Scanner sc = new Scanner(System.in);
        int birthMonth = Validator.getInt(sc, "Enter the month you were born (1 to 12): ",
            0, 13);
        int birthDay = Validator.getInt(sc, "Enter the day of the month you were born: ",
            0, 32);
        int birthYear = Validator.getInt(sc, "Enter the year you were born (four digits): ",
        1874, 2005);
        
        String dateTodayString, dateOfBirthString;
        String dateBirthDay;
        GregorianCalendar birthday_date;
        Date today, dateOfBirth;
        DateFormat dateFormatter;
        
    
        
        dateFormatter = DateFormat.getDateInstance(DateFormat.FULL);
                
        birthday_date = new GregorianCalendar(birthYear, (birthMonth-1), birthDay);
        
        birthday_date.set(Calendar.YEAR, birthYear);
        birthday_date.set(Calendar.MONTH, (birthMonth-1));
        birthday_date.set(Calendar.DAY_OF_MONTH, birthDay); 
        
        dateOfBirth = birthday_date.getTime();
        
        today = new Date();
        
        dateTodayString = dateFormatter.format(today);
        dateOfBirthString = dateFormatter.format(dateOfBirth); 
        
        System.out.println(); 
        System.out.println("---------------------------------------------------------------------------");
        
        System.out.println("\tYour birth date is " + dateOfBirth); 
        System.out.println("\tToday's date is " + dateTodayString); 
     
        
        
        long startDateMS = today.getTime();
        long endDateMS = dateOfBirth.getTime();
        long elapsedMS = startDateMS - endDateMS;
        long elapsedDays = elapsedMS / (24 * 60 * 60 * 1000);
        
        
        System.out.println("\tYou are " + (elapsedDays/365) + " Years and " + (int)(elapsedDays%365.241) + " days old");
        
        
        System.out.println("---------------------------------------------------------------------------");
    }
}
