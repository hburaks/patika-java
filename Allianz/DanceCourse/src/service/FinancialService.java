package service;

import model.BankAccount;
import model.DanceCourse;

import java.math.BigDecimal;
import java.util.Scanner;

public class FinancialService {
    public static DanceCourse createNewBankAccount(DanceCourse danceCourse) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Banka ismini giriniz: ");
        String bankName = inp.nextLine();
        System.out.print("IBAN no giriniz: ");
        String ibanNo = inp.nextLine();
        System.out.print("Şirket ismini giriniz: ");
        String companyName = inp.nextLine();
        System.out.print("Bakiyeyi giriniz: ");
        BigDecimal amount = inp.nextBigDecimal();
        BankAccount bankAccount = new BankAccount(bankName, ibanNo, companyName, amount);
        danceCourse.addBankAccountToList(bankAccount);
        return danceCourse;
    }
}
