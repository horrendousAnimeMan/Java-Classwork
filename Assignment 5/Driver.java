import java.lang.*;
import java.util.*;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String[] args)
    {
        Scanner inputScan=new Scanner(System.in);
        int month=0;
        int year=0;
        
        System.out.println("Month:");
        month=inputScan.nextInt();
        System.out.println("Year:");
        year=inputScan.nextInt();
        
        MonthDays tim= new MonthDays(month,year);
        tim.getNumberOfDays();
        
        System.out.println(Integer.toString(tim.daysInMonth[month]));
    }
}
