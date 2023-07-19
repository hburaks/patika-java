package model;

public class BusinessAddress implements Address {
    private String businessAddress;
    private int doorNo;
    @Override
    public String getAddress() {
        return this.businessAddress;
    }

    @Override
    public int getDoorNo() {
        return this.doorNo;
    }

    @Override
    public void setAddress(String address) {
        this.businessAddress = address;
    }

    @Override
    public void setDoorNo(int doorNo) {
        this.doorNo = doorNo;
    }

    @Override
    public String toString() {
        return "BusinessAddress{" +
                "businessAddress='" + businessAddress + '\'' +
                ", doorNo=" + doorNo +
                '}';
    }
}
