
/**
*Description: Driver/Demo for Morse Converter class, for Assignment 9, p.603, #16.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 9, Chapter 8
*Date: 06/28/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

public class Demonstration
{
	/**
        * @param String[] args: no idea
        * @return none
        * @throws none
        * Sets up the MorseConverter object and completes it.
    */
    public static void main(String[] args)
    {
        MorseConverter jerry = new MorseConverter();
        jerry.populateHashtable();
        jerry.getInput();
        jerry.convertString();
        System.out.println("Original string: "+jerry.getString(0));
        System.out.println("Morse string: "+jerry.getString(1));
        System.out.println("-------------------boop---------------------");
    }
}
