package datastructures.lists;

public class ArrayList<T> implements List<T> {

    private final int capacity;
    private int size;
    private Object[] arr;

    public ArrayList(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
    }

    @Override
    public void add(T item) {
        arr[size++] = item;
    }

    @Override
    public void delete(int index) {
        arr[index] = null;

        int i = 0;
        Object[] tmp = new Object[capacity];

        for (Object a : arr) {
            if (a != null)
                tmp[i++] = a;
        }

        arr = tmp;
        size--;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index >= capacity)
            throw new IndexOutOfBoundsException();

        return (T) arr[index];
    }

    @Override
    public int size() {
        return size;
    }

}