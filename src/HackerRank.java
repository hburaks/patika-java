import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);


            System.out.println("n");
            int a = in.nextInt();
            System.out.println("n");

            int b = in.nextInt();
            System.out.println("n");

            int n = in.nextInt();

        in.close();
        for(int i = 0; i < n; i++){
            int s = 0;
            // a baştaki toplama sayısı, b üzeri alınacak sayı, n kaç kere üstü alınacak
            int k = b;
            s = a + k;
            for(int j = 0; j < i; j++){
                k *= 2;
            }
         System.out.print(s + " ");
        }
    }
}