import java.util.Scanner;

/**
 * Write a description of class GradedActivity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GradedActivity
{
   protected double score;
   protected char grade;
   
   	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the GradedActivity object.
    */
   public GradedActivity()
   {
       Scanner scanny=new Scanner(System.in);
       System.out.println("Looks like solid work.  What's the score, out of a hundred?");
       this.score=scanny.nextDouble();
       this.setGradeFromScore();
   }
   
   	/**
        * @param double scoreToBeSet
        * @return none
        * @throws none
        * Sets score.
    */
   public void setScore(double in)
   {
       this.score=in;
   }
   
   	/**
        * @param none
        * @return this.score
        * @throws none
        * Returns its score.
    */
   public double getScore()
   {
       return this.score;
   }
   
   	/**
        * @param none
        * @return none
        * @throws none
        * Determines grade from this.score.
    */
   public void setGradeFromScore()
   {
       char c='A';
       double n =90;
       while(n>this.score)
       {
           n-=10;
           ++c;
       }
       if(c=='E')
       {
           this.grade='F';
       }else
       {
           this.grade=c;
       }
   }
   
   	/**
        * @param none
        * @return none
        * @throws none
        * Sets the grade.
    */
   public void setGrade(char setGrade)
   {
       this.grade=setGrade;
   }
   
   	/**
        * @param none
        * @return this.grade
        * @throws none
        * Sets up the Payroll object.
    */
   public char getGrade()
   {
       return this.grade;
   }
}
