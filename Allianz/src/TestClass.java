import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 5;



       // tipi belli bir objeye atamaya çalışırken parantez içinde tanımlamak gerekiyor

       ArrayList<String> studentList = new ArrayList<>();
       ArrayList<Integer> studentAgeList = new ArrayList<>();

       studentList.add("Ayşe");
       studentList.add("Mehmet");
       studentList.add("Mert");
       studentList.add("Mahmut");
       studentList.add("Elif");
       studentList.add("Ömer");
       studentList.add("Ali");
       studentList.add("Hasan");
       studentList.add("Burak");
       studentList.add("Kerim");

       studentAgeList.add(10);
       studentAgeList.add(20);
       studentAgeList.add(25);
       studentAgeList.add(17);
       studentAgeList.add(23);
       studentAgeList.add(22);
       studentAgeList.add(13);
       studentAgeList.add(17);
       studentAgeList.add(13);
       studentAgeList.add(21);
/*
        for(int i = 0; i < studentList.size(); i++){
            if(studentAgeList.get(i) >= 18){
                System.out.println(studentList.get(i) + " yaşı 18'den büyüktür.");
            } else {
                System.out.println(studentList.get(i) + " yaşı 18'den küçüktür.");
            }
        }
*/

        Map<String, Integer> studentWithAge = new HashMap<>();
        for(int i = 0; i < studentList.size(); i++){
            studentWithAge.put(studentList.get(i), studentAgeList.get(i));
        }

        for (String student : studentWithAge.keySet()) {
            int age = studentWithAge.get(student);
            if (age >= 18) {
                System.out.println(student + " yaşı 18'den büyüktür.");
            } else {
                System.out.println(student + " yaşı 18'den küçüktür.");
            }
        }

    }

    public static void writeNumberOnWhileLoop( int num1, int num2){
        while(num2 > num1){
            System.out.println("num2 > num1");
            num2--;
        }
        System.out.println("not anymore");

    }

    public static void writeNumbersOnForLoop(int num1, int num2){
        for(int i = num1; i< num2; i++){
            System.out.println("Hi for " + (num2 - num1)  + " times");
        }
    }
}