import model.DanceCourse;
import service.AdminService;
import service.CourseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DanceCourse danceCourse = new DanceCourse();
        danceCourse = CourseService.defaultParameters(danceCourse);
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Kullanıcı tipleri:");
            System.out.println("1 - Yönetici");
            System.out.println("2 - Eğitmen");
            System.out.println("3 - Öğrenci");
            System.out.println("0 - Çıkış");
            System.out.print("Lütfen kullanıcı tipini belirtiniz: ");
            int choice = inp.nextInt();
            if(choice == 1){
                danceCourse = AdminService.start(danceCourse);
            } else if (choice == 2) {

            } else if (choice == 3) {

            } else if (choice == 0) {
                System.out.println("--------------------- Program sonlandırılıyor ---------------------");
                running = false;
            } else {
                System.out.println("--------------------- Lütfen belirtilen aralıkta bir seçim yapınız ---------------------");
            }
        }
    }
}

/*
* Kullanıcı tipi
 * Yönetici
 * öğretmen bilgilerini gir
 * Banka bilgilerini gir
 * Branşları oluştur
 * Öğretmen
 * Öğrenci
*
*
*  */