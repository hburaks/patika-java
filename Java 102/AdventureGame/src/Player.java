import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private int health;
    private int money;
    private Inventory inv;
    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    private int originalHealth;
    public Player(String name) {
        this.name = name;
    }
    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public  void selectChar(){
        CharacterTypes[] characterTypes = {new Samurai(), new Archer(), new Knight()};
        System.out.println("----------------------------- Karakterler -----------------------------");
        for(CharacterTypes i : characterTypes){
            System.out.println(i.getId() + "- " + i.getName() + "   Hasar   :   " + i.getDamage() + "   Sağlık  :   " + i.getHealth() + "   Para    :   " + i.getMoney());
        }
        Scanner inp = new Scanner(System.in);
        int selectedId = inp.nextInt();
        if(selectedId < 4 && selectedId > 0){
            switch (selectedId){
                case 1:
                    initPlayer(new Samurai());
                    break;
                case 2:
                    initPlayer(new Archer());
                    break;
                case 3:
                    initPlayer(new Knight());
                    break;
            }
        } else {
            System.out.println("Lütfen tanımlı aralıktaki karakterlerden bir tanesini seç!");
            selectChar();
        }
    }
    public  void initPlayer(CharacterTypes characterType){
        this.setDamage(characterType.getDamage());
        this.setName(characterType.getName() + " " + this.getName());
        this.setDamage(characterType.getDamage());
        this.setHealth(characterType.getHealth());
        this.setOriginalHealth(characterType.getHealth());
        this.setMoney(characterType.getMoney());
    }
    public void printCharInfo(){
        System.out.println("Merhaba " + this.getName());
        System.out.println("Hasar :  "+ this.getDamage());
        System.out.println("Sağlık :  "+ this.getHealth());
        System.out.println("Para :  "+ this.getMoney());
        System.out.println("Oyun başlıyor. Başarılar!!");
    }
    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
    public int getTotalDamage() {
        return this.getDamage() + this.getInv().getDamage();
    }


}