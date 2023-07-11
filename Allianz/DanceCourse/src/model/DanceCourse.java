package model;

import java.util.ArrayList;
import java.util.List;

public class DanceCourse {

    private String name;

    private String address;

    private String founder;

    private String taxNumber;

    private String taxOffice;

    private List<BankAccount> bankAccountList = new ArrayList<>();

    private List<PaymentMovement> paymentMovementList;

    private List<Instructor> instructorList;

    private List<Student> studentList;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }
    public void addBankAccountToList(BankAccount bankAccount){ this.bankAccountList.add(bankAccount);}

    public List<PaymentMovement> getPaymentMovementList() {
        return paymentMovementList;
    }

    public void setPaymentMovementList(List<PaymentMovement> paymentMovementList) {
        this.paymentMovementList = paymentMovementList;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    @Override
    public String toString() {
        return "Kurs {" + '\n' +
                "İsim= " + name + '\n' +
                "Adres= " + address + '\n' +
                "Kurucu= " + founder + '\n' +
                "Banka Hesapları= " + bankAccountList + '\n' +
                "Eğitmen Listesi= " + instructorList + '\n' +
                '}';
    }


    public String toStringAdminEducation() {
        return "Kurs {" + "\n" +
                "İsim= " + name + "\n" +
                "Adres= " + address + "\n" +
                "Kurucu= " + founder + "\n" +
                "Eğitmen Listesi= " + instructorList + "\n" +
                "Öğrenci Listesi= " + studentList + "\n" +
                '}';
    }

    public String toStringAdminFinancial() {
        return "Kurs {" + '\n' +
                "İsim= " + name + '\n' +
                "Vergi No= " + taxNumber + '\n' +
                "Vergi Dairesi= " + taxOffice + '\n' +
                "Banka Hesapları= " + bankAccountList + '\n' +
                "Banka Hareketleri= " + paymentMovementList + '\n' +
                "Eğitmen Listesi= " + instructorList + '\n' +
                "Öğrenci Listesi= " + studentList + '\n' +
                '}';
    }
}
