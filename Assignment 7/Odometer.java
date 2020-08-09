/**
*Description: Odometer class for Assignment 7, p.446, #12:Car-Instrument Simulator.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 7, Chapter 6
*Date: 06/21/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/
public class Odometer
{
    private int currentMileage;
    private FuelGuage fuelGuage;
    public final int MAX_MILEAGE=999999;
    
    /**
        * @param FuelGuage f
        * @return none
        * @throws none
        * Initializes a new Odometer with a specified FuelGuage.
    */
    public Odometer(FuelGuage f)
    {
        this.fuelGuage=f;
        this.currentMileage=0;
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Initializes a new Odometer with a new FuelGuage.
    */
    public Odometer()
    {
        this.fuelGuage=new FuelGuage();
        this.currentMileage=0;
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Adds mileage to the odometer and makes the necessary deductions from the fuel supply based on MPG.
        * Also checks for a non-used occurrence where the mileage would exceed 999,999.
    */
    public void addMileage()
    {
        this.currentMileage+=1;
        if(this.currentMileage%this.fuelGuage.getMPG()==0)
        {
            this.fuelGuage.decFuel();
        }
        if(this.currentMileage>this.MAX_MILEAGE)
        {
            System.out.println("Maximum mileage reached.");
            this.currentMileage=0;
        }
    }
    
    /**
        * @param none
        * @return this.fuelGuage
        * @throws none
        * returns this Odometer's Fuel Guage.
    */
    public FuelGuage getFuelGuage()
    {
        return this.fuelGuage;
    }
    
    /**
        * @param none
        * @return this.currentMileage
        * @throws none
        * returns this Odometer's mileage.
    */
    public int getCurrentMileage()
    {
        return this.currentMileage;
    }
}
