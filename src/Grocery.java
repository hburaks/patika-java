import java.util.Scanner;
public class Grocery {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        double pear = 2.14, apple = 3.67, tomato = 1.11, banana = 0.95, eggplant = 5;
        System.out.print("Pear in kg: ");
        pear *= inp.nextDouble();
        System.out.print("Apple in kg: ");
        apple *= inp.nextDouble();
        System.out.print("Tomato in kg: ");
        tomato *= inp.nextDouble();
        System.out.print("Banana in kg: ");
        banana *= inp.nextDouble();
        System.out.print("Eggplant in kg: ");
        eggplant *= inp.nextDouble();



        double totalPrice = pear + apple + tomato + banana + eggplant;
        System.out.println("Total price is " + totalPrice);
    }
}
