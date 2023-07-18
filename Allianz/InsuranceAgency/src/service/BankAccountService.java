package service;

import model.Agency;
import model.BankAccount;
import model.Customer;
import model.InsuranceCompany;

import java.math.BigDecimal;

public class BankAccountService {
    public BankAccount createBankAccount(String bankName, String iban, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setName(bankName);
        bankAccount.setIban(iban);
        bankAccount.setAmount(amount);
        return bankAccount;
    }


    public BankAccount getBankAccountWithEnoughMoney(Customer bankAccountOwner, BigDecimal amount) {

        for (BankAccount bankAccount : bankAccountOwner.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }
    public BankAccount getBankAccountToSendMoney(Customer bankAccountOwner){
        BigDecimal amount = BigDecimal.valueOf(0);
        BankAccount bankAccountWithMinMoney = null;
        for (BankAccount bankAccount : bankAccountOwner.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) > 0) {
                bankAccountWithMinMoney = bankAccount;
                amount = bankAccountWithMinMoney.getAmount();
            }
        }
        if(bankAccountWithMinMoney == null){
            System.err.println("Bank Account could not found");
        }
        return bankAccountWithMinMoney;
    }
    public BankAccount getBankAccountToSendMoney(Agency bankAccountOwner){
        BigDecimal amount = BigDecimal.valueOf(0);
        BankAccount bankAccountWithMinMoney = null;
        for (BankAccount bankAccount : bankAccountOwner.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) > 0) {
                bankAccountWithMinMoney = bankAccount;
                amount = bankAccountWithMinMoney.getAmount();
            }
        }
        if(bankAccountWithMinMoney == null){
            System.err.println("Bank Account could not found");
        }
        return bankAccountWithMinMoney;
    }
    public BankAccount getBankAccountToSendMoney(InsuranceCompany bankAccountOwner){
        BigDecimal amount = BigDecimal.valueOf(0);
        BankAccount bankAccountWithMinMoney = null;
        for (BankAccount bankAccount : bankAccountOwner.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) > 0) {
                bankAccountWithMinMoney = bankAccount;
                amount = bankAccountWithMinMoney.getAmount();
            }
        }
        if(bankAccountWithMinMoney == null){
            System.err.println("Bank Account could not found");
        }
        return bankAccountWithMinMoney;
    }
    public void sendMoneyToAccount(BankAccount account, BigDecimal amount){
        account.setAmount(account.getAmount().add(amount));
    }
    public void getMoneyFromAccount(BankAccount account, BigDecimal amount){
        account.setAmount(account.getAmount().subtract(amount));
    }

}
