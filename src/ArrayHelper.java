public class ArrayHelper {
    public static double average(int[] arr){
        double sum = 0.0;
        for(int i : arr){
            sum  += i ;
        }

        return sum/arr.length;
    }
    public static String minMax(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for(int i : arr){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return max + " " + min;
    }
    public static void printB(){
        String[][] letter = new String[5][4];
        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                if (i == 0 || i == 2 || i == 4) {
                    letter[i][j] = " * ";
                } else if (j == 0 || j == 3) {
                    letter[i][j] = " * ";
                } else {
                    letter[i][j] = "   ";
                }
            }
        }
        System.out.println();
        for (String[] row : letter){
            for (String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] list = {14, 18, 23, 500, 15};
        System.out.println(ArrayHelper.average(list));
        System.out.println(ArrayHelper.minMax(list));
        printB();
    }

}