import java.util.Hashtable;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Scanner;

/**
*Description: Morse Converter class for Assignment 9, p.603, #16.
*Class: Fall - COSC 1437.81002
*Assignment: Assignment 9, Chapter 8
*Date: 06/28/2017
*@author  Benjamin Guthrie
*@version 1.0.0
*/

public class MorseConverter
{
    private String[] strings;
    private Hashtable morseTable;
	/**
        * @param none
        * @return none
        * @throws none
        * Creates a new morse converter/initializes its strings and its hashtable.
    */    
    public MorseConverter()
    {
        this.strings = new String[2];
        this.morseTable=new Hashtable();
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Populates the hash table with character values and their corresponding morse.
    */
    public void populateHashtable()
    {
        String[] alpha={".-","-...","-.-.","-..",".","..-.","--.","....","..",
        ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
        "-","..-","...-",".--","-..-","-.--","--.."
        };
        String[] numeric={"-----",".----","..---","...--",
                "....-",".....","-....","--...",
                "---..","----."};
        this.morseTable.put(" "," ");
        this.morseTable.put(',',"--..--");
        this.morseTable.put('.',"-.-.-");
        this.morseTable.put('?',"..--..");
        int n=0;
        for(char a='A';a<='Z';++a)
        {
            //System.out.println("a="+a);
            this.morseTable.put(a,alpha[n]);
            n+=1;
        }
        n=0;
        for(char b='0';b<='9';++b)
        {
            this.morseTable.put(b,numeric[n]);
            n+=1;
        }
        
        //System.out.println("morseTable after population:\n"+morseTable.toString());
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Converts its string in this.strings[0] to morse code.
    */
    public void convertString()
    {
        StringBuilder goodString=new StringBuilder();
        goodString.append((this.strings[0]).toUpperCase());
        StringBuilder morseString=new StringBuilder();
        int n=0;
        //System.out.println(this.morseTable.containsKey(','));
        //System.out.println("this.morseTable.get('A')= "+this.morseTable.get('A'));
        //System.out.println("this.morseTable.get(goodString.charAt(n)))="+this.morseTable.get(goodString.charAt(n)));
        while(n<goodString.length())
        {
            if(this.morseTable.containsKey(goodString.charAt(n))==true)
            {
                //System.out.println("morseTable.contains(etc)==true");
                morseString.append(this.morseTable.get(goodString.charAt(n)));
                morseString.append(" ");
            }else
            {
                //System.out.println("morseTable.contains(etc)==false");
                morseString.append(goodString.charAt(n));
                morseString.append(" ");
            }
            n+=1;
        }
        //System.out.println("morseString after convertString:"+morseString);
        this.strings[1]=morseString.toString();
    }
    
    /**
        * @param none
        * @return none
        * @throws none
        * Gets input from user to convert.
    */
    public void getInput()
    {
        Scanner scanny = new Scanner(System.in);
        System.out.println("Enter the words to be converted to Morse Code.");
        this.strings[0]=scanny.nextLine();
        System.out.println("Input received.");
    }
    
    /**
        * @param int index: 0 or 1, return either the original or the morse string.
        * @return none
        * @throws none
        * Returns the string at this.strings[index]
    */
    public String getString(int index)
    {
        if(index<=1 && index>-1){return this.strings[index];}else{return "String not found.";}
    }
}
