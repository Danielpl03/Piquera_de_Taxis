package org.example.estructuras;

public interface LinkedList<T> extends Iterable<T>{

    T pop();

    Node<T> top();

    T getIndex(int index);

    void push(T info);

    boolean isEmpty();

    void clear();

    int size();
}
