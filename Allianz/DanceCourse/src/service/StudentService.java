package service;

import model.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class StudentService {
    public static DanceCourse start(DanceCourse danceCourse) {
        System.out.println("------------------- Continue as student --------------------------");
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Options:");
            System.out.println("1 - Get info about the course");
            System.out.println("2 - Get info about the lecture");
            System.out.println("0 - Back to the top menu");
            System.out.print("Please select the option: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                System.out.println(danceCourse.toString());;
            } else if (choice == 2) {
                // add the matching info about the lecture
            }   else if (choice == 0) {
                running = false;
            }   else {
                System.out.println("--------------------- Please select from the options  ---------------------");
            }
        }
        return danceCourse;
    }


    public static Student createStudent(String name, int age, Sex sex, BigDecimal contractAmount){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        student.setContractAmount(contractAmount);
        return student;
    }

    public static DanceCourse getStudentPayment(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Options:");
            for(int i = 0; i < danceCourse.getStudentList().size(); i++){
                if(danceCourse.getStudentList().get(i).isPaid() == false){
                    System.out.println(i + 1 + " - " + danceCourse.getStudentList().get(i));
                }
            }
            System.out.println("0 - Cancel");
            System.out.print("Please select the student to get paid from: ");
            int choice = inp.nextInt() - 1;
            if (choice < danceCourse.getStudentList().size() && choice >= 0 &&
                    danceCourse.getStudentList().get(choice).isPaid() == false) {
                Student student = danceCourse.getStudentList().get(choice);
                BankAccount bankAccount = BankAccountService.getBankAccountToSendMoney(danceCourse);
                PaymentMovement paymentMovement = PaymentMovementService.createPaymentMovement(bankAccount,
                        student.getName() + " contract payment",
                        MovementType.INCOME, student.getContractAmount()
                );
                bankAccount.setAmount(bankAccount.getAmount().add(student.getContractAmount()));
                student.setPaid(true);
                danceCourse.getPaymentMovementList().add(paymentMovement);
                System.out.println("----------------- The payment of student " +
                        student.getName() +
                        " in the amount of " +
                        student.getContractAmount() +
                        " paid to the "+
                        bankAccount.getBankName() +
                        " account ----------------- ");
                running = false;
            } else if (choice == -1) {
                running = false;
                break;
            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        return danceCourse;
    }

    public static DanceCourse createStudent(DanceCourse danceCourse) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Student name: ");
        String studentName = inp.nextLine();

        boolean running4 = true;
        int studentAge = 0;
        while(running4){
            System.out.print("Student age: ");
            studentAge = inp.nextInt();
            if (studentAge > 18) {
                running4 = false;
            }  else {
                System.out.println("----------------- Student age must be higher than 18 -----------------");
            }
        }

        boolean running = true;
        Sex studentSex = null;
        while (running) {
            System.out.println("Options:");
            System.out.println("1 - Male");
            System.out.println("2 - Female");
            System.out.print("Select the gender: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                studentSex = Sex.MALE;
                running = false;
            } else if (choice == 2) {
                studentSex = Sex.FEMALE;
                running = false;
            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        System.out.print("The contract amount: ");
        BigDecimal studentSalary = inp.nextBigDecimal();

        Student student = createStudent(studentName, studentAge, studentSex, studentSalary);


        boolean running2 = true;
        while (running2) {
            System.out.print("Contract starting date in the format of 'YYYY/MM/DD' : ");
            String startDateString = inp.nextLine();
            if (startDateString.isEmpty()) {
                continue;
            }
            try {
                Date startDate = dateCreator(startDateString);
                student.setStartDate(startDate);
                running2 = false;
            } catch (ParseException e) {
                System.out.println("Invalid date format! Try again.");
            }
        }
        boolean running3 = true;
        while (running3) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            System.out.print("Contract end date in the format of 'YYYY/MM/DD' : ");
            String endDateString = inp.nextLine();
            try {
                Date endDate = dateCreator(endDateString);
                student.setEndDate(endDate);
                running3 = false;
            } catch (ParseException e) {
                System.out.println("Invalid date format! Try again.");
            }
        }

        DanceCourseService.addStudentToDanceCourse(danceCourse, student);

        return danceCourse;
    }

    public static Date dateCreator(String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = df.parse(dateString);
        return date;
    }
}
