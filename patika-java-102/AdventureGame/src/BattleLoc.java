import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    Scanner inp = new Scanner(System.in);
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }

    @Override
    boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Current Location : " + this.getName());
        if (this.getSelectCombatValue() == true) {
            System.out.println("It is already cleared. No award to gain or no enemy to defeat");
            return true;
        }
        System.out.println("Be careful! There is " + obsNumber + " " + this.getObstacle().getName() + " inside !");
        System.out.println("<F>ight or <R>un");
        String selectCase = inp.nextLine().toUpperCase();
        while ((!selectCase.equals("F") && !selectCase.equals("R"))) {
            System.out.print("'F' for Fight or 'R' for Run : ");
            selectCase = inp.nextLine().toUpperCase();
        }
        if (selectCase.equals("F")) {
            System.out.println("Let the fight begin...");
            return combat(obsNumber);
        } else if (selectCase.equals("R")) {
            this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getHealth() - this.getObstacle().getDamage());
            System.out.println("Running away with some damage");
            return true;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        Random random = new Random();
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());

            obstacleStatus(i);
            playerStats();

            while (this.getPlayer().getCharacter().getHealth() > 0
                    && this.getObstacle().getHealth() > 0) {
                int priority = random.nextInt(2);

                System.out.println("<H>it or <R>un");
                String selectCase = scanner.nextLine().toUpperCase();
                while ((!selectCase.equals("H") && !selectCase.equals("R"))) {
                    System.out.println("<H>it or <R>un");
                    selectCase = inp.nextLine().toUpperCase();
                }

                if (selectCase.equals("H")) {
                    if (priority == 0) {
                        System.out.println("You hit it! Priority is yours!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth()
                                - this.getPlayer().getCharacter().getTotalDamage());
                        afterHit(i);
                    } else {
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println(this.getObstacle().getName() + " hit you. Enemy had the priority! ");
                            int obstacleDamage = this.getObstacle().getDamage()
                                    - this.getPlayer().getCharacter().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getHealth() - this.getObstacle().getDamage());
                            afterHit(i);
                        }
                    }
                    this.setSelectCombatValue(true);
                } else if (selectCase.equals("R")) {
                    afterHit(i);
                    this.setSelectCombatValue(false);
                    return true;
                }
            }

        }

        if (this.getPlayer().getCharacter().getHealth() > this.getObstacle().getHealth()) {
            System.out.println("You have defeated the enemy!");
            if (this.getObstacle().getName().equals("Snake")) {
                Player player = this.getPlayer();
                player.getAwardFromQuarry();
                this.setSelectCombatValue(true);
                return true;
            } else {
            int totalGain = this.getObstacle().getAward() * getMaxObstacle();
            System.out.println(totalGain + " You won the gold award");
            System.out.println("Your previous money: " + this.getPlayer().getCharacter().getMoney());
            this.getPlayer().getCharacter().setMoney(this.getPlayer().getCharacter().getMoney() + totalGain);
            System.out.println("Your current money : " + this.getPlayer().getCharacter().getMoney());
            System.out.println(this.getName() + " You have defeated all the enemies in the area!");
            System.out.println("This area has now been cleared. ");

            this.setSelectCombatValue(true);
            return true;
            }
        } else {
            return false;
        }
    }

    private void obstacleStatus(int i) {
        System.out.println("***************");
        System.out.println(i + ". " + this.getObstacle().getName() + " Values: ");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Prize: " + this.getObstacle().getAward());
    }

    private void playerStats() {
        System.out.println("--> Player values: ");

        System.out.println("Health: " + this.getPlayer().getCharacter().getHealth());
        System.out.println("Damage: " + this.getPlayer().getCharacter().getTotalDamage());
        System.out.println("Money: " + this.getPlayer().getCharacter().getMoney());
        System.out.println("Weapon: " + this.getPlayer().getCharacter().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getCharacter().getArmor().getName());
        System.out.println("***************");

    }

    private void afterHit(int i) {
        System.out.println("Your health : " + this.getPlayer().getCharacter().getHealth());
        System.out.println(i + ". " + this.obstacle.getName() + " health : "
                + this.obstacle.getHealth());
        System.out.println();
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
