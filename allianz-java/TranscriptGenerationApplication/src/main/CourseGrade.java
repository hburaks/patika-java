package main;

import util.Grade;
import util.GradeTest;

public class CourseGrade {
    private int courseCode;
    private int courseCredit;
    private String courseDepartment;
    private Grade gradeTaken;


    private int defaultCourseCode = 100;
    private int defaultCourseCredit = 4;
    private String defaultCourseDepartment = "CENG";
    private Grade defaultGradeTaken = Grade.F;



    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        this.setCourseCode(courseCode);
        this.setCourseCredit(courseCredit);
        this.setCourseDepartment(courseDepartment);
        this.setGradeTaken(gradeTaken);
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode >= 100 && courseCode < 600) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = this.getDefaultCourseCode();
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if (courseCredit > 2 && courseCredit <= 4) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = this.getDefaultCourseCredit();
        }
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        if (courseDepartment.equals("CENG") || courseDepartment.equals("COMP") || courseDepartment.equals("ECE") || courseDepartment.equals("ME") || courseDepartment.equals("MATH")) {
            this.courseDepartment = courseDepartment;
        } else {
            this.courseDepartment = this.getDefaultCourseDepartment();
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(double val) {

        int roundedGradeVal = (int) Math.round(val);
        if (roundedGradeVal == 4) {
            setGradeTaken(Grade.A);
        } else if (roundedGradeVal == 3) {
            setGradeTaken(Grade.B);
        } else if (roundedGradeVal == 2) {
            setGradeTaken(Grade.C);
        } else if (roundedGradeVal == 1) {
            setGradeTaken(Grade.D);
        } else {
            setGradeTaken(this.getDefaultGradeTaken());
        }
    }

    public void setGradeTaken(Grade g) {
        this.gradeTaken = g;
    }

    public int getDefaultCourseCode() {
        return defaultCourseCode;
    }

    public int getDefaultCourseCredit() {
        return defaultCourseCredit;
    }

    public String getDefaultCourseDepartment() {
        return defaultCourseDepartment;
    }

    public Grade getDefaultGradeTaken() {
        return defaultGradeTaken;
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment +
                " CourseCode: " + courseCode +
                " Credit: " + courseCredit +
                " Grade: " + this.getGradeTaken().getStringValue().toString() + "\n";
    }
}
