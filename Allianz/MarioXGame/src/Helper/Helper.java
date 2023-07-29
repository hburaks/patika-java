package Helper;

public class Helper {
    public static boolean[] createRandomPositions(int length, int count) {
        boolean[] positions = new boolean[length];
        int interval = length;
        for (int i = 0; i < count; i++) {
            int k = 0;
            int randomIndex = (int) (Math.random() * interval);
            for (int j = 0; j < length; j++) {
                if (k == randomIndex && positions[j] != true) {
                    positions[j] = true;
                    interval--;
                    break;
                } else if (positions[j] != true) {
                    k++;
                }
            }
        }
        return positions;
    }
}
