package service;

import model.BankAccount;
import model.DanceCourse;
import model.Day;

import java.math.BigDecimal;
import java.util.Scanner;

public class AdminService {
    public static DanceCourse start(DanceCourse danceCourse) {
        System.out.println("------------------- Yönetici olarak devam ediyorsunuz --------------------------");
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Seçenekler:");
            System.out.println("1 - Mali İşler");
            System.out.println("2 - Eğitim");
            System.out.println("0 - Üst menüye dön");
            System.out.print("Lütfen işlem yapmak istediğiniz kategoriyi belirtiniz: ");
            int choice = inp.nextInt();
            if (choice == 1) {
                danceCourse = financialAffairsOption(danceCourse);
            } else if (choice == 2) {
                danceCourse = educationOption(danceCourse);
            }   else if (choice == 0) {
                running = false;
            }   else {
                System.out.println("--------------------- Lütfen belirtilen aralıkta bir seçim yapınız ---------------------");
            }
        }
        return danceCourse;
    }
    public static DanceCourse financialAffairsOption(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        int choice;
        while(running){
            System.out.println("Seçenekler:");
            System.out.println("1 - Mali bilgi al");
            System.out.println("2 - Banka hesabı ekle");
            System.out.println("3 - Kurs bedeli al");
            System.out.println("4 - Eğitmen maaşı öde");
            System.out.println("0 - Üst menüye dön");
            System.out.print("Lütfen işlem yapmak istediğiniz kategoriyi belirtiniz: ");
            choice = inp.nextInt();
            if(choice == 0){
                running = false;
            } else if (choice == 1) {
                System.out.println(danceCourse.toStringAdminFinancial());
            } else if (choice == 2) {
                danceCourse = FinancialService.createNewBankAccount(danceCourse);
                System.out.println("----------------- " +
                        danceCourse
                        .getBankAccountList()
                        .get(danceCourse.getBankAccountList().size() -1)
                                .getBankName() + " bankasındaki hesabınız listeye eklendi ----------------- ");
            } else if (choice == 3) {
            } else if (choice == 4) {
            }  else {
                System.out.println("----------------- Lütfen belirtilen aralıkta bir seçim yapınız -----------------");
            }
        }
        return danceCourse;
    }
    public static DanceCourse educationOption(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Seçenekler:");
            System.out.println("1 - Kurs hakkında bilgi al");
            System.out.println("2 - Yeni eğitmen ekle");
            System.out.println("3 - Yeni öğrenci ekle");
            System.out.println("4 - Branş oluştur");
            System.out.println("0 - Üst menüye dön");
            System.out.print("Lütfen işlem yapmak istediğiniz kategoriyi belirtiniz: ");
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
                                .getName() + " eğitmen listesine eklendi ----------------- ");
            } else if (choice == 3) {
                danceCourse = StudentService.createStudent(danceCourse);
                System.out.println("----------------- " +
                        danceCourse
                                .getInstructorList()
                                .get(danceCourse.getInstructorList().size() -1)
                                .getName() + " öğrenci listesine eklendi ----------------- ");
            } else if (choice == 4) {
                danceCourse = BranchService.createBranch(danceCourse);
                System.out.println("----------------- " +
                        danceCourse
                                .getBranchList()
                                .get(danceCourse.getBranchList().size() -1)
                                .getName() + " branşı listeye eklendi ----------------- ");

            }else {
                System.out.println("----------------- Lütfen belirtilen aralıkta bir seçim yapınız -----------------");
            }
        }
        return danceCourse;
    }


}
