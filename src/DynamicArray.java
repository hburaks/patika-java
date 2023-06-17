public class DynamicArray<T> {
    private T[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        this.capacity = 10; // Başlangıçta 10 elemanlık bir kapasite belirleyebilirsiniz.
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(T element) {
        if (size == capacity) {
            expandCapacity();
        }
        array[size] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Geçersiz indeks: " + index);
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    private void expandCapacity() {
        capacity *= 2; // Kapasiteyi ikiye katlama
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    public int getCapacity(){
        return capacity;
    }
}