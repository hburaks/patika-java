import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int year;
        System.out.print("Year: ");
        year = inp.nextInt();
        if(year % 4 == 0){
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}
