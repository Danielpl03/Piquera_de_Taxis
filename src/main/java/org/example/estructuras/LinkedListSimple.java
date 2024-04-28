package org.example.estructuras;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class LinkedListSimple<T> implements LinkedList<T>, Comparable<T> {
    private Node<T> first;
    private int size;

    public LinkedListSimple() {
        first = null;
        size = 0;
    }

    @Override
    public void add(T date) {
        Node<T> node = new Node<>(date);
        if (first == null) {
            first = node;
        } else {
            Node<T> iterator = first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(node);
        }
        size++;
    }

    public void add(T date, int pos) {
        if (pos < 0 || pos > size)
            throw new RuntimeException("Position out of bounds");
        Node<T> node = new Node<>(date);
        if (pos == 0) {
            node.setNext(first);
            first = node;
        } else {
            Node<T> iterator = first;
            int index = 0;
            while (index < pos - 1) {
                iterator = iterator.getNext();
                index++;
            }
            node.setNext(iterator.getNext());
            iterator.setNext(node);
        }
        size++;
    }

    public T find(T date) {
        if (first == null) return null;
        for (T dato: this) {
            if (dato.equals(date))
                return dato;
        }
        return null;
    }

    public int findIndex(T date) {
        if (first == null) return -1;
        int i = 0;
        for (T dato: this) {
            if (dato.equals(date))
                return i;
            i++;
        }
        return -1;
    }

    public boolean contains(T date) {
        return findIndex(date) != -1;
    }

    private void sort(Comparator<T> comparator) {
        if (size == 0 || size == 1) return;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (comparator.compare(get(i), get(j)) > 0) {
                    T date = get(j);
                    getNode(j).setDate(get(i));
                    getNode(i).setDate(date);
                }
            }
        }
    }

    public void sort(boolean reverseOrder) {
        if (reverseOrder) {
            sort((Comparator<T>) Comparator.reverseOrder());
        } else {
            sort();
        }
    }

    public void sort() {
        sort((Comparator<T>) Comparator.naturalOrder());
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Node<T> getFirst() {
        if (first == null)
            throw new RuntimeException("This list is null");
        return first;
    }

    @Override
    public T get(int pos) {
        if (first == null || pos < 0 || pos >= size)
            return null;
        Node<T> iterator = first;
        int index = 0;
        while (index < pos) {
            iterator = iterator.getNext();
            index++;
        }
        return iterator.getDate();
    }

    public Node<T> getNode(int pos) {
        if (first == null || pos < 0 || pos >= size)
            throw new RuntimeException("This list is null or position out of bounds");
        Node<T> iterator = first;
        int index = 0;
        while (index < pos) {
            iterator = iterator.getNext();
            index++;
        }
        return iterator;
    }

    public void set(T date, int pos) {
        if (first == null || pos < 0 || pos >= size)
            throw new RuntimeException("This list is null or position out of bounds");
        if (pos == 0) {
            first.setDate(date);
        } else {
            Node<T> iterator = first;
            int index = 0;
            while (index < pos) {
                iterator = iterator.getNext();
                index++;
            }
            iterator.setDate(date);
        }
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T remove(int pos) {
        if (first == null || pos < 0 || pos >= size)
            throw new RuntimeException("This list is null or position out of bounds");
        Node<T> iterator = first;
        if (pos == 0) {
            first = first.getNext();
            size--;
            return iterator.getDate();
        }
        int index = 0;
        while (index < pos - 1) {
            iterator = iterator.getNext();
            index++;
        }
        Node<T> aux = iterator.getNext();
        iterator.setNext(aux.getNext());
        size--;
        return aux.getDate();
    }

    @Override
    public T remove(T dato) {
        int index = findIndex(dato);
        return remove(index);
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }
        Node<T> iterator = first;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(iterator.getDate().toString()).append(", ");
            iterator = iterator.getNext();
        } while (iterator != null);
        sb.delete(sb.length() - 2, sb.length());

        return "[ " + sb + " ]";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) return 0;
        return Objects.compare(this.size, ((LinkedListSimple) o).size, Comparator.naturalOrder());
    }

    @Override
    public Iterator<T> iterator() {
         return new LinkedListIterator<>(first);
    }
}
