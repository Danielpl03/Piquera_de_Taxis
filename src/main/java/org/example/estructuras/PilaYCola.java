package org.example.estructuras;

public interface PilaYCola<T> {

    T pop();

    Node<T> top();

    T getIndex(int index);

    void push(T info);

    boolean isEmpty();

    void clear();

    int size();
}
