package main;

import util.Grade;
import util.GradeTest;

import java.util.Scanner;

public class GenerateTranscript {
    Scanner inp = new Scanner(System.in);

    public void takeInputFromUser() {
        System.out.print(" Enter Student Id: ");
        int studentId = inp.nextInt();
        inp.nextLine();

        Transcript transcript = new Transcript(studentId);
        System.out.println("If you want to finish adding enter 'endoffile'");

        while (true) {
            System.out.print("Enter Department: ");

            String department = inp.nextLine();

            if (department.equals("endoffile")) {
                break;
            }


            CourseGrade courseGrade = new CourseGrade(department);
            System.out.print("Enter Course Code: ");
            int courseCode = inp.nextInt();
            inp.nextLine();


            courseGrade.setCourseCode(courseCode);

            System.out.print("Enter Credit: ");
            int courseCredit = inp.nextInt();
            courseGrade.setCourseCredit(courseCredit);

            System.out.print("Enter Grade: ");
            double gradeDouble = inp.nextDouble();
            inp.nextLine();
            courseGrade.setGradeTaken(gradeDouble);
            transcript.addCourseTaken(courseGrade);
        }
        System.out.println(transcript);
    }
}
