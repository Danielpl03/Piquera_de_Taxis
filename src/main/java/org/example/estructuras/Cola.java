package org.example.estructuras;

import org.example.models.Solicitud;

public class Cola<T> implements PilaYCola<T>{
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
        Node<T> nodo = primero;
        int cont = 0;
        if (index < 0 || index >= size)return null;
        while(nodo != null && cont < index){
            nodo = nodo.getNext();
            cont++;
        }
        return nodo != null ? nodo.getDate() : null;
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
}
