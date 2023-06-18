public class NormalLoc extends Location {
    public NormalLoc(Player player){
        super(player);
    }
    @Override
    boolean onLocation() {
        return true;
    }

}