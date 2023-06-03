import java.util.Scanner;
public class HarmonicSum {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num;
        double sum = 0;
        System.out.print("Enter a number: ");
        num = inp.nextInt();
        for( double i = 1; i <= num; i++){
            sum += (1/i);
        }
        System.out.println("Total is: " + sum);
    }
}
