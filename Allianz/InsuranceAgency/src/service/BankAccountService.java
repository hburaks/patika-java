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
    public BankAccount getBankAccountWithEnoughMoney(Agency bankAccountOwner , BigDecimal amount) {

        for (BankAccount bankAccount : bankAccountOwner.getBankAccountList()) {
            if (bankAccount.getAmount().compareTo(amount) >= 0) {
                return bankAccount;
            }
        }
        return null;
    }
    public BankAccount getBankAccountWithEnoughMoney(InsuranceCompany bankAccountOwner , BigDecimal amount) {

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
        return bankAccountWithMinMoney;
    }

}
