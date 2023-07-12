package service;

import model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class InstructorService {
    public static DanceCourse createInstructor(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        System.out.print("Eğitmen ismini giriniz: ");
        String instructorName = inp.nextLine();
        System.out.print("Eğitmen yaşını giriniz: ");
        int instructorAge = inp.nextInt();

        boolean running = true;
        Sex instructorSex = Sex.OTHER;
        while(running){
            System.out.println("Seçenekler:");
            System.out.println("1 - Erkek");
            System.out.println("2 - Kadın");
            System.out.println("3 - Diğer");
            System.out.print("Lütfen cinsiyeti belirtiniz: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                instructorSex = Sex.MALE;
                running = false;
            } else if (choice == 2) {
                instructorSex = Sex.FEMALE;
                running = false;
            } else if (choice == 3) {
                instructorSex = Sex.OTHER;
                running = false;
            } else {
                System.out.println("----------------- Lütfen belirtilen aralıkta bir seçim yapınız -----------------");
            }
        }

        System.out.print("Eğitmen maaşını giriniz: ");
        BigDecimal instructorSalary = inp.nextBigDecimal();

        Instructor instructor = new Instructor(instructorName, instructorAge, instructorSex, instructorSalary);
        danceCourse.addInstructorToList(instructor);

        boolean running2 = true;
        while(running2){
            System.out.println("Seçenekler:");
            for(int i = 0; i < danceCourse.getBranchList().size(); i++){
                System.out.println(i + 1 + " - " + danceCourse.getBranchList().get(i));
            }
            System.out.print("Lütfen eğitmene eklenecek branşı belirtiniz: ");
            int choice = inp.nextInt() -1;
            if (choice < danceCourse.getBranchList().size() && choice >= 0) {
                instructor.addBranchtToList(danceCourse.getBranchList().get(choice));
                System.out.println("----------------- " +
                        instructor
                                .getBranchList()
                                .get(instructor.getBranchList().size() -1)
                                .getName() +
                        " branşı " +
                        instructor.getName() +
                        " eğitmenine eklendi ----------------- ");
                running2 = false;
            } else {
                System.out.println("----------------- Lütfen belirtilen aralıkta bir seçim yapınız -----------------");
            }
        }

        return danceCourse;
    }
}
