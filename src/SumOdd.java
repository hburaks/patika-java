import java.util.Scanner;
public class SumOdd {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Give number: ");
        int num, sum = 0;
        num= inp.nextInt();
        for(int i = 1;i <= num; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println("Sum is: " + sum);
    }
}
