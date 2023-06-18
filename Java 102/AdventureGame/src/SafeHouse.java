public class SafeHouse extends  NormalLoc {

    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    boolean onLocation() {
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println("Güvenli evdesiniz!");
        System.out.println("Canınız yenilendi!");
        return true;
    }
}