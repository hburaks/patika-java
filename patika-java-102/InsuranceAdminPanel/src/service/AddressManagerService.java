package service;

import model.Address;
import model.User;

import java.util.ArrayList;

public class AddressManagerService {
    public void addAddressToUser(User user, Address address ){
        if(user.getAddressList() == null){
            user.setAddressList(new ArrayList<Address>());
        }
        user.getAddressList().add(address);
    }
    public void subtractAddressFromUser(User user, Address address){
        user.getAddressList().remove(address);
    }


}
