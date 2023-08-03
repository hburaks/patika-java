public class PrimeNumber {
    public static void main(String[] args) {
        for(int i = 0; i <= 100; i++){
            boolean isPrime = true;
            for(int j = i-1 ; j > 1; j--){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.print(i + " ");
            }
        }
    }
}
