package service;

import model.Account;
import model.User;

import java.util.TreeSet;

class InvalidAuthenticationException extends Exception {
    public InvalidAuthenticationException(String message) {
        super(message);
    }
}

public class AccountManagerService {
    TreeSet<Account> accountList = new TreeSet<>();

    public void addAccount(Account account) {
        accountList.add(account);
    }
    public class InvalidAuthenticationException extends Exception {
        public InvalidAuthenticationException(String message) {
            super(message);
        }
    }
    public Account login(String email, String password) throws InvalidAuthenticationException {
        for (Account account : accountList) {
            User user = account.getUser();
            if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                try {
                    account.login(email, password, user);
                    return account;
                } catch (Account.InvalidAuthenticationException e) {
                }
            }
        }
        throw new InvalidAuthenticationException("Invalid email or password");
    }
}
