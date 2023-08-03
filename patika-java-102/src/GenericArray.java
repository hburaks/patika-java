public class GenericArray<T>{
    public static void main(String[] args) {
        run();
    }
    private int capacity = 0;
    private int size;
    private T[] array;
    GenericArray(){
        this.array = (T[]) new Object[capacity];
        this.capacity = 10;
        this.size = 0;
    }
    GenericArray(int capacity){
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }
    public int size() {
        return size;
    }
    public int getCapacity(){
        return capacity;
    }
    public void add(T data){
        if(size == capacity || size > capacity){
            resize();
        }
        this.array[size] = data;
        size++;
    }
    public void resize(){
        capacity *= 2;
        T[] tempArray = this.array;
        this.array = (T[]) new Object[capacity];
        System.arraycopy(tempArray, 0, this.array, 0, size);
    }
    public static void run(){
        GenericArray<Integer> arrayTest = new GenericArray<>(2);
        System.out.println("Boyut : " + arrayTest.size());
        System.out.println("Kapasite : " + arrayTest.getCapacity());
        arrayTest.add(5);
        arrayTest.add(8);
        arrayTest.add(15);
        System.out.println("Boyut : " + arrayTest.size());
        System.out.println("Kapasite : " + arrayTest.getCapacity());

    }

}