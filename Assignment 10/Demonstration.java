
/**
 * Write a description of class Demonstration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Demonstration
{
    public static void main(String[] args)
    {
        CourseGrades gradey=new CourseGrades();
        System.out.println("Now is time for Lab:");
        gradey.setLab(new GradedActivity());
        System.out.println("Now is the time for the Pass-Fail Exam:");
        gradey.setPassFailExam(new PassFailExam());
        System.out.println("This is the part where you arbitrarily grade the Essay:");
        gradey.setEssay(new Essay());
        System.out.println("Now is the time for the Final Exam:");
        gradey.setFinalExam(new FinalExam());
        System.out.println(gradey.toString());
    }
}
