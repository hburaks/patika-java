import java.util.Scanner;

public class RecursivePattern {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = inp.nextInt();
        System.out.println("N number: " + number);
        System.out.print("Pattern: ");
        pattern(number);
    }

    public static void pattern(int number) {
        System.out.print(number + " ");
        if(number <= 0){
            return;
        }
        pattern(number -5);
        System.out.print(number + " ");
    }
}