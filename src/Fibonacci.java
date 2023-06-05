import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = inp.nextInt();
        int numBefore = 0;
        int numCurrent = 1;
        int numAfter;
        while(numBefore <= num){
            System.out.println(numBefore);
            numAfter = numBefore + numCurrent;
            numBefore = numCurrent;
            numCurrent = numAfter;
        }
    }
}
