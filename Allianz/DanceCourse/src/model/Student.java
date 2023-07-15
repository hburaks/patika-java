package model;

import java.math.BigDecimal;
import java.util.Date;

public class Student {

    private String name;
    private int age;

    private Sex sex;

    private boolean isPaid = Boolean.FALSE;

    private BigDecimal contractAmount;

    private Date startDate;

    private Date endDate;
    public Student() {
    }
    public Student(String name, int age, Sex sex, BigDecimal contractAmount) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.contractAmount = contractAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Öğrenci{" +
                "İsim='" + name + '\'' +
                ", Yaş=" + age +
                ", Cinsiyet=" + sex +
                ", Ödeme Durumu=" + isPaid +
                ", Kontrat Ücreti =" + contractAmount +
                ", startDate=" + startDate +
                ", Bitiş Tarihi=" + endDate +
                '}';
    }
}
