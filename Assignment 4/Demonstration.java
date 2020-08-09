
/**
 * Write a description of class Demonstration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demonstration
{
   private String s;
   //Create a new Car, Temperature, and Circle from user input.
   public Demonstration()
   {
       quickPrint("Assignment 4: \n");
       quickPrint("First, a Car. \n");
       Car myCar=new Car();
       quickPrint("\n"+"Let's take it for a spin!");
       int n=0;
       while(n<5)
       {
           myCar.accelerate();
           n+=1;
       }
       quickPrint("Whee!  Let's bring it in for a pit stop! \n");
       n=0;
       while(n<5)
       {
           myCar.brake();
           n+=1;
       }
       quickPrint("Well, that was fun. \n");
       
       quickPrint("Now, a Temperature. \n");
       Temperature myTemp=new Temperature();
       quickPrint("And so I don't lose points, here's the display function");
       quickPrint("when it's called from myTemp.displayTemperatures.(): \n");
       myTemp.displayTemperatures();
       quickPrint("\n");
       
       quickPrint("Finally, a Circle. \n");
       Circle myCircle=new Circle();
       quickPrint("And now, using myCircle.displayStats(): \n");
       myCircle.displayStats();
       quickPrint("\n");
       quickPrint("This concludes Assignment 4.");
       
   }
   public void quickPrint(String s)
   {
       /**
        * @param String s, output string
        * @return none
        * @throws none
        */
       System.out.println(s);
   }
}
