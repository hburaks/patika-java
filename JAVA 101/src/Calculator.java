import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n1,n2,select;
        System.out.print("First number:");
        n1 = inp.nextInt();
        System.out.print("Second number:");
        n2 = inp.nextInt();

        System.out.print("Choose the operator:\n1- Add\n2- Subtract \n3- Multiply\n4-Divide");
        System.out.print("What is your choice? Give the number:");
        select = inp.nextInt();

        switch (select){
            case 1 :
                System.out.println(n1+n2);
                break;
            case 2 :
                System.out.println(n1-n2);
                break;
            case 3 :
                System.out.println(n1*n2);
                break;
            case 4 :
                if(n2 != 0){
                    System.out.println(n1/n2);
                } else {
                    System.out.println("Number 2 is not greater than 0.");
                }
            default:
                System.out.println("No num given");
        }

    }
}
