package model;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {
    private User user;
    private ArrayList<Insurance> InsuranceList;
    private AuthenticationStatusEnum authenticationStatus = AuthenticationStatusEnum.FAIL;
     public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsuranceList() {
        return InsuranceList;
    }

    public void setInsuranceList(ArrayList<Insurance> insuranceList) {
        InsuranceList = insuranceList;
    }

    public AuthenticationStatusEnum getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(AuthenticationStatusEnum authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public final void showUserInfo(){
        System.out.println(toString());
    }
    public class InvalidAuthenticationException extends Exception {
        public InvalidAuthenticationException(String message) {
            super(message);
        }
    }
    public void login(String email, String password,User user) throws InvalidAuthenticationException {
        if (user == null || !user.getEmail().equals(email)) {
            throw new InvalidAuthenticationException("Invalid email or password");
        }
        if (user == null || !user.getPassword().equals(password)) {
            throw new InvalidAuthenticationException("Invalid email or password");
        }

        user.setAuthenticationStatus(AuthenticationStatusEnum.SUCCESS);
    }

    public void showLoginStatus(User user){
        System.out.println( user.getName() + " login status : " +authenticationStatus);
    }
    abstract void addInsurance(User user, Insurance insurance);
    @Override
    public String toString() {
        return "Account{" +
                "user=" + user +
                ", InsuranceList=" + InsuranceList +
                ", authenticationStatus=" + authenticationStatus +
                '}';
    }
    @Override
    public int compareTo(Account other) {
        return this.getUser().getEmail().compareTo(other.getUser().getEmail());
    }

    // Override hashCode() and equals() for proper handling in collections
    @Override
    public int hashCode() {
        return Objects.hash(getUser().getEmail());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        return Objects.equals(getUser().getEmail(), other.getUser().getEmail());
    }

};



//
//        kullanıcının hesabına login olabilmesi için bir fonksiyon tanımlanacaktır. Bu fonksiyon email ve şifre bilgisi alacak ve gelen email şifre bilgisini User sınıfındaki email ve şifre ile kıyaslayacaktır. Eğer girilen bilgiler doğruysa giriş işlemi başarılı olacaktır. Ve kullanıcının login olma durumu SUCCESS'e çekilecektir. Giriş işlemi başarısız ise "InvalidAuthenticationException" tipinde bir hata fırlatacaktır. Bu hata sınıfını Exception isimli Java sınıfından kalıtım alarak sizin yazmanız gerekecektir.
//
//
//        kullanıcının adreslerine ekleme yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır. kullanıcının adreslerinden çıkartma yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır. kullanıcının login olma durumunu veren değer döndüren fonksiyon tanımlanacaktır.
//
//
//        kullanıcının sigorta poliçesi ekleyebilmesi için soyut (abstract) bir fonksiyon tanımlanacaktır. Bu soyut sınıf "Individual" ve "Enterprise" isimli alt sınıflarda override edilerek doldurulacaktır. Çünkü, bireysel ve kurumsal müşterilerin ekledikleri paketlerin fiyatlarına uygulanan kar marjı farklı olacaktır.
