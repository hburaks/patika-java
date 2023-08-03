package service;

import java.util.Scanner;

public class LoginInputCollector {
    private Scanner scanner = new Scanner(System.in);

    public String getEmail() {
        System.out.print("Email: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Password: ");
        return scanner.nextLine();
    }
}
