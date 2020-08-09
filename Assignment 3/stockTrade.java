import java.lang.*;
import java.util.*;

/**
*Description: Determine profit from a transaction using user input.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 3, Chapter 2
*Date: 06/07/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/ 
public class stockTrade
{
    // instance variables - replace the example below with your own
    private double[] buyData={00.00,00.00,00.00};
    private double[] sellData={00.00,00.00,00.00};
    private double[] transactionData={00.00};

    /**
     * Constructor for objects of class stockTrade
     */
    public stockTrade()
    {
        // initialise instance variables, if needed.
        //request user input.
        requestInput();
        //compute data.
        computeTransactionData();
        //output data.
        outputData();
        
    }
    
    public void outputData()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        String[] buyStrings=new String[3];
        String[] sellStrings=new String[3];
        String profitString=Double.toString(this.transactionData[0]);
        int lea=buyStrings.length;
        int n=0;
        
        while(n<lea)
        {
            buyStrings[n]=Double.toString(this.buyData[n]);
            n+=1;
        }
        
        n=0;
        while(n<lea)
        {
            sellStrings[n]=Double.toString(this.sellData[n]);
            n+=1;
        }
        String outputString="\n\n";
        outputString+="Shares Purchased: %1$s \n"+"Price at time of Purchase: %2$s \n"+"Brokerage rate: %3$s \n \n";
        outputString+="Shares Sold: %4$s \n"+"Price at time of Sale: %5$s \n"+"Brokerage rate: %6$s \n\n";
        outputString+="Profit: %7$s";
        String newOutput=String.format(outputString,buyStrings[0],buyStrings[1],buyStrings[2],sellStrings[0],sellStrings[1],sellStrings[2],profitString);
        outputString=newOutput;
        System.out.println(outputString);
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
        int lea=this.buyData.length;
        int n=0;
        System.out.println("Requesting input: buyData: ");
        while(n<lea)
        {
            if(n==0){System.out.println("Enter shares purchased (##.##).");}
            if(n==1){System.out.println("Enter share price at time of purchase(##.##).");}
            if(n==2){System.out.println("Enter brokerage fee rate at time of purchase.(00.##)");}
            this.buyData[n]=inTheyGo.nextDouble();
            n+=1;
        }
        n=0;
        System.out.println("Requesting input: sellData: ");
        while(n<lea)
        {
            if(n==0){System.out.println("Enter shares sold (##.##).");}
            if(n==1){System.out.println("Enter share price at time of sale(##.##).");}
            if(n==2){System.out.println("Enter brokerage fee rate at time of sale.(00.##)");}
            this.sellData[n]=inTheyGo.nextDouble();
            n+=1;
        }
    }
    
    public void computeTransactionData()
    {
        /**
        * @param none
        * @return none
        * @throws none
        */
        double res=00.00;
        double sumBuyData=this.buyData[0]*this.buyData[1];
        //sumBuyData*=this.buyData[2];
        sumBuyData-=(sumBuyData*this.buyData[2]);
        double sumSellData=this.sellData[0]*this.sellData[1];
        //sumSellData*=this.sellData[2];
        sumSellData-=(sumSellData*this.sellData[2]);
        res=sumSellData-sumBuyData;
        this.transactionData[0]=res;
    }
}
