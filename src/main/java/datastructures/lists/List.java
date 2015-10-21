package datastructures.lists;

public interface List<T> {

    void add(T item);

    void delete(int index);

    T get(int index);

    int size();
}