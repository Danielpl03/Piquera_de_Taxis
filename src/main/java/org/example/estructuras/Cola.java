package org.example.estructuras;

import java.util.Iterator;

public class Cola<T> implements LinkedList<T> {
    Node<T> primero;
    Node<T> ultimo;
    int size;

    public Cola() {
    }

    @Override
    public void push(T info) {
        Node<T> nodo = new Node<>(info);
        if (primero != null){
            ultimo.setNext(nodo);
            ultimo = nodo;
        }
        else ultimo = primero = nodo;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty())return null;
        T aux = primero.getDate();
        primero = primero.getNext();
        size--;
        return aux;
    }

    @Override
    public Node<T> top() {
        if (isEmpty())return null;
        return primero;
    }

    @Override
    public boolean isEmpty() {
        return primero==null;
    }

    @Override
    public T getIndex(int index) {
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
