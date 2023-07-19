package model;

public class HomeAddress implements Address {
    private String homeAddress;
    private int doorNo;
    @Override
    public String getAddress() {
        return this.homeAddress;
    }

    @Override
    public int getDoorNo() {
        return this.doorNo;
    }

    @Override
    public void setAddress(String address) {
        this.homeAddress = address;
    }

    @Override
    public void setDoorNo(int doorNo) {
        this.doorNo = doorNo;
    }

    @Override
    public String toString() {
        return "HomeAddress{" +
                "homeAddress='" + homeAddress + '\'' +
                ", doorNo=" + doorNo +
                '}';
    }
}
