import java.util.*;
import java.lang.*;
/**
 * Write a description of class MonthDays here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MonthDays
{
    public int month;
    public int year;
    public boolean isLeapYear;
    public int[] daysInMonth;
    
    public MonthDays(int month,int year)
    {
        //
    }
    
    public void getNumberOfDays()
    {
        if(this.year%100==0)
        {
            if(this.year%400==0)
            {
                this.isLeapYear=true;
            }else
            {
                this.isLeapYear=false;
            }
        }else
        {
            if(this.year%4==0)
            {
                this.isLeapYear=true;
            }else
            {
                this.isLeapYear=false;
            }
            
        }
        this.createTables(this.isLeapYear);
    }
    
    public void createTables(boolean iLy)
    {
        if(iLy==true)
        {
            this.daysInMonth=new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        }else
        {
            this.daysInMonth=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        }
    }
}
