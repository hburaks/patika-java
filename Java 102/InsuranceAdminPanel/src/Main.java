import model.*;
import service.AccountManagerService;
import service.AddressManagerService;
import service.LoginInputCollector;

public class Main {
    public static void main(String[] args) {
        AddressManagerService addressManagerService = new AddressManagerService();
        User user = new User();
        BusinessAddress businessAddress = new BusinessAddress();
        HomeAddress homeAddress = new HomeAddress();
        AccountManagerService accountManager = new AccountManagerService();
        LoginInputCollector inputCollector = new LoginInputCollector();
        addressManagerService.addAddressToUser(user, homeAddress);
        addressManagerService.addAddressToUser(user, businessAddress);
        addressManagerService.subtractAddressFromUser(user, homeAddress);
        user.showUserInfo();
        user.showLoginStatus(user);



        String email = inputCollector.getEmail();
        String password = inputCollector.getPassword();

        try {
            Account loggedInAccount = accountManager.login(email, password);
            System.out.println("Logged in: " + loggedInAccount.toString());
        } catch (AccountManagerService.InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
        }

    }
}