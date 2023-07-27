package Helper;

import java.util.Random;
import java.util.Scanner;

public class Helper {
    public static int createRandomNum(int min,int max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static boolean yesOrNo() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Y/N: ");
        String answer = inp.nextLine().trim().toUpperCase();

        while (!answer.equals("Y") && !answer.equals("N")) {
            System.out.print("Please answer with 'Y' or 'N': ");
            answer = inp.nextLine().trim().toUpperCase();
        }

        return answer.equals("Y");
    }
}
