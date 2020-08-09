
/**
 * Write a description of class PassFailExam here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PassFailExam extends FinalExam
{
   private double minPassingScore;
   
   	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the PassFail object and chuckles at the way the default constructor is called.
    */
   public PassFailExam()
   {
       System.out.println("Aehee");
   }
   
   	/**
        * @param none
        * @return none
        * @throws none
        * Weighs grade against minimum passing score, assigns grade to object.
    */
   public void setGradeFromScore()
   {
       if(this.getScore()>=this.minPassingScore)
       {
           this.setGrade('A');
       }else{this.setGrade('F');}
   }
}
