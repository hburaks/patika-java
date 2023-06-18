import java.util.Scanner;
public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num, power, result = 1;
        System.out.print("Enter a number: ");
        num = inp.nextInt();
        System.out.print("Enter the power: ");
        power = inp.nextInt();
        if(power > 0){
            for( int i = 1; i <= power; i++){
                result *= num;
            }
        }

        System.out.println(power + " time power of " + num + " is: " + result);

    }
}