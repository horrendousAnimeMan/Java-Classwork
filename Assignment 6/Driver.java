/**
*Description: Driver for Assignment 6, p.354, #24: A Game of 21.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 6, Chapter 5
*Date: 06/15/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/
public class Driver
{
    /**
        * @param String[] args
        * @return none
        * @throws none
        * Plays a Game named tim.
    */
    public static void main(String[] args)
    {
        //
        Game tim = new Game();
        
        while(tim.isWinner[0]==false && tim.isWinner[1]==false)
        {
            //
            if(tim.isOver[0]==false && tim.isOver[1]==false)
            {
                //
                tim.hitOrStay();
                if(tim.isStay[0]==true && tim.isStay[1]==true)
                {
                    //
                    tim.determineWinner();
                }else
                {
                    //
                }
            }else
            {
                //
                if(tim.isOver[0]==true && tim.isOver[1]==true)
                {
                    //
                    System.out.println("Both Player and CPU are over.  You both win... At losing!");
                    tim.isWinner[0]=true;
                    tim.isWinner[1]=true;
                }else
                {
                    //
                    if(tim.isOver[0]==false)
                    {
                        tim.isWinner[0]=true;
                    }else
                    {
                        tim.isWinner[1]=true;
                    }
                }
            }
        }
        
        //
        if(tim.isWinner[0]==true && tim.isWinner[1]==true)
        {
            //
            System.out.println("Here is your trophy for a tie game!  It is made of leaves I found on the ground.");
        }else
        {
            if(tim.isWinner[0]==true)
            {
                //
                System.out.println("Player wins with "+tim.totals[0]+" vs. "+tim.totals[1]+".");
            }else
            {
                //
                System.out.println("CPU wins with "+tim.totals[1]+" vs. "+tim.totals[0]+".");
            }
        }
        System.out.println("All right, that's it. Everyone only gets one game.  Get up and come back again with a fake moustache.");
    }
    
}

