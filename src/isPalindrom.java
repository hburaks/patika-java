import java.util.Scanner;

public class isPalindrom {
    static boolean isPalindrom(int number){
        int temp = number, reverseNumber = 0, lastNumber;
        while(temp != 0){
            lastNumber = temp % 10;
            reverseNumber = reverseNumber*10 + lastNumber;
            temp /= 10;
        }
        return reverseNumber == number;
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = inp.nextInt();
        System.out.println(isPalindrom(a));
    }

}
