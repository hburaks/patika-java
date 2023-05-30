import java.util.Scanner;
public class EvenNumbers {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Give number: ");
        int num= inp.nextInt();
        for(int i = 1;i <= num; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
