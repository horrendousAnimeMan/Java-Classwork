import java.util.Random;

/**
*Description: Die class from Chapter 4,p.265, extended.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 6, Chapter 5
*Date: 06/15/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

public class Die
{
    public int sides; //i know
    public int side; //aaaaagh i know,  
    
    /**
        * @param none
        * @return none
        * @throws none
        * Sets up the dice, rolls it.
    */
    public Die() //default
    {
        this.sides=6; //default dice
        this.side=this.roll();
    }
    
    /**
        * @param int sidesIn
        * @return none
        * @throws none
        * Sets up the dice with a specified number of sides, rolls it.
    */
    public Die(int sidesIn) //nifty dice
    {
        this.sides=sidesIn;
        this.side=this.roll();
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Rolls the dice.
    */
    public int roll()
    {
        Random rand= new Random();
        int b = rand.nextInt(this.sides)+1;
        return b;
    }
    
    /**
        * @param none
        * @return this.sides
        * @throws none
        * returns the number of sides on the dice.
    */
    public int getSides()
    {
        return this.sides;
    }
    
    /**
        * @param none
        * @return this.side
        * @throws none
        * returns the up-facing side of the dice.
    */
    public int getValue()
    {
        return this.side;
    }
}
