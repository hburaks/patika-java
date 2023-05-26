import java.util.Scanner;
public class ChineseZodiac {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int birthYear;
        String chineseZodiac;
        System.out.print("Birth Year: ");
        birthYear = inp.nextInt();
        switch (birthYear % 12){
            case 0 : {
                chineseZodiac = "Monkey";
                System.out.println(chineseZodiac);
                break;
            } case 1 : {
                chineseZodiac = "Cockerel";
                System.out.println(chineseZodiac);
                break;
            } case 2 : {
                chineseZodiac = "Dog";
                System.out.println(chineseZodiac);
                break;
            } case 3 : {
                chineseZodiac = "Pig";
                System.out.println(chineseZodiac);
                break;
            } case 4 : {
                chineseZodiac = "Mouse";
                System.out.println(chineseZodiac);
                break;
            } case 5 : {
                chineseZodiac = "Ox";
                System.out.println(chineseZodiac);
                break;
            } case 6 : {
                chineseZodiac = "Tiger";
                System.out.println(chineseZodiac);
                break;
            } case 7 : {
                chineseZodiac = "Rabbit";
                System.out.println(chineseZodiac);
                break;
            } case 8 : {
                chineseZodiac = "Dragon";
                System.out.println(chineseZodiac);
                break;
            } case 9 : {
                chineseZodiac = "Snake";
                System.out.println(chineseZodiac);
                break;
            }case 10 : {
                chineseZodiac = "Horse";
                System.out.println(chineseZodiac);
                break;
            }case 11 : {
                chineseZodiac = "Sheep";
                System.out.println(chineseZodiac);
                break;
            } default: {
                System.out.print("Wrong input!");
            }

        }

    }
}
