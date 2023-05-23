import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String userName, password;

        System.out.print("User ID:");
        userName = inp.nextLine();
        System.out.print("User password:");
        password = inp.nextLine();
        if(userName.equals("hburaks") && password.equals("123hbs")){
            System.out.println("Login successful");
        } else{
            System.out.println("Wrong password or ID!");
        }
    }
}
