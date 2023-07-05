import java.util.*;

public class School {
    public static void main(String[] args) {
        HashSet<HashSet<String>> classRooms = new HashSet<>();

        HashSet<String> classroomA = new HashSet<>();
        classroomA.add("Hasan Burak Songur");
        classroomA.add("Yamaç Bayın");
        classroomA.add("Mertcan Aslan");
        classroomA.add("Mevlüt İzmirli");
        classroomA.add("Emine Aköz");

        HashSet<String> classroomB = new HashSet<>();
        classroomB.add("Yunuscan Ünal");
        classroomB.add("Cem Karakuş");
        classroomB.add("Kazım Ahmet Uzun");
        classroomB.add("Kaan Güven");
        classroomB.add("Ömer Faruk Tokluoğlu");

        HashSet<String> classroomC = new HashSet<>();
        classroomC.add("Mustafa Serhat Demirtaş");
        classroomC.add("Mehmet Cemalettin Uyanık");
        classroomC.add("Orbay Kahraman");
        classroomC.add("Can Bayazit");
        classroomC.add("Aslıhan Hasar");

        classRooms.add(classroomA);
        classRooms.add(classroomB);
        classRooms.add(classroomC);


        for (HashSet<String> classroom : classRooms) {
            for (String student : classroom) {
                String[] nameList  = student.split(" ");
                for(int i = 0 ; i < nameList.length -1; i++){
                    if (nameList[i].endsWith("an")) {
                        System.out.println("İsmi 'an' ile biten öğrenci: " + student);
                    }
                }
            }
        }
    }
}