import java.lang.*;
import java.util.*;

/**
*Description: A Car class as prescribed on p.188, no.2.
*Class: Fall - COSC 1437.81002
*Assignment 4: Car Class
*Date: 06/12/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

/*
   *=====THIS STUFF PLZ======
   *this.yearModel
   *this.make
   *this.speed
   *
   *Constructor: year/make as args
   *Accessor(s)
   *
   *accelerate():+5 speed
   *brake():-5 speed
   *
*/ 
public class Car
{
    private String[] stats=new String[2]; //0yearMake1Model
    private double speed;

    public Car()
    {
        this.speed=00.00;
        requestInput();
        quickPrint("Enjoy your new "+stats[0]+" "+stats[1]+"!");
    }
    
    public Car(String yearMake, String model)
    {
        this.speed=00.00;
        this.stats[0]=yearMake;
        this.stats[1]=model;
        quickPrint("Enjoy your new "+stats[0]+" "+stats[1]+"!");
    }
    
    public void quickPrint(String s)
    {
        
        System.out.println(s);
    }
    
    public double getSpeed()
    {
        /**
        * @param none
        * @return current speed of vehicle.
        * @throws none
        */
        return this.speed;
    }
    
    public String[] getStats()
    {
        /**
        * @param none
        * @return String[] this.stats
        * @throws none
        */
        return this.stats;
    }
    
    public String getStatsAt(int index)
    {
        /**
        * @param index to access
        * @return the String at this.stats[index]
        * @throws none
        */
        String res="";
        int lea=this.stats.length;
        if(index<=lea)
        {
            res=this.stats[index];
        }
        return res;
    }
    
    public void requestInput()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        System.out.println("Requesting input.");
        Scanner inTheyGo=new Scanner(System.in);
        int lea = this.stats.length;
        int n = 0;
        
        while(n<lea)
        {
            if(n==0){System.out.println("Enter Year of Vehicle:");}
            if(n==1){System.out.println("Enter Make of Vehicle:");}
            this.stats[n]=inTheyGo.nextLine();
            n+=1;
        }
        
        System.out.println("Input received.");
        
    }
    
    public void accelerate()
    {/**
        * @param none
        * @return none
        * @throws none
        */
        this.speed+=5.0;
        quickPrint("MPH:"+Double.toString(this.speed));
    }
    
    public void brake()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        if(this.speed>0)
        {
            this.speed-=5.0;
        }
        quickPrint("MPH:"+Double.toString(this.speed));
    }
}
/*
 * Assignment: External program, creates Car from user input,
 * calls accelerate() 5 times, displaying speed each time.
 * calls brake() 5 times, displaying speed each time.
 * displays the current stats.
*/