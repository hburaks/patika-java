package service;

import model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class InstructorService {
    public static DanceCourse start(DanceCourse danceCourse) {
        System.out.println("------------------- Continue as Instructor --------------------------");
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Options:");
            System.out.println("1 - Get info about the course");
            System.out.println("2 - Add student");
            System.out.println("0 - Back to the top menu");
            System.out.print("Please select the option: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                System.out.println(danceCourse.toStringAdminEducation());;
            } else if (choice == 2) {
                danceCourse = StudentService.createStudent(danceCourse);
                System.out.println("----------------- " +
                        danceCourse
                                .getStudentList()
                                .get(danceCourse.getInstructorList().size() -1)
                                .getName() + " added to student list ----------------- ");
            }   else if (choice == 0) {
                running = false;
            }   else {
                System.out.println("--------------------- Please select from the options  ---------------------");
            }
        }
        return danceCourse;
    }
    public static Instructor createInstructor(String name, int age, Sex sex, BigDecimal salary) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setAge(age);
        instructor.setSex(sex);
        instructor.setSalary(salary);
        return instructor;
    }
    public static Instructor createInstructor(String name, int age, Sex sex) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setAge(age);
        instructor.setSex(sex);
        return instructor;
    }
    public static DanceCourse createInstructor(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        System.out.print("Instructor name: ");
        String instructorName = inp.nextLine();

        boolean running2 = true;
        int instructorAge = 0;
        while(running2){
            System.out.print("Instructor age: ");
            instructorAge = inp.nextInt();
            if (instructorAge < 53) {
                running2 = false;
            }  else {
                System.out.println("----------------- Instructor age must be lower than 53 -----------------");
            }
        }

        boolean running = true;
        Sex instructorSex = null;
        while(running){
            System.out.println("Options:");
            System.out.println("1 - Male");
            System.out.println("2 - Female");
            System.out.print("Select the gender: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                instructorSex = Sex.MALE;
                running = false;
            } else if (choice == 2) {
                instructorSex = Sex.FEMALE;
                running = false;
            }  else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        Instructor instructor = createInstructor(instructorName,instructorAge,instructorSex);
        makeInstructorPayment(danceCourse,instructor);

        danceCourse = addBranchToInstructor(instructor,danceCourse);
        DanceCourseService.addInstructorToDanceCourse( danceCourse, instructor);

        danceCourse = addBranchToInstructor(instructor,danceCourse);

        return danceCourse;
    }

    public static void addBranchToInstructor(Instructor instructor, Branch branch){
        instructor.getBranchList().add(branch);
    }
    public static DanceCourse addBranchToInstructor(Instructor instructor, DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        boolean running2 = true;
        while(running2){
            System.out.println("Options:");
            for(int i = 0; i < danceCourse.getBranchList().size(); i++){
                System.out.println(i + 1 + " - " + danceCourse.getBranchList().get(i));
            }
            System.out.print("Please specify the branch to be added to the instructor: ");
            int choice = inp.nextInt() -1;
            if (choice < danceCourse.getBranchList().size() && choice >= 0) {
                addBranchToInstructor(instructor,danceCourse.getBranchList().get(choice));
                System.out.println("----------------- " +
                        instructor
                                .getBranchList()
                                .get(instructor.getBranchList().size() -1)
                                .getName() +
                        " branch added to " +
                        instructor.getName() +
                        " instructor ----------------- ");
                running2 = false;
            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        return danceCourse;
    }
    public static void makeInstructorPayment(DanceCourse danceCourse , Instructor instructor){
        Scanner inp = new Scanner(System.in);
        BigDecimal instructorSalary = null;
        boolean running2 = true;
        while (running2){
            System.out.print("Instructor salary: ");
            instructorSalary = inp.nextBigDecimal();
            BankAccount bankAccount = BankAccountService.
                    getBankAccountWithEnoughMoney(danceCourse, instructorSalary);
            if(bankAccount != null){
                bankAccount.setAmount(bankAccount.getAmount().subtract(instructorSalary));
                PaymentMovement paymentMovement = PaymentMovementService.createPaymentMovement(bankAccount,
                        instructor.getName() + " salary payment",
                        MovementType.OUTCOME, instructorSalary);
                DanceCourseService.addPaymentMovementToDanceCourse(danceCourse, paymentMovement);
                instructor.setSalary(instructorSalary);
                running2 = false;
            }else{
                System.out.println("Instructor cannot be hired because there is no bank account with sufficient funds");
            }
        }
    }
}
