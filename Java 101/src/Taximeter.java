import java.util.Scanner;
public class Taximeter {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        double pricePerKm = 2.2;
        double price = 10;
        System.out.print("Distance in km:");
        double distance = inp.nextDouble();
        price += pricePerKm*distance;
        price = price > 20 ? price : 20;
        System.out.println(price);
    }
}
