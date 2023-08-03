/*
    1'den 10000 (10 bin)'e kadar olan sayılardan oluşan bir
ArrayList oluşturunuz. Ardından, bu ArrayList'teki 10 bin elemanı
2500 eleman olacak şekilde 4 eşit parçaya ayırınız. Bu 4 ayrı 2500
elemanlık ArrayList'ler içinde tek ve çift sayıları bulan 4 ayrı Thread
tasarlayınız.
- 4 Thread bulduğu çift sayıları ortak bir ArrayList'e ekleyecektir.
- 4 Thread bulduğu tek sayıları ortak bir ArrayList'e ekleyecektir.
- Tek ve çift sayıları tutan ArrayList'ler ilk oluşturulduklarında boş
olacaklardır. Ve iki tane ArrayList olacaklardır.
- 4 Thread kendine ait 2500 elemanlık ArrayList'i işlemeye başlayınca
tek ve çift sayı ArrayList'lerini dolduracaktır.
*/
import java.util.ArrayList;
import java.util.List;

public class RaceOfThreads {
    public static void main(String[] args) {
        ArrayList<Integer> thousand = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            thousand.add(i);
        }
        ArrayList<List<Integer>> dividedArrays = new ArrayList<>();
        int begin = 0;
        int end = 2500;
        for(int i = 0; i < 4; i++){
            List<Integer> dividedArray = thousand.subList(begin, end);
            dividedArrays.add(dividedArray);
            begin += 2500;
            end += 2500;
        }
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for(List<Integer> chunk : dividedArrays ){
            Thread thread = new Thread(() -> {
                for(int num : chunk){
                    if(num % 2 == 1){
                        synchronized (oddNumbers) {
                            oddNumbers.add(num);
                        }
                    }else{
                        synchronized (evenNumbers) {
                            evenNumbers.add(num);
                        }
                    }
                }
            });
            threads.add(thread);
        }
        try {
            for (Thread thread : threads) {
                thread.start(); // Tüm thread'lerin işini bitirmesini bekle
            }
            for (Thread thread : threads) {
                thread.join(); // Tüm thread'lerin işini bitirmesini bekle
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Odd Numbers: " + oddNumbers);
        System.out.println("Even Numbers: " + evenNumbers);
    }
}