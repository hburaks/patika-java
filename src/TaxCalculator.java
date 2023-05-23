import java.util.Scanner;
public class TaxCalculator {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        float taxRate = 0.18F;
        System.out.print("Price:");
        int price = inp.nextInt();
        System.out.println("Without tax: " + price);
        System.out.println("Tax amount: " + price*taxRate);
        System.out.println("Price with tax: " + (price + price*taxRate));
    }
}
