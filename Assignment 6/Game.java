import java.util.ArrayList;
import java.util.Scanner;

/**
*Description: Play Dice-Blackjack against the CPU as prescribed on
*             p.354, #24
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 6, Chapter 5
*Date: 06/15/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

public class Game
{
    public ArrayList<Die> playerRolls=new ArrayList<Die>();
    public ArrayList<Die> cpuRolls=new ArrayList<Die>();
    public int[] totals = new int[2];
    public boolean[] isStay= new boolean[2];
    public boolean[] isOver= new boolean[2];
    public boolean[] isWinner= new boolean[2];
    public static int blackjack=21;
    
    /**
        * @param none
        * @return none
        * @throws none
        * Sets up the game.
    */
    public Game()
    {
        //
        this.isWinner[0]=this.isWinner[1]=false;
        this.isStay[0]=this.isStay[1]=false;
        this.isOver[0]=this.isOver[1]=false;
        this.playerRolls.add(new Die());
        this.playerRolls.add(new Die());
        this.cpuRolls.add(new Die());
        this.cpuRolls.add(new Die());
        this.totals[0]=this.getTotal(0);
        this.totals[1]=this.getTotal(1);
        System.out.println("Welcome to the Thunderdome, Player.  CPU has been waiting for you.  \n Roll the dice, place your bets.  Here is a free drink.");
        
    }
    
    /**
        * @param int index, the 0 or 1 value referring to player or CPU.
        * @return int t.
        * @throws none
        * Returns the total of the dice in the player or CPU's hand.
    */
    public int getTotal(int index)
    {
        int t=0;
        if(index==0)
        {
            //
            for(Die u:this.playerRolls)
            {
                t+=u.side;
            }
        }else
        {
            //
            for(Die u:this.cpuRolls)
            {
                t+=u.side;
            }
        }
        return t;
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * CPU, then player decide whether to hit or stay.
    */
    public void hitOrStay()
    {
        //
        if(this.isStay[1]==true)
        {
            //
            System.out.println("CPU is staying.");
        }else
        {
            //
            System.out.println("CPU, how about you?  Hit or stay?");
            if(this.getTotal(1)<(21-7))//a risk-raking robot!  was previously 21-12.  Change to 21-this.cpuRolls.get(0).sides
            {
                //
                System.out.println("CPU hits.");
                this.cpuRolls.add(new Die());
                this.cpuRolls.add(new Die());
                this.totals[1]=this.getTotal(1);
                
                if(this.totals[1]>this.blackjack)
                {
                    //
                    System.out.println("CPU busts with "+this.totals[1]+".");
                    this.isOver[1]=true;
                }else
                {
                    //
                    System.out.println("The CPU looks around suspiciously.");
                }
            }else
            {
                //
                System.out.println("CPU stays.");
                this.isStay[1]=true;
            }
        }
        
        if(this.isStay[0]==true)
        {
            //
            System.out.println("Player is staying with "+this.getTotal(0));
        }else
        {
            //
            if(this.isOver[1]==true)
            {
                //Do nothing.  CPU has busted.
            }else
            {
                //
                Scanner inputScan=new Scanner(System.in);
                System.out.println("Player, you have "+this.getTotal(0)+" showing.  Hit or stay?");
                System.out.println("Enter h for hit, s for stay.");
                String res=inputScan.nextLine();
                //System.out.println(res);
                //System.out.println((Boolean.toString(res=="h")));
                
                if(res.charAt(0)=='h')
                {
                    System.out.println("Player hits.");
                    this.playerRolls.add(new Die());
                    this.playerRolls.add(new Die());
                    //print thos beans
                    int r1=this.playerRolls.size()-1;
                    System.out.println("Roll 1: "+this.playerRolls.get(r1).side+".");
                    System.out.println("Roll 2: "+this.playerRolls.get(r1-1).side+".");
                    
                    this.totals[0]=this.getTotal(0);
                    
                    if(this.totals[0]>this.blackjack)
                    {
                        //
                        System.out.println("Player busts with "+this.totals[0]+".");
                        this.isOver[0]=true;
                    }else
                    {
                        //
                        System.out.println("Player has "+this.totals[0]+" showing.");
                    }
                }
                if(res.charAt(0)=='s')
                {
                    //
                    System.out.println("Player stays at "+this.totals[0]+".");
                    this.isStay[0]=true;
                }
                if(res.charAt(0)!='h' && res.charAt(0)!='s')
                {
                    //
                    System.out.println("What'd you say?");
                }
            }
        }
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Determines who has won.
    */
    public void determineWinner()
    {
        //
        if(this.totals[0]==this.totals[1])
        {
            //
            this.isWinner[0]=true;
            this.isWinner[1]=true;
        }else
        {
            //
            if(this.totals[0]>this.totals[1])
            {
                //
                this.isWinner[0]=true;
            }else
            {
                //
                this.isWinner[1]=true;
            }
        }
    }    
}
