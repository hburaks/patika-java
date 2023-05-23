import java.util.Scanner;
public class NoteAverage {
    public static void main(String[] args) {

        int math, physic, chemistry, turkish, history ,music;
        Scanner inp = new Scanner(System.in);
        System.out.print("Math note:");
        math = inp.nextInt();
        System.out.print("Physic note:");
        physic = inp.nextInt();
        System.out.print("Chemistry note:");
        chemistry = inp.nextInt();
        System.out.print("Turkish note:");
        turkish = inp.nextInt();
        System.out.print("History note:");
        history = inp.nextInt();
        System.out.print("Music note:");
        music = inp.nextInt();
        double noteAverage = (math+chemistry+physic+turkish+history+music)/6;
        System.out.println(noteAverage>= 60 ? "You passed the grade. Your average is "+ noteAverage : "You failed. Your average is " + noteAverage);



    }
}