package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Instructor {

    private String name;
    private List<Branch> branchList = new ArrayList<>();

    private int age;

    private Sex sex;

    private BigDecimal salary;

    public Instructor(String name, int age, Sex sex, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }
    public void addBranchtToList(Branch branch){ this.branchList.add(branch);}


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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "\n" +
                "Eğitmen İsmi= " + name +
                ",Branş Listesi= " + branchList +
                ", Yaş= " + age +
                ", Cinsiyet= " + sex +
                ", Maaş= " + salary;
    }
}
