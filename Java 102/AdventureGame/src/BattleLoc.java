import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location{
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
        System.out.println("Be careful! There is " + obsNumber + " " + this.getObstacle().getName() + " inside !");
        System.out.println("<F>ight or <R>un");
        String selectCase = inp.nextLine().toUpperCase();
        while ((!selectCase.equals("F") && !selectCase.equals("R"))){
            System.out.print("'F' for Fight or 'R' for Run : ");
            selectCase = inp.nextLine().toUpperCase();
        }
        if(selectCase.equals("F")){
            System.out.println("Let the fight begin...");
            // fight condition
        } else if (selectCase.equals("R")){
            System.out.println("Running away with some damage");
            // run condition
        }
        return true;
    }

    public int randomObstacleNumber(){
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
