package service;

import model.DanceCourse;

import java.text.ParseException;
import java.util.Scanner;

public class AdminService {
    public static DanceCourse start(DanceCourse danceCourse) {
        System.out.println("------------------- Continue as admin --------------------------");
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Options:");
            System.out.println("1 - Financial Affairs");
            System.out.println("2 - Education");
            System.out.println("0 - Back to the top menu");
            System.out.print("Please select the option: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                danceCourse = financialAffairsOption(danceCourse);
            } else if (choice == 2) {
                danceCourse = educationOption(danceCourse);
            }   else if (choice == 0) {
                running = false;
            }   else {
                System.out.println("--------------------- Please select from the options  ---------------------");
            }
        }
        return danceCourse;
    }
    public static DanceCourse financialAffairsOption(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        int choice;
        while(running){
            System.out.println("Options:");
            System.out.println("1 - Get financial information");
            System.out.println("2 - Add bank account");
            System.out.println("3 - Get course payment");
            System.out.println("4 - Payment movements");
            System.out.println("0 - Back to the top menu");
            System.out.print("Please select the category: ");
            choice = inp.nextInt();
            if(choice == 0){
                running = false;
            } else if (choice == 1) {
                System.out.println(danceCourse.toStringAdminFinancial());
            } else if (choice == 2) {
                danceCourse = BankAccountService.createNewBankAccount(danceCourse);
                System.out.println("----------------- Account in " +
                        danceCourse
                        .getBankAccountList()
                        .get(danceCourse.getBankAccountList().size() -1)
                                .getBankName() + " bank, added to list ----------------- ");
            } else if (choice == 3) {
                danceCourse = StudentService.getStudentPayment(danceCourse);
            } else if (choice == 4) {
                System.out.println(danceCourse.getPaymentMovementList().toString());
            }  else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        return danceCourse;
    }
    public static DanceCourse educationOption(DanceCourse danceCourse) {
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Options:");
            System.out.println("1 - Get info about the course");
            System.out.println("2 - Add new instructor");
            System.out.println("3 - Add new student");
            System.out.println("4 - Create branch");
            System.out.println("5 - Create lecture");
            System.out.println("6 - Add instructor to lecture");
            System.out.println("7 - Add student to lecture");
            System.out.println("0 - Back to the top menu");
            System.out.print("Please select the action: ");
            int choice = inp.nextInt();
            if(choice == 0){
                running = false;
            } else if (choice == 1) {
                System.out.println( danceCourse.toStringAdminEducation());
            } else if (choice == 2) {
                danceCourse = InstructorService.createInstructor(danceCourse);
                System.out.println("----------------- " +
                        danceCourse
                                .getInstructorList()
                                .get(danceCourse.getInstructorList().size() -1)
                                .getName() + " added to instructor list ----------------- ");
            } else if (choice == 3) {
                danceCourse = StudentService.createStudent(danceCourse);
                System.out.println("----------------- " +
                        danceCourse
                                .getStudentList()
                                .get(danceCourse.getInstructorList().size() -1)
                                .getName() + " added to student list ----------------- ");
            } else if (choice == 4) {
                danceCourse = BranchService.createBranch(danceCourse);
                System.out.println("----------------- " +
                        danceCourse
                                .getBranchList()
                                .get(danceCourse.getBranchList().size() -1)
                                .getName() + " added to branch list ----------------- ");

            } else if (choice == 5){
                danceCourse = LectureService.createLecture(danceCourse);
            } else if (choice == 6){
                danceCourse = LectureService.addInstructorToLecture(danceCourse);
            } else if (choice == 7){
                danceCourse = LectureService.addStudentToLecture(danceCourse);
            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        return danceCourse;
    }


}
