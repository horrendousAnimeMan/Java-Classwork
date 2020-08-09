import java.lang.StringBuilder;

/**
 * Write a description of class CourseGrades here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CourseGrades
{
    private GradedActivity[] grades;
    
    	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the CourseGrades object with proper array length.
    */
    public CourseGrades()
    {
        this.grades=new GradedActivity[4];
    }
    
    	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the Lab object.
    */
    public void setLab(GradedActivity g1)
    {
        this.grades[0]=g1;
    }
    
    	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the Essay object.
    */
    public void setEssay(Essay e1)
    {
        this.grades[2]=e1;
    }
    
    	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the FinalExam object.
    */
    public void setFinalExam(FinalExam f1)
    {
        this.grades[3]=f1;
    }
    
    	/**
        * @param none
        * @return none
        * @throws none
        * Sets up the PassFailExam object.
    */
    public void setPassFailExam(PassFailExam p1)
    {
        this.grades[1]=p1;
    }
    
    	/**
        * @param none
        * @return String the big one
        * @throws none
        * Returns the large string containing all data in object.
    */
    public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append("GRADES FOR THING:\n");
        sb.append("LAB: SCORE: "+this.grades[0].getScore()+" GRADE: "+this.grades[0].getGrade()+"\n");
        sb.append("PASS-FAIL: SCORE: "+this.grades[1].getScore()+" GRADE: "+this.grades[1].getGrade()+"\n");
        sb.append("ESSAY: SCORE: "+this.grades[2].getScore()+" GRADE: "+this.grades[2].getGrade()+"\n");
        sb.append("FINAL: SCORE: "+this.grades[3].getScore()+" GRADE: "+this.grades[3].getGrade()+"\n");
        return sb.toString();
    }
}
