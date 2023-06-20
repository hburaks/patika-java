import java.util.Scanner;
import java.util.ArrayList;


public class FixtureGenerator {

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
    public void addBayCondition(int teamCount, ArrayList teamList){
        if(teamCount % 2 ==1){
            teamList.add("Bay");
        }
    }
    public boolean hasValidPair(ArrayList<ArrayList<String>> leagueMatrix, ArrayList<String> teamList, int random, int random2) {
        for (ArrayList<String> team : leagueMatrix) {
            if (team.contains(teamList.get(random2))) {
                return false;
            }
        }
        return true;
    }

    public void run(){
        Scanner inp = new Scanner(System.in);
        int teamCount = getTeamCount();
        System.out.println("Takım sayısı : " + teamCount);

        ArrayList<String> teamList = createTeamList(teamCount);

        addBayCondition(teamCount,teamList);

        int roundCount = teamList.size() - 1;
        ArrayList<ArrayList<String>> leagueMatrix = new ArrayList<>();
        for(String teamName : teamList){
            ArrayList<String> team = new ArrayList<>();
            leagueMatrix.add(team);
        }

        for(int weekNum = 1; weekNum <= roundCount; weekNum++){
            ArrayList<String> teamListCopy = new ArrayList<>();
            teamListCopy.addAll(teamList);
            while(teamListCopy.size() > 0){
                int random = createRandom(teamListCopy.size());
                System.out.print(weekNum +". hafta eşleşmesi : "+ teamListCopy.get(random));

                //leagueMatrix.get(random).add(teamListCopy.get(random).toString());
                teamListCopy.remove(random);
                int random2 = createRandom(teamListCopy.size());
                boolean validPair = hasValidPair(leagueMatrix, teamList, random, random2);
                while(!validPair){
                    random2 = createRandom(teamListCopy.size());
                    validPair = hasValidPair(leagueMatrix,  teamList, random, random2);
                }
                if (validPair) {
                    System.out.print(" vs "+ teamListCopy.get(random2));
                    /*
                    leagueMatrix.get(random).add(teamListCopy.get(random2).toString());
                    leagueMatrix.get(random).add(teamListCopy.get(random).toString());
                    leagueMatrix.get(random2).add(teamListCopy.get(random).toString());
                    leagueMatrix.get(random2).add(teamListCopy.get(random2).toString());
*/
                    teamListCopy.remove(random2);
                    System.out.println();
                    System.out.println(leagueMatrix.toString());
                }}
        }



    }

}