import java.util.Scanner;
/**
 * Write a description of class FinalExam here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FinalExam extends GradedActivity
{
    protected int numQuestions;
    protected int missed;
    private double pointsEach;
    
    	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the FinalExam object.
    */
    public FinalExam()
    {
        Scanner scanny=new Scanner(System.in);
        System.out.println("How many questions were there?");
        this.numQuestions=scanny.nextInt();
        System.out.println("How many were missed?");
        this.missed=scanny.nextInt();
        if(this.missed>this.numQuestions)
        {
            System.out.println("Don't mess with me.");
            this.missed=this.numQuestions;
        }
        this.score=((double)this.missed/(double)this.numQuestions)*1000;
    }
    
    	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the Payroll object based on predetermined inputs.
    */
    public FinalExam(int questions, int missed)
    {
        this.score=((double)missed/(double)questions);
    }
    
}
