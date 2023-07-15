package service;

import model.BankAccount;
import model.DanceCourse;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankAccountService {
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
        BankAccount bankAccount = createBankAccount(bankName,companyName,ibanNo, amount);
        DanceCourseService.createBankAccountToDanceCourse(danceCourse, bankAccount);
        return danceCourse;
    }
    public static BankAccount createBankAccount(String bankName, String companyName, String iban, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankName(bankName);
        bankAccount.setCompanyName(companyName);
        bankAccount.setIbanNo(iban);
        bankAccount.setAmount(amount);
        return bankAccount;
    }


    public static BankAccount getBankAccountWithEnoughMoney(DanceCourse danceCourse, BigDecimal amount) {

        for (BankAccount bankAccount : danceCourse.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }
    public static BankAccount getBankAccountToSendMoney(DanceCourse danceCourse){
        BigDecimal amount = BigDecimal.valueOf(0);
        BankAccount bankAccountWithMinMoney = null;
        for (BankAccount bankAccount : danceCourse.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) > 0) {
                bankAccountWithMinMoney = bankAccount;
                amount = bankAccountWithMinMoney.getAmount();
            }
        }
        return bankAccountWithMinMoney;
    }

    public static BigDecimal getTotalBankAccountAmount(DanceCourse danceCourse){
        if(danceCourse.getTotalAmount() != null){
            return danceCourse.getTotalAmount();
        }else {
            return BigDecimal.valueOf(0);
        }
    }
}
