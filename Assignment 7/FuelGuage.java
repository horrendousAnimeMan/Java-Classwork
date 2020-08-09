/**
*Description: Fuel Guage class for Assignment 7, p.446, #12:Car-Instrument Simulator.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 7, Chapter 6
*Date: 06/21/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/
public class FuelGuage
{
    private int currentFuelLevel;
    private int mpg;
    public final int TANK_MIN=0;
    public final int TANK_MAX=15;
    
    /**
        * @param none
        * @return none
        * @throws none
        * Initializes a new FuelGuage.
    */
    public FuelGuage()
    {
        this.currentFuelLevel=0;
        this.mpg=24;
    }
    
    /**
        * @param none
        * @return this.currentFuelLevel
        * @throws none
        * Returns the current fuel level.
    */
    public int getFuelLevel()
    {
        return this.currentFuelLevel;
    }
    
    /**
        * @param none
        * @return this.mpg
        * @throws none
        * Returns the MPG of the FuelGuage.
    */
    public int getMPG()
    {
        return this.mpg;
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Adds fuel to the tank as long as it's not above the maximum.
    */
    public void addFuel()
    {
        this.currentFuelLevel+=1;
        if(this.currentFuelLevel<=this.TANK_MIN)
        {
            System.out.println("Overflow.");
            this.currentFuelLevel=this.TANK_MIN;
        }        
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Decreases fuel to the tank as long as it's not below the minimum.
    */
    public void decFuel()
    {
        this.currentFuelLevel-=1;
        if(this.currentFuelLevel<=this.TANK_MIN)
        {
            System.out.println("Out of gas.");
            this.currentFuelLevel=this.TANK_MIN;
        }
    }
}
