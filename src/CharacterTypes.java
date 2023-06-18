public class CharacterTypes extends Player {
    private int id;
    public CharacterTypes (String name, int damage, int health, int money, int id) {
        super(name);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}