package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DanceCourse {

    private String name;

    private String address;

    private String founder;

    private String taxNumber;

    private String taxOffice;

    private List<BankAccount> bankAccountList;

    private BigDecimal totalAmount;

    private List<PaymentMovement> paymentMovementList;

    private List<Instructor> instructorList;

    private List<Student> studentList;
    private List<Branch> branchList;
    private List<Lecture> lectureList;
    private int capacity = 20;
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

    public List<PaymentMovement> getPaymentMovementList() {
        if(paymentMovementList == null){
            paymentMovementList = new ArrayList<>();
        }
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

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Course {" + '\n' +
                "Name= " + name + '\n' +
                "Adress= " + address + '\n' +
                "Founder= " + founder + '\n' +
                "Banka Hesapları= " + bankAccountList + '\n' +
                "Eğitmen Listesi= " + instructorList + '\n' +
                "Branch List= " + branchList + '\n' +
                '}';
    }


    public String toStringAdminEducation() {
        return "Kurs {" + "\n" +
                "Name= " + name + "\n" +
                "Adress= " + address + "\n" +
                "Founder= " + founder + "\n" +
                "Instructor List= " + instructorList + "\n" +
                "Student List= " + studentList + "\n" +
                "Branch List= " + branchList + '\n' +
                "Lecture List= " + lectureList + '\n' +
                "Total Capacity= " + capacity + '\n' +
                '}';
    }

    public String toStringAdminFinancial() {
        return "Kurs {" + '\n' +
                "Name= " + name + '\n' +
                "Tax No= " + taxNumber + '\n' +
                "Tax Office= " + taxOffice + '\n' +
                "Bank Accounts= " + bankAccountList + '\n' +
                "Total Amount= " + totalAmount + '\n' +
                "Payment Movements= " + paymentMovementList + '\n' +
                "Instructor List= " + instructorList + '\n' +
                "Student List= " + studentList + '\n' +
                '}';
    }
}
