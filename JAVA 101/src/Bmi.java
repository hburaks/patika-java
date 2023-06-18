import java.util.Scanner;
public class Bmi {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Height in meter: ");
        double height = inp.nextDouble();
        System.out.print("Weight in kg: ");
        double weight = inp.nextDouble();
        double bmi = weight/ (height*height);
        System.out.println("Your BMI is " + bmi);

    }
}
