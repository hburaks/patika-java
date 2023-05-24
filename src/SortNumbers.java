import java.util.Scanner;
public class SortNumbers {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("First number:");
        int firstNumber= inp.nextInt();
        System.out.print("Second number:");
        int secondNumber= inp.nextInt();
        System.out.print("Third number:");
        int thirdNumber= inp.nextInt();
        if(firstNumber> secondNumber && firstNumber > thirdNumber){
            if(secondNumber > thirdNumber){
                System.out.println("First Number > Second Number > Third Number");
            } else {
                System.out.println("First Number > Third Number > Second Number");
            }
        } else if(secondNumber> firstNumber && secondNumber > thirdNumber){
            if(firstNumber > thirdNumber){
                System.out.println("Second Number > First Number > Third Number");
            } else {
                System.out.println("Second Number > Third Number > First Number");
            }
        }else if(thirdNumber> firstNumber && thirdNumber > secondNumber){
            if(firstNumber > secondNumber){
                System.out.println("Third Number > First Number > Second Number");
            } else {
                System.out.println("Third Number > Second Number > First Number");
            }
        } else {
            System.out.println("You should give different numbers");
        }

    }
}
