import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to adventure game !");
        System.out.print("Player name : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Player " + player.getName() + ". Select the character.");
        player.selectChar();
        player.printCharInfo();
        Location location = null;
        Location[] locations = { new SafeHouse(player), new ToolStore(player),
                new Cave(player), new Forest(player), new River(player), new Quarry(player)};

        while (true) {
            System.out.println("0 - Player Info ");
            int i = 1;
            for (Location location1 : locations) {
                System.out.println( i + " - " + location1.getName());
                i++;
            }
            System.out.print("Select the place you want to go : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    player.printCharInfo();
                    break;
                case 1:
                    location = locations[0];
                    break;
                case 2:
                    location = locations[1];
                    break;
                case 3:
                    location = locations[2];
                    break;
                case 4:
                    location = locations[3];
                    break;
                case 5:
                    location = locations[4];
                    break;
                case 6:
                    location = locations[5];
                    break;
                default:
                    System.out.println("Please select from the options");
            }
                if(!location.onLocation()){
                    System.out.println("Game OVER!!!");
                    break;
                }
        }
    }
}