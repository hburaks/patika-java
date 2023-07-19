import java.util.Scanner;

public class Player {
    private String name;
    private Location location = null;
    private Scanner scanner = new Scanner(System.in);
    private CharacterTypes character;

    public Player(String name) {
        this.name = name;
    }

    public void selectChar() {
        CharacterTypes[] characters = { new Samurai(), new Archer(), new Knight() };
        int index = 1;
        for (CharacterTypes character : characters) {
            System.out.println(index + " - Character: " + character.getCharacterName()
                    + "\t Damage: " + character.getDamage()
                    + "\t Health: " + character.getHealth()
                    + "\t Money: " + character.getMoney());
            index++;
        }

        System.out.print("Which character would you like to play with:");
        int selectedChar = scanner.nextInt();
        switch (selectedChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        System.out.println("Character: " + this.character.getCharacterName() + " Damage: " + this.character.getTotalDamage()
                + " Health: " + this.character.getHealth() + " Money: " + this.character.getMoney());
    }

    private void initPlayer(CharacterTypes character) {
        this.character = character;
    }
    public void printCharInfo(){
        System.out.println("Hello " + this.getName());
        System.out.println("Damage :  "+ this.character.getTotalDamage());
        System.out.println("Block :  "+ this.character.getBlock());
        System.out.println("Health :  "+ this.character.getHealth());
        System.out.println("Money :  "+ this.character.getMoney());
        System.out.println("Game is starting. Good Luck!!");
    }

    public void selectLocation() {
        while (true) {
            System.out.println();
            System.out.println("**************************************************************");
            System.out.println("Now choose a zone! ");
            Location[] locations = { new SafeHouse(this), new ToolStore(this),
                    new Cave(this), new Forest(this), new River(this), new Quarry(this)};
            for (Location location : locations) {
                System.out.println("Zone: " + location.getName());
            }
            System.out.print("Please choose: ");
            int noLoc = scanner.nextInt();

            switch (noLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new ToolStore(this);
                    break;
                case 3:
                    location = new Cave(this);
                    break;
                case 4:
                    location = new Forest(this);
                    break;
                case 5:
                    location = new River(this);
                    break;
                case 6:
                    location = new Quarry(this);
                    break;
                default:
                    System.out.println("Not valid region! Going to the safe zone!");
                    location = new SafeHouse(this);
                    break;
            }
            if (location == null) {
                System.out.println("Exiting the game...");
                break;
            } else if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }
    }

    public void isDelete(int choose) {
        if (location.isSelectCombatValue()) {
            System.out.println("All creatures in this area are dead, please choose another area!");

        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public CharacterTypes getCharacter() {
        return character;
    }

    public void setCharacter(CharacterTypes character) {
        this.character = character;
    }
}