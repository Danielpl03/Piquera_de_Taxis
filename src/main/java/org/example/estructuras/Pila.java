package org.example.estructuras;

public class Pila<T> implements PilaYCola<T>{
    private Node<T> top;
    int size;

    @Override
    public void push(T info) {
        Node<T> nodo = new Node<>(info);
        if(top != null) nodo.setBack(top);
        top = nodo;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty())return null;
        T aux = top.getDate();
        top = top.getBack();
        size--;
        return aux;
    }

    @Override
    public Node<T> top() {
        if (isEmpty())return null;
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T getIndex(int index) {
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
}
