package main;

import util.Grade;

import java.util.ArrayList;

public class Transcript {
    private int studentID;
    private ArrayList<CourseGrade> courseGradeList;
    private double GPA;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.GPA = 0.0;
        this.courseGradeList = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public ArrayList<CourseGrade> getCourseGradeList() {
        return courseGradeList;
    }

    public void setCourseGradeList(ArrayList<CourseGrade> courseGradeList) {
        this.courseGradeList = courseGradeList;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        if (GPA >= 0 && GPA <= 4.0) {
            this.GPA = GPA;
        } else {
            this.GPA = 0.0;
        }
    }

    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade == null) {
            System.err.println("There is no grade! Firstly, create one!");
        } else {
            courseGradeList.add(courseGrade);
            updateTheGpa();
        }
    }

    public void updateTheGpa() {
        double totalGradeMultipliedWithCredit = 0;
        double totalCreditTaken = 0;
        for (CourseGrade courseGrade : this.getCourseGradeList()) {
            int courseCredit = courseGrade.getCourseCredit();
            int courseGradeNumericValue = courseGrade.getGradeTaken().getNumericValue();
            totalCreditTaken += courseCredit;
            totalGradeMultipliedWithCredit += courseGradeNumericValue * courseCredit;
        }
        this.GPA = totalGradeMultipliedWithCredit / totalCreditTaken;
    }


    @Override
    public String toString() {
        return "Student ID: " + studentID + "\n" +
                courseGradeList +
                "GPA: " + GPA;
    }
}
