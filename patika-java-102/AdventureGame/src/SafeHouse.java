public class SafeHouse extends  NormalLoc {

    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        this.getPlayer().getCharacter().setHealth(this.getPlayer().getCharacter().getOriginalHealth());
        System.out.println("You are in safe house!");
        System.out.println("Healed! Your health is full now.");
        return true;
    }
}