import java.util.Arrays;
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
        System.out.println();

    }
    public static int[] isDuplicate(int[] arr){
        int[] duplicated = new int[arr.length];
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            boolean isDuplicate = false;
            for(int j = i + 1; j<arr.length; j++){
                if(arr[j] == arr[i]){
                    isDuplicate = true;
                    break;
                }
            }
            if(isDuplicate){
                duplicated[count] = arr[i];
                count++;
            }

        }
        int[] result = new int[count];
        System.arraycopy(duplicated, 0, result, 0, count);
        return result;
    }
    public static void main(String[] args) {
        int[] list = {14, 18, 23, 500, 15,15};
        System.out.println(ArrayHelper.average(list));
        System.out.println(ArrayHelper.minMax(list));
        printB();
        int[] duplicates = ArrayHelper.isDuplicate(list);
        System.out.println(Arrays.toString(duplicates));
    }

}