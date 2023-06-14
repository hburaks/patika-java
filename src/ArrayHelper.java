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
    public static void main(String[] args) {
        int[] list = {14, 18, 23, 500, 15};
        System.out.println(ArrayHelper.average(list));
        System.out.println(ArrayHelper.minMax(list));
    }

}