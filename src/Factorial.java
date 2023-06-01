import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num;
        System.out.print("Enter a number: ");
        num = inp.nextInt();
        int factorial = 1;
        for( int i = 1; i <= num; i++){
            factorial *= i;
        }
        System.out.println("Factorial of " + num + " is: " + factorial);

    }
}