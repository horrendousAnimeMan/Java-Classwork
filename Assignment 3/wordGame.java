import java.lang.*;
import java.util.*;

/**
*Description: Mad-libs!  User input becomes unique values in a string.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 3, Chapter 2
*Date: 06/07/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/ 
public class wordGame
{
    // instance variables - replace the example below with your own
    private String res;
    private String res1;
    private String res2;
    private String[] args=new String[7];

    /**
     * Constructor for objects of class wordGame
     */
    public wordGame()
    {
        /*
         * args[]=[0name,1city,2age,3college,4profession,5animal,6animalName]
         * name will occur multiple times.
        */
        // initialise instance variables
        this.res="";
        //System.out.println("Initializing... Requesting input.");
        requestInput();
        //System.out.println("Input received.  Building string Old Way: ");
        this.res1=buildStringOldWay();
        //System.out.println("Building string new way.");
        this.res2=buildStringNewWay();
        //Out they go!
        outputStrings();
        
    }
    
    public void outputStrings()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        System.out.println("Direct Array Version: \n"+res1+"\n Formatter Reference Method: \n"+res2);
    }
    
    public void requestInput()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        //request input for:
        //args[]=[0name,1city,2age,3college,4profession,5animal,6animalName]
        Scanner inTheyGo = new Scanner(System.in);
        int lea=this.args.length;
        int n=0;
        System.out.println("Requesting input.");
        while(n<lea)
        {
            if(n==0){System.out.println("Enter name.");}
            if(n==1){System.out.println("Enter city.");}
            if(n==2){System.out.println("Enter age.");}
            if(n==3){System.out.println("Enter college.");}
            if(n==4){System.out.println("Enter profession");}
            if(n==5){System.out.println("Enter animal.");}
            if(n==6){System.out.println("Enter animal name.");}
            this.args[n]=inTheyGo.nextLine();
            n+=1;
        }
    }
    
    public String buildStringOldWay()
    {
        /**
        * @param none
        * @return String:Completed string from user input.
        * @throws none
        */
        //don't forget to reset the string!
        this.res="";
        //format string directly from this.args.
        this.res+="There once was a person called " + this.args[0];
        this.res+=" who lived in " + this.args[1];
        this.res+=". \n  At the age of " + this.args[2];
        this.res+=", " + this.args[0] + " went to college at ";
        this.res+=this.args[3] + ".  \n"+this.args[0]+" graduated and went to work as a \n"+this.args[4];
        this.res+=".  Then, "+this.args[0]+" adopted a(n) "+this.args[5]+" named "+this.args[6];
        this.res+=".  They both lived happily ever after! \n \n";
        //System.out.println("Direct Array Access: \n"+this.res);
        return this.res;
    }
    
    public String buildStringNewWay()
    {
        /**
        * @param none
        * @return String:Completed string from user input.
        * @throws none
        */
        //don't forget to reset the string!
        this.res="";
        //build string with formatting markers.
        this.res+="There once was a person called %1$s \n";
        this.res+=" who lived in %2$s.  At the age of %3$s, %1$s went to college \n";
        this.res+="at %4$s.  %1$s graduated and went to work as a %5$s.  Then, %1$s \n";
        this.res+="adopted a(n) %6$s named %7$s.  They both lived happily ever after! \n";
        //format string here
        String newRes=String.format(this.res,args[0],args[1],args[2],args[3],args[4],args[5],args[6]);
        this.res=newRes;
        //System.out.println("String.format: \n"+this.res);
        return this.res;
    }
}
