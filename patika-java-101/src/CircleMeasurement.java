import java.util.Scanner;
public class CircleMeasurement {
    public static void main(String[] args) {
        double pi = 3.14;
        Scanner inp = new Scanner(System.in);
        System.out.print("Radius:");
        int r = inp.nextInt();
        double area = pi*r*r;
        double perimeter = 2*pi*r;
        System.out.println("Area is: " + area);
        System.out.println("Perimeter is: " + perimeter );

    }
}
