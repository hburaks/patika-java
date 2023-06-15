import java.util.Arrays;
import java.util.Scanner;

public class MinesweeperGame {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Define the row count: ");
        int rows = inp.nextInt();
        System.out.print("Define the column count: ");
        int columns = inp.nextInt();

        int[][] table = new int[rows][columns];

        int mineCount = Math.round(rows * columns / 4);

        int[] minePositions = new int[mineCount];
        int[] minePosition = randomNumInterval(rows * columns, mineCount);
        System.out.println(Arrays.toString(minePosition));

        for (int i = 0; i < minePosition.length; i++) {
            int a = minePosition[i] / columns;
            int b = minePosition[i] % columns;
            table[a][b] = -1;
        }
        printMinePositions(rows,columns,table);

    }

    public static int[] randomNumInterval(int interval, int mineCount) {
        int[] minePositions = new int[mineCount];
        int i = 0;
        while (i < mineCount) {
            boolean isThere = false;
            int random = (int) (Math.random() * interval);
            for (int j = 0; j < i; j++) {
                if (random == minePositions[j]) {
                    isThere = true;
                    break;
                }
            }
            if (!isThere) {
                minePositions[i] = random;
                i++;
            }
        }
        return minePositions;
    }
    public static void printMinePositions(int rows, int columns, int[][] table) {
        System.out.println("====================");
        for(int i = 0; i < rows; i++){
            System.out.print("  ");
            for(int j = 0; j < columns; j++){
                if(table[i][j] != -1){
                    System.out.print(" -");
                } else {
                    System.out.print(" +");
                }
            }
            System.out.println();
        }
        System.out.println("====================");
    }
}