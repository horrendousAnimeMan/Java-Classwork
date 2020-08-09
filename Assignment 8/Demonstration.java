import java.util.Scanner;
/**
*Description: Driver for Assignment 8, p.540, #2: Demo of Payroll Class.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 8, Chapter 7
*Date: 06/26/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

public class Demonstration
{
	/**
        * @param String[] args
        * @return none
        * @throws none
        * Creates a Payroll object and populates it.
    */
    public static void main(String[] args)
    {
        Payroll steve=new Payroll();
        steve.newInput();
        steve.calcWages();
        steve.newOutput();
        System.out.println("Enter EID to find an employee's gross pay:");
        Scanner scanny=new Scanner(System.in);
        int idToFind=scanny.nextInt();
        System.out.println(steve.getPayForID(idToFind));
        System.out.println("Wasn't that lovely?.  Press any key to do nothing.");
    }
}
