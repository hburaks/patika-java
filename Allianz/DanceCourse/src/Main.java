import model.DanceCourse;
import service.*;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        DanceCourse danceCourse = DanceCourseService.createDanceCourse("HBS Academy",
                "Bostanlı - Karşıyaka - İzmir - Türkiye",
                "Hasan Burak Songur",
                "2222222222",
                "Mesir"
        );
        danceCourse = InitialDataService.loadInitialData(danceCourse);
        Scanner inp = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("User types:");
            System.out.println("1 - Admin");
            System.out.println("2 - Instructor");
            System.out.println("3 - Student");
            System.out.println("0 - Exit");
            System.out.print("Please select the user type: ");
            int choice = inp.nextInt();
            if(choice == 1){
                danceCourse = AdminService.start(danceCourse);
            } else if (choice == 2) {
                danceCourse = InstructorService.start(danceCourse);
            } else if (choice == 3) {
                danceCourse = StudentService.start(danceCourse);
            } else if (choice == 0) {
                System.out.println("--------------------- Program is terminated ---------------------");
                running = false;
            } else {
                System.out.println("--------------------- Please select from the options ---------------------");
            }
        }
    }
}