import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num, digitCount = 1, total = 0;
        System.out.print("Enter a number to control if it is Armstrong Number: ");
        num = inp.nextInt();
        int i = num;
        if(i != 0){
            while(i / 10 != 0){
                digitCount++;
                i /= 10;
            }
        }
        for (int j = num ; j > 0; j /= 10){
            int digitValue = j % 10 , l = digitValue;
            for(int k = digitCount; k > 0; k--){
                if(k > 1){
                    digitValue *= l;
                }
            }
            total += digitValue;
        }
        if(total == num){
            System.out.println("It is an Armstrong Number!!");
            System.out.println("Total and number is: " + total);
        }else {
            System.out.println("It is not an Armstrong Number.");
            System.out.println("Total is: " + total);
            System.out.println("Entered number is: " + num);
        }
    }
}
