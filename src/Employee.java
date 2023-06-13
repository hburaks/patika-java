public class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;
    public Employee(String name, int salary,int workHours,int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    public double tax() {
        if (this.salary <= 1000) {
            return 0;
        } else {
            return this.salary * 0.03;
        }
    }
    public int bonus() {
        if (this.workHours >  40) {
            return (this.workHours - 40)*30;
        } else {
            return 0;
        }
    }
    public double raiseSalary() {
        if (2021 - this.hireYear <  10) {
            return this.salary*0.05;
        } else if (2021 - this.hireYear >=  10 && 2021 - this.hireYear < 20) {
            return this.salary*0.1;
        } else if (2021 - this.hireYear >=  20) {
            return this.salary*0.15;
        } else {
            return 0;
        }
    }
    public double getTotalSalary() {
        return salary + bonus() - tax();
    }
    public String toString() {
        return "Adı: " + name +
                "\nMaaşı: " + salary +
                "\nÇalışma Saati: " + workHours +
                "\nBaşlangıç Yılı: " + hireYear +
                "\nVergi: " + tax() +
                "\nBonus: " + bonus() +
                "\nMaaş Artışı: " + raiseSalary() +
                "\nVergi ve Bonuslar ile birlikte maaş: " + getTotalSalary() +
                "\nToplam Maaş: " + (salary + raiseSalary());
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Kemal", 2000, 45, 1985);
        System.out.println(employee.toString());
    }


}