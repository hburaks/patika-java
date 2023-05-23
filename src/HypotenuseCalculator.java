import java.util.Scanner;
public class HypotenuseCalculator {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int firstEdge ,secondEdge;
        double hypotenuse;
        System.out.print("First edge length:");
        firstEdge = inp.nextInt();
        System.out.print("Second edge length:");
        secondEdge = inp.nextInt();
        hypotenuse = Math.sqrt(firstEdge*firstEdge + secondEdge*secondEdge);
        System.out.print("Hypotenuse length is: "+hypotenuse);
    }
}
