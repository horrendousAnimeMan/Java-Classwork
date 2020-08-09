/**
*Description: Driver/demo class for Assignment 7, p.446, #12:Car-Instrument Simulator.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 7, Chapter 6
*Date: 06/21/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/
public class Demonstration
{
    /**
        * @param String[] args
        * @return none
        * @throws none
        * Creates new FuelGuage and Odometer, fills the tank, then drives until the tank is depleted.
        * Keeps track of mileage and fuel level.
    */
    public static void main(String[] args)
    {
        FuelGuage f=new FuelGuage();
        Odometer lenny=new Odometer(f);
        
        System.out.println("Filling tank.");
        while(lenny.getFuelGuage().getFuelLevel()<lenny.getFuelGuage().TANK_MAX)
        {
            lenny.getFuelGuage().addFuel();
            System.out.println("F: "+lenny.getFuelGuage().getFuelLevel());
        }
        
        System.out.println("Let's ride.");
        while(lenny.getFuelGuage().getFuelLevel()>lenny.getFuelGuage().TANK_MIN)
        {
            lenny.addMileage();
            System.out.println("M: "+lenny.getCurrentMileage()+" F:"+lenny.getFuelGuage().getFuelLevel());
        }
        
        System.out.println("All right, ride's over.  Where are we, anyway?");
    }
}