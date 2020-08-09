import java.lang.*;
import java.util.*;

/**
*Description: A Temperature class as prescribed on p.188, no.4.
*Class: Fall - COSC 1437.81002
*Assignment 4: Temperature Class
*Date: 06/12/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

/*
   *=====THIS STUFF PLZ=======
   *double ftemp:given value
   *
   *Temperature():get input
   *
   *get/set ftemp():
   *get ctemp():centigrade: (5/9)*(ftemp-32)
   *get ktemp():kelvin: ((5/9)*(ftemp-32))+273
*/
public class Temperature
{
    public double[] temps=new double[3];//0F1C2K  ...hehe.
    
    public Temperature()
    {
        this.temps[0]=00.00;
        requestInput();
        convertF();
        displayTemperatures();
    }
    public Temperature(double ftemp)
    {
        this.temps[0]=ftemp;
        quickPrint(Double.toString(ftemp));
        convertF();
        displayTemperatures();
    }
    
    public double getTempAt(int index)
    {
        /**
        * @param index to access
        * @return the String at this.stats[index]
        * @throws none
        */
        double res=00.00;
        int lea=this.temps.length;
        if(index<=lea)
        {
            res=this.temps[index];
        }else if(index>lea)
        {
            quickPrint("Index out of range during getTempAt()");
        }
        return res;
    }
    
    public void displayTemperatures()
    {
        /**
        * @param none
        * @return the temperatures in this.temps[].
        * @throws none
        */
        String outputString="";
        String fString=Double.toString(this.temps[0]);
        String cString=Double.toString(this.temps[1]);
        String kString=Double.toString(this.temps[2]);
        outputString+="Temperatures: \n";
        outputString+="Fahrenheit: "+fString+"\n";
        outputString+="Centigrade: "+cString+"\n";
        outputString+="Kelvin: "+kString+"\n";
        quickPrint(outputString);
    }
    
    public void convertF()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        //quickPrint("degF before converstion:"+Double.toString(this.temps[0]));
        this.temps[1]=(this.temps[0]-32.0)*(5.0/9.0);
        this.temps[2]=(this.temps[0]-32.0)*(5.0/9.0)+273.15;
        //quickPrint("result of operation c: "+Double.toString(testc));
        //quickPrint("result of operation k: "+Double.toString(testk));
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

    public void requestInput()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        quickPrint("Requesting input.");
        Scanner inTheyGo=new Scanner(System.in);
        quickPrint("Enter temperature in fahrenheit: ");
        this.temps[0]=inTheyGo.nextDouble();
        String debugString=Double.toString(this.temps[0]);
        quickPrint("Input received."+debugString);
    }
}

/*
 * Assignment: Create external program that creates new Temperature from user input
 * then it will display the temperatures.
*/