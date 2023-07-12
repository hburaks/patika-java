package service;

import model.DanceCourse;
import model.Student;
import model.Sex;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class StudentService {
    public static DanceCourse createStudent(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        System.out.print("Öğrenci ismini giriniz: ");
        String studentName = inp.nextLine();
        System.out.print("Öğrenci yaşını giriniz: ");
        int studentAge = inp.nextInt();

        boolean running = true;
        Sex studentSex = Sex.OTHER;
        while(running){
            System.out.println("Seçenekler:");
            System.out.println("1 - Erkek");
            System.out.println("2 - Kadın");
            System.out.println("3 - Diğer");
            System.out.print("Lütfen cinsiyeti belirtiniz: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                studentSex = Sex.MALE;
                running = false;
            } else if (choice == 2) {
                studentSex = Sex.FEMALE;
                running = false;
            } else if (choice == 3) {
                studentSex = Sex.OTHER;
                running = false;
            } else {
                System.out.println("----------------- Lütfen belirtilen aralıkta bir seçim yapınız -----------------");
            }
        }
        System.out.print("Öğrenciden alıncak ücreti giriniz: ");
        BigDecimal studentSalary = inp.nextBigDecimal();

        Student student = new Student(studentName, studentAge, studentSex, studentSalary);

        System.out.print("Lütfen kontrat başlangıç tarihini 'YYYY/MM/DD' formatında giriniz: ");
        String startDate = inp.nextLine();


        student.setStartDate(new Date(startDate));

        System.out.print("Lütfen kontrat bitiş tarihini 'YYYY/MM/DD' formatında giriniz: ");
        String endDate = inp.nextLine();

        student.setEndDate(new Date(endDate));
        return danceCourse;
    }
}
