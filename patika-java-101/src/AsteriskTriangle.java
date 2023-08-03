import java.util.Scanner;
public class AsteriskTriangle {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = inp.nextInt();
        for(int i = 1; i <= num; i++){
            System.out.println();
            for(int j = num; j > i; j--){
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++){
                if(k == 0){
                    System.out.print("*");
                } else {

                System.out.print("**");
                }
            }
        }
        System.out.println();

    }
}
