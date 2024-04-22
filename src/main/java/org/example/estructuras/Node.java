package org.example.estructuras;

import org.example.models.Solicitud;

import java.util.Comparator;
import java.util.Objects;

public class Node<T> implements Comparable<T>{
    private T date;
    private Node<T> next;
    private Node<T> back;

    public Node(T date) {
        this.date = date;
        next = null;
        back = null;
    }

    public boolean hasNext(){
        return this.getNext() != null;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getBack() {
        return back;
    }

    public void setBack(Node<T> back) {
        this.back = back;
    }

    @Override
    public String toString() {
        return date.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(date, node.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public int compareTo(T o) {
        return Objects.compare(this.getDate(), o, (Comparator<? super T>) Comparator.naturalOrder());
    }
}
