import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("Give the number: ");
            int num = inp.nextInt();
            int sum = 0;
            int j = num-1;
            while (j > 0) {
                if (num % j == 0) {
                    sum += j;
                }
                j--;
            }
            if(sum == num){
                System.out.println("It is a perfect number!!");
            } else {
                System.out.println("It is not a perfect number.");

            }


        }
    }
}
