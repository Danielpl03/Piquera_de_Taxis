package org.example.estructuras;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> actual;

    public LinkedListIterator(Node<T> inicio) {
        this.actual = inicio;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T dato = actual.getDate();
        actual = actual.getNext();
        return dato;
    }
}
