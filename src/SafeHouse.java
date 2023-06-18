public class SafeHouse extends  NormalLoc {
    public SafeHouse(Player player) {
        super(player);
    }

    @Override
    boolean onLocation() {
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println("Güvenli evdesiniz!");
        System.out.println("Canınız yenilendi!");
        return true;
    }
}