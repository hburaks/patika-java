package main;

import java.io.File;
import java.io.FileNotFoundException;
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

    public void takeInputFromFile() {
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter filename:");
        String filename = inp.nextLine();

        File file = new File(filename);
        try {
            inp = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int studentId = Integer.parseInt(inp.nextLine().trim());
        Transcript transcript = new Transcript(studentId);

        while (inp.hasNextLine()) {
            String line = inp.nextLine();
            String[] courseInfo = line.split(" ");
            String department = courseInfo[0];
            int courseCode = Integer.parseInt(courseInfo[1]);
            int credit = Integer.parseInt(courseInfo[2]);
            Double grade = Double.parseDouble(courseInfo[3]);
            CourseGrade courseGrade = new CourseGrade(department, courseCode, credit);
            courseGrade.setGradeTaken(grade);
            transcript.addCourseTaken(courseGrade);
        }
        System.out.println(transcript);
    }
}
