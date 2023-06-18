import java.util.Scanner;
public class AirplaneTicket {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int distance, age, tripType;
        double tripCost = 0;
        System.out.print("Give the distance(km): ");
        distance = inp.nextInt();
        System.out.print("What is your age: ");
        age = inp.nextInt();
        System.out.print("Trip type (1 => One Way, Round Trip  => 2): ");
        tripType = inp.nextInt();
        if(age < 12){
            tripCost = (distance*0.1)*0.5;
        } else if (age < 24) {
            tripCost = (distance*0.1)*0.9;
        } else if (age<65) {
            tripCost = (distance*0.1)*0.3;            
        }
        
        if(tripType == 2){
            tripCost = (tripCost*2)*0.7;
        }
        System.out.println("Trip cost is " + tripCost + "TL.");
    }
}
