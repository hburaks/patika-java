import java.util.Scanner;

public class MinMaxNums {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Count of the numbers: ");
        int count = inp.nextInt();
        int highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        for(int i = 1 ; i <= count; i++){
            System.out.println("Give the " + i + ". number: ");
            int num = inp.nextInt();
            if(num > highest){
                highest = num;
            }
            if(num < lowest){
                lowest = num;
            }
        }
        System.out.println("The highest number is: " + highest);
        System.out.println("The lowest number is: " + lowest);
    }
}