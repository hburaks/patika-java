import java.util.Scanner;

public class LcmHcf {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.print("Give the first number: ");
            int num1 = inp.nextInt();
            System.out.print("Give the second number: ");
            int num2 = inp.nextInt();
            int hcf = 1, lcm;
            int j = num1;
            while (j > 0) {
                if (num1 % j == 0 && num2 % j == 0) {
                    hcf = j;
                    break;
                }
                j--;
            }

            lcm = (num1 * num2) / hcf;
            System.out.println("For " + num1 + " and " + num2 + "; HCF is " + hcf + ", LCM is " + lcm);
        }
    }
}
