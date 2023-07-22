import main.CourseGrade;
import main.GenerateTranscript;
import main.Transcript;
import util.Grade;
import util.GradeTest;


public class Main {
    public static void main(String[] args) {
        GradeTest.values();
        CourseGrade courseGrade = new CourseGrade("a");
        System.out.println(courseGrade.toString());
        Transcript transcript = new Transcript(20160141);

        CourseGrade course2 = new CourseGrade("a", 98, 3, Grade.A);
        CourseGrade course3 = new CourseGrade("MATH", 321, 4, Grade.C);
        CourseGrade course4 = new CourseGrade("COMP", 300, 7, Grade.A);
        CourseGrade course5 = new CourseGrade("ECE", 903, 4, Grade.B);

        transcript.addCourseTaken(course2);
        transcript.addCourseTaken(course3);
        transcript.addCourseTaken(course4);
        transcript.addCourseTaken(course5);

        System.out.println(transcript);

        GenerateTranscript generateTranscript = new GenerateTranscript();

        generateTranscript.takeInputFromUser();
    }
}