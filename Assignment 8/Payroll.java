import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;

/**
*Description: Driver for Assignment 8, p.540, #2: Payroll Class.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 8, Chapter 7
*Date: 06/26/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

public class Payroll
{
    private ArrayList<Integer> employeeID; //funny syntax.  ArrayList<int> makes more sense.
    private ArrayList<Double> hours;
    private ArrayList<Double> payRate;
    private ArrayList<Double> ytd;
    public final double MIN_WAGE=6.00;
    
	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the Payroll object.
    */
    public Payroll()
    {
        //int[] comeOn={5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
        //ArrayList<Integer> seriously=Arrays.asList(comeOn);
        //this.employeeID=new ArrayList<Integer>(Arrays.asList(comeOn));
        //OKAY FINE, JAVA.
        
        //making sure the fields are initialized.
        this.employeeID=new ArrayList<Integer>();
        this.hours=new ArrayList<Double>();
        this.payRate=new ArrayList<Double>();
        this.ytd=new ArrayList<Double>();
        
        //allegedly you can pass a list to ArrayBuilder(list), but it didn't work for me.
        int[] comeOn={5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
        for(int i = 0; i<comeOn.length;i++)
        {
            //System.out.println("this one?");
            this.employeeID.add(comeOn[i]);
        }
        //
        for(int i = 0; i<this.employeeID.size();i++)
        {
            //System.out.println("how about this one?");
            this.hours.add(0.00);
        }

        for(int i = 0; i<this.employeeID.size();i++)
        {
            //System.out.println("and the next one?");
            this.payRate.add(0.00);
        }
        
        for(int i = 0; i<this.employeeID.size();i++)
        {
            //System.out.println("really, what one?");
            this.ytd.add(0.00);
        }
        
    }
    
	/**
        * @param int index
        * @return none
        * @throws none
        * Gets ID at index
    */
    public int getEID(int index)
    {
        return this.employeeID.get(index);
    }
    
	/**
        * @param int index
        * @return double
        * @throws none
        * Gets Hours at index
    */
    public double getHours(int index)
    {
        return this.hours.get(index);
    }
    
	/**
        * @param int index
        * @return double
        * @throws none
        * Gets Pay Rate at index
    */
    public double getPayRate(int index)
    {
        return this.payRate.get(index);
    }
    
	/**
        * @param int index
        * @return double
        * @throws none
        * Gets total wages at index
    */
    public double getYTD(int index)
    {
        return this.ytd.get(index);
    }
    
	/**
        * @param none
        * @return none
        * @throws none
        * Gets user input.
    */
    public void newInput()
    {
        Scanner scanny = new Scanner(System.in);
        int n=0;
        System.out.println("Enter payroll data."+"\n"+"HOURS:\n");
        
        while(n<this.employeeID.size())
        {
            System.out.println("Hours for EID: "+this.employeeID.get(n));
            this.hours.set(n,scanny.nextDouble());
            if(this.hours.get(n)<0)
            {
                System.out.println("Negative input received.  It's the rapture!  Run!");
                break;
            }
            n+=1;
        }
        
        n=0;
        System.out.println("PAY RATES:\n");
        
        while(n<this.employeeID.size())
        {
            System.out.println("Pay Rate for EID: "+this.employeeID.get(n));
            this.payRate.set(n,scanny.nextDouble());
            if(this.payRate.get(n)<this.MIN_WAGE)
            {
                System.out.println("You cannot exploit labor!  Labor precedes capital! \n I can't be a part of this.");
                break;
            }
            n+=1;
        }
        
        System.out.println("Input received.");
    }
    
	/**
        * @param none
        * @return none
        * @throws none
        * Outputs the data in the object.
    */
    public void newOutput()
    {
        int n=0;
        StringBuilder output=new StringBuilder();
        String spacing="      ";
        output.append("EID"+spacing+"HOURS"+spacing+"RATE"+spacing+"YTD"+"\n");
        
        while(n<this.employeeID.size())
        {
            output.append(this.employeeID.get(n));
            output.append(spacing);
            output.append(this.hours.get(n)+spacing);
            output.append(this.payRate.get(n)+spacing);
            output.append(this.ytd.get(n));
            output.append("\n");
            n+=1;
        }
        output.append("----------------");
        System.out.println(output);
    }
    
	/**
        * @param none
        * @return none
        * @throws none
        * Calculates total wages based on each emp's hours/rate.
    */
    public void calcWages()
    {
        System.out.println("Calculating YTD's.");
        int n=0;
        
        while(n<this.employeeID.size())
        {
            double ny=this.hours.get(n)*this.payRate.get(n);
            this.ytd.set(n,ny);
            n+=1;
        }
        
        System.out.println("Calculation complete.");
    }
    
	/**
        * @param int id
        * @return double
        * @throws none
        * Gets total  wages based on ID number.
    */
    public double getPayForID(int id)
    {
        int n=0;
        
        while(n<this.employeeID.size())
        {
            if(this.employeeID.get(n)==id)
            {
                return this.ytd.get(n);
            }else{n+=1;}
        }
        
        System.out.println("ID not found.");
        return 0.00;
    }
}
