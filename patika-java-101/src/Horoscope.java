import java.util.Scanner;
public class Horoscope {
    public static void main(String[] args) {
        int month, day;
        boolean isError = false;
        Scanner inp = new Scanner(System.in);
        System.out.print("Birth month:");
        month = inp.nextInt();
        System.out.print("Birth day:");
        day = inp.nextInt();
        switch (month){
            case 1:
                if(day < 22){
                    System.out.println("Capricorn");
                } else if (day>=22 && day<32) {
                    System.out.println("Aquarius");
                }
                break;
            case 2 :
                if(day < 22){
                System.out.println("Aquarius");
            } else if (day>=22 && day<29) {
                System.out.println("Pisces");
            }
            break;
            default:
                isError = true;
        }
        if(isError){
            System.out.println("Wrong date");
        }

    }
}
