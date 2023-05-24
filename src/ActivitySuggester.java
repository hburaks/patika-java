import java.util.Scanner;
public class ActivitySuggester {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("What is the temperature?");
        int temperature = inp.nextInt();
        if(temperature < 5){
            System.out.println("Go skiing");
        } else if (temperature <25) {
            if (temperature < 15){
                System.out.println("Go to cinema");
            }
            if (temperature > 10){
                System.out.println("Go to picnic");
            }
        } else {
            System.out.println("Go swimming");
        }
    }
}
