import java.util.Scanner;
public class GraduateSituation {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int math,music,turkish;
        double average;
        System.out.print("Math note:");
        math = inp.nextInt();
        System.out.print("Music note:");
        music = inp.nextInt();
        System.out.print("Turkish note:");
        turkish = inp.nextInt();
        average = (math+music+turkish)/3;
        if(average> 55){
            System.out.println("You passed the grade!");
        } else {
            System.out.println("You failed!");
        }
        System.out.println("Your note's average is"+average);

    }
}
