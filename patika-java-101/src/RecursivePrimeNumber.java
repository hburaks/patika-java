import java.util.Scanner;

public class RecursivePrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if(number == 1){
            System.out.println(number + " is not a prime number.");
        } else if (number == 0) {
            System.out.println("Can not continue with this number.");
        } else if (isPrime(number, number - 1)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
    public static boolean isPrime(int number, int divisor) {
        if (divisor == 1) {
            return true;
        } else if (number % divisor == 0) {
            return false;
        } else {
            return isPrime(number, divisor - 1);
        }
    }
}