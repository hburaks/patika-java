public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.add(30);

        System.out.println("Eleman sayısı: " + dynamicArray.size());

        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.println("Index " + i + ": " + dynamicArray.get(i));
        }
        System.out.println(dynamicArray.getCapacity());
    }
}