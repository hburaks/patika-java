import java.util.Scanner;
import java.util.ArrayList;


public class CreateFixture {

    public int getTeamCount() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Ligde kaç takım olacağını belirtiniz : ");
        int teamCount = inp.nextInt();
        if (teamCount > 0) {
            return teamCount;
         }
        else{
            return getTeamCount();
        }
    }
    public int createRandom(int max){
        return (int) (Math.random()*max);

    }
    public ArrayList<String> createTeamList(int count){
        Scanner inp = new Scanner(System.in);

        ArrayList<String> teamList = new ArrayList<>();
        while(count > 0){
            System.out.print("Takım ismi giriniz : ");
            teamList.add(inp.next());
            count--;
        }
        return teamList;
    }
    public void run(){
        Scanner inp = new Scanner(System.in);
        int teamCount = getTeamCount();
        ArrayList<String> teamList = createTeamList(teamCount);

        if(teamCount % 2 ==1){
            teamList.add("Bay");
        }
        System.out.println("Takım sayısı : " + teamCount);
        int weekNum = 1;
        while(teamList.size()> 0){
            int random = createRandom(teamList.size());
            System.out.print(weekNum +". hafta eşleşmesi : "+ teamList.get(random));
            teamList.remove(random);
            int random2 = createRandom(teamList.size());
            System.out.print(" vs "+ teamList.get(random2));
            teamList.remove(random2);
            System.out.println();
        }

    }
}