package org.example.estructuras;

import java.util.Iterator;

public class Cola<T> implements LinkedList<T> {
    Node<T> primero;
    Node<T> ultimo;
    int size;

    public Cola() {
    }

    @Override
    public void add(T info) {
        Node<T> nodo = new Node<>(info);
        if (primero != null){
            ultimo.setNext(nodo);
            ultimo = nodo;
        }
        else ultimo = primero = nodo;
        size++;
    }

    @Override
    public T remove() {
        if (isEmpty())return null;
        T aux = primero.getDate();
        primero = primero.getNext();
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
        return primero;
    }

    @Override
    public boolean isEmpty() {
        return primero==null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)return null;
        int cont = 0;
        for (T dato: this) {
            if (cont == index) return dato;
            cont++;
        }
        return null;
    }

    @Override
    public void clear(){
        primero = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(primero);
    }
}
