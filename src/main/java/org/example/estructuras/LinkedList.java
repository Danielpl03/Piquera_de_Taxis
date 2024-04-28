package org.example.estructuras;

public interface LinkedList<T> extends Iterable<T>{

    T remove();

    T remove(int index);

    T remove(T dato);

    Node<T> getFirst();

    T get(int index);

    void add(T info);

    boolean isEmpty();

    void clear();

    int size();
}
