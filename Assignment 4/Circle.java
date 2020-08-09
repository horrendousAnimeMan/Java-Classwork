import java.lang.*;
import java.util.*;

/**
*Description: A Circle class as prescribed on p.190, no.9.
*Class: Fall - COSC 1437.81002
*Assignment 4: Circle Class
*Date: 06/12/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

/*
   *=======THIS STUFF FPLZ======
   *double radius
   *final double pi
   *
   *Constructor(radius)
   *
   *get/set Radius():
   *getArea/diameter/circumference():
*/
public class Circle
{
    private double radius;
    private final double PI=3.14159;
    private double[] stats=new double[3];//0area1diameter2circumference
    
    public Circle()
    {
        //Shoowoop!
        requestInput();
        setStats();
        displayStats();
    }
    public Circle(double radius)
    {
        this.radius=radius;
        setStats();
    }
    
    public void displayStats()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        String outString="";
        outString+="Stats: \n";
        outString+="Radius: "+Double.toString(this.radius)+"\n";
        outString+="Area: "+Double.toString(this.stats[0])+"\n";
        outString+="Diameter: "+Double.toString(this.stats[1])+"\n";
        outString+="Circumference: "+Double.toString(this.stats[2])+"\n";
        quickPrint(outString);
    }
    
    public void setRadius(double input)
    {
        /**
        * @param input double radius
        * @return none
        * @throws none
        */
        this.radius=input;
        setStats(); //important!
    }
    
    public double getRadius()
    {
        /**
        * @param none
        * @return the current this.radius.
        * @throws none
        */
       return this.radius;
    }
    
    public double getArea()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
       return this.stats[0];
    }
    
    public double getDiameter()
    {
        /**
        * @param none
        * @return this.stats[diameter]
        * @throws none
        */
       return this.stats[1];
    }
    
    public double getCircumference()
    {
        /**
        * @param none
        * @return this.stats[circumference]
        * @throws none
        */
       return this.stats[2];
    }
    
    public void setStats()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        this.stats[0]=(Math.pow(this.radius,2))*PI;
        this.stats[1]=this.radius*2;
        this.stats[2]=2*PI*this.radius;
    }
    
    public void requestInput()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        quickPrint("Requesting input.");
        Scanner inTheyGo=new Scanner(System.in);
        quickPrint("Enter radius: ");
        this.radius=inTheyGo.nextDouble();
        quickPrint("Input received: "+Double.toString(this.radius));
    }
    
    public void quickPrint(String s)
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        System.out.println(s);
    }
}
/*
 * Assignment: Make an external program that creates a new Circle from user input,
 * then displaying the circle's stats.
*/