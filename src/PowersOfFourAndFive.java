import java.util.Scanner;
public class PowersOfFourAndFive {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Give number: ");
        int num;
        num= inp.nextInt();
        for(int i = 1 ; i <= num; i*= 4) {
            System.out.println(i);
        }
        for(int i = 1 ; i <= num; i*= 5) {
            System.out.println(i);
        }

    }
}
