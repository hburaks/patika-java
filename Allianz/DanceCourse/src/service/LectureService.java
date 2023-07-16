package service;

import model.*;

import java.util.*;

public class LectureService {
    public static DanceCourse createLecture(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        System.out.print("Lecture name: ");
        String lectureName = inp.nextLine();

        boolean running = true;
        int capacity = 0;
        while(running){
            System.out.println("You can go back by enter 0.");
            System.out.print("Lecture capacity: ");
            capacity = inp.nextInt();
            int totalCapacity = getTotalCapacityOfLectures(danceCourse);
            if(capacity == 0){
                return danceCourse;
            } else if (totalCapacity + capacity <= danceCourse.getCapacity()) {
                running = false;
            } else {
                System.out.println("----------------- Lecture capacity exceeds the total capacity by "
                        + (capacity + totalCapacity - danceCourse.getCapacity()) + " -----------------");
            }
        }

        Branch branch = DanceCourseService.getBranchFromDanceCourse(danceCourse);
        Lecture lecture = createLecture(lectureName,branch,capacity);
        setLectureType(lecture);

        RepeatedTime repeatedTime = getRepeatedTime(lecture);
        String time = getLectureTime(lecture);
        autoGenerateScheduleTimeForLecture(lecture, repeatedTime, time);


        DanceCourseService.addLectureToDanceCourse(danceCourse,lecture);
        return danceCourse;
    }

public static int getTotalCapacityOfLectures(DanceCourse danceCourse){
    int totalCapacityOfLectures = 0;
    if(danceCourse.getLectureList() == null){
        danceCourse.setLectureList(new ArrayList<>());
    }
    for(Lecture lecture : danceCourse.getLectureList()){
        totalCapacityOfLectures += lecture.getCapacity();
    }
    return totalCapacityOfLectures;
}
    public static Lecture createLecture(String name, Branch branch, int capacity) {

        Lecture lecture = new Lecture();
        lecture.setName(name);
        lecture.setCapacity(capacity);
        lecture.setBranch(branch);

        return lecture;
    }
    public static DanceCourse addInstructorToLecture(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        Lecture lecture = null;
        if(danceCourse.getInstructorList() == null){
            danceCourse.setInstructorList(new ArrayList<>());
        }
        if(danceCourse.getLectureList() == null){
            danceCourse.setLectureList(new ArrayList<>());
        }
        boolean running = true;
        boolean running2 = true;
        while(running){
            System.out.println("Options:");
            System.out.println("0 - Back");
            if(danceCourse.getLectureList().size() == 0){
                System.out.println("No lecture in the list");
            } else {
                for(int i = 0; i < danceCourse.getLectureList().size(); i++){
                    System.out.println(i + 1 + " - " + danceCourse.getLectureList().get(i));
                }
                System.out.print("Please specify the lecture: ");
            }
            int choice = inp.nextInt() -1;
            if (choice < danceCourse.getLectureList().size() && choice >= 0) {
                lecture = danceCourse.getLectureList().get(choice);
                running = false;
            } else if (choice == -1) {
                running = false;
                running2 = false;

            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        Instructor instructor = null;
        while(running2){
            System.out.println("Options:");
            for(int i = 0; i < danceCourse.getInstructorList().size(); i++){
                System.out.println(i + 1 + " - " + danceCourse.getInstructorList().get(i));
            }
            System.out.print("Please specify the branch: ");
            int choice = inp.nextInt() -1;
            if (choice < danceCourse.getInstructorList().size() && choice >= 0) {
                instructor = danceCourse.getInstructorList().get(choice);
                running2 = false;
                addInstructorToLecture(lecture,instructor);
            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        return danceCourse;
    }

    public static void addInstructorToLecture(Lecture lecture, Instructor instructor) {
        lecture.setInstructor(instructor);
    }

    public static DanceCourse addStudentToLecture(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        Lecture lecture = null;
        if(danceCourse.getInstructorList() == null){
            danceCourse.setInstructorList(new ArrayList<>());
        }
        if(danceCourse.getLectureList() == null){
            danceCourse.setLectureList(new ArrayList<>());
        }
        boolean running = true;
        boolean running2 = true;
        while(running){
            System.out.println("Options:");
            System.out.println("0 - Back");
            if(danceCourse.getLectureList().size() == 0){
                System.out.println("No lecture in the list");
            } else {
                for(int i = 0; i < danceCourse.getLectureList().size(); i++){
                    System.out.println(i + 1 + " - " + danceCourse.getLectureList().get(i));
                }
                System.out.print("Please specify the lecture: ");
            }
            int choice = inp.nextInt() -1;
            if (choice < danceCourse.getLectureList().size() && choice >= 0) {
                lecture = danceCourse.getLectureList().get(choice);
                running = false;
            } else if (choice == -1) {
                running = false;
                running2 = false;

            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        Student student = null;
        while(running2){
            System.out.println("Options:");
            for(int i = 0; i < danceCourse.getStudentList().size(); i++){
                System.out.println(i + 1 + " - " + danceCourse.getStudentList().get(i));
            }
            System.out.print("Please specify the student: ");
            int choice = inp.nextInt() -1;
            if (choice < danceCourse.getStudentList().size() && choice >= 0) {
                student = danceCourse.getStudentList().get(choice);
                running2 = false;
                addStudentToLecture(lecture,student);
            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        return danceCourse;

    }

    public static void addStudentToLecture(Lecture lecture, Student student) {
        if(lecture.getStudentList() == null){
            lecture.setStudentList(new ArrayList<>());
        }
        int maleCount = 0;
        int femaleCount = 0;
        for(Student student1 : lecture.getStudentList()){
            if(student1.getSex() == Sex.MALE){
                maleCount++;
            } else if (student1.getSex() == Sex.FEMALE) {
                femaleCount++;
            }
        }
        if(maleCount - femaleCount > 2 || femaleCount - maleCount > 2){
            System.out.println("Sex counts are not close enough!");
        }else {
            lecture.getStudentList().add(student);
        }
    }



    public static void setLectureType(Lecture lecture){
        Scanner inp = new Scanner(System.in);

        boolean running = true;
        LectureType lectureType = null;
        while(running){
            System.out.println("Options:");
            System.out.println("1 - Group Lesson");
            System.out.println("2 - One to One");
            System.out.print("Select the lecture type: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                lectureType = LectureType.GROUP;
                running = false;
            } else if (choice == 2) {
                lectureType = LectureType.ONETOONE;
                running = false;
            }  else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }

        lecture.setLectureType(lectureType);
    }

    public static RepeatedTime getRepeatedTime(Lecture lecture){
        Scanner inp = new Scanner(System.in);
        boolean running2 = true;
        RepeatedTime repeatedTime = null;
        while(running2){
            System.out.println("Options:");
            System.out.println("1 - Every Day");
            System.out.println("2 - Every Week Day");
            System.out.println("3 - Weekend");
            System.out.print("Select the days: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                repeatedTime = RepeatedTime.EVERY_DAY;
                running2 = false;
            } else if (choice == 2) {
                repeatedTime = RepeatedTime.EVERY_WEEKDAY;
                running2 = false;
            } else if (choice == 3) {
                repeatedTime = RepeatedTime.WEEKEND;
                running2 = false;
            }  else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }

        return repeatedTime;
    }
    public static String getLectureTime(Lecture lecture){
        String time = null;
        Scanner inp = new Scanner(System.in);
        System.out.print("Set the time for lecture: ");
        time = inp.nextLine();
        return time;
    }
    public static void autoGenerateScheduleTimeForLecture(Lecture lecture, RepeatedTime repeatedTime, String time) {
        if(lecture.getLectureScheduleTimeSet() == null){
            lecture.setLectureScheduleTimeSet(new HashSet<>());
        }
        if(repeatedTime == RepeatedTime.EVERY_DAY){
            for(Day day : Day.values()){
                lecture.getLectureScheduleTimeSet().add(LectureScheduleTimeService.createLectureScheduleTime(day, time));
            }
        } else if (repeatedTime == RepeatedTime.EVERY_WEEKDAY) {
            lecture.getLectureScheduleTimeSet().add(LectureScheduleTimeService.createLectureScheduleTime(Day.MONDAY, time));
            lecture.getLectureScheduleTimeSet().add(LectureScheduleTimeService.createLectureScheduleTime(Day.TUESDAY, time));
            lecture.getLectureScheduleTimeSet().add(LectureScheduleTimeService.createLectureScheduleTime(Day.WEDNESDAY, time));
            lecture.getLectureScheduleTimeSet().add(LectureScheduleTimeService.createLectureScheduleTime(Day.THURSDAY, time));
            lecture.getLectureScheduleTimeSet().add(LectureScheduleTimeService.createLectureScheduleTime(Day.FRIDAY, time));
        } else if (repeatedTime == RepeatedTime.WEEKEND) {
            lecture.getLectureScheduleTimeSet().add(LectureScheduleTimeService.createLectureScheduleTime(Day.SATURDAY, time));
            lecture.getLectureScheduleTimeSet().add(LectureScheduleTimeService.createLectureScheduleTime(Day.SUNDAY, time));
        }
    }


}
