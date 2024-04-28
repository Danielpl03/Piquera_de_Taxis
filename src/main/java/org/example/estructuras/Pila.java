package org.example.estructuras;

import java.util.Iterator;

public class Pila<T> implements LinkedList<T> {
    private Node<T> top;
    int size;

    @Override
    public void add(T info) {
        Node<T> nodo = new Node<>(info);
        if(top != null) nodo.setBack(top);
        top = nodo;
        size++;
    }

    @Override
    public T remove() {
        if (isEmpty())return null;
        T aux = top.getDate();
        top = top.getBack();
        size--;
        return aux;
    }

    @Override
    @Deprecated
    public T remove(int index) {
        throw new RuntimeException("No aplicable method");
    }

    @Override
    @Deprecated
    public T remove(T dato) {
        throw new RuntimeException("No aplicable method");
    }

    @Override
    public Node<T> getFirst() {
        if (isEmpty())return null;
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(top);
    }
}
