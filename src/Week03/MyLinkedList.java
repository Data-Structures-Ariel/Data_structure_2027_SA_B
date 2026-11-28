
package Week03;

import java.util.*;
import Structures.*;
public class MyLinkedList<E> implements List<E> {

    private int size;
    private Node<E> head;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty())
            return false;
        return contains(o, head);
    }

    private boolean contains(Object o, Node<E> chain) {
        while (chain != null) {
            if (Objects.equals(chain.getValue(), o))
                return true;
            chain = chain.getNext();
        }
        return false;
    }

    // O(n)
    @Override
    public boolean add(E e) {
        if (isEmpty()) {
            head = new Node<>(e);
            size++;
            return true;
        }
        return add(e, head);
    }

    private boolean add(E e, Node<E> chain) {
        while (chain.hasNext())
            chain = chain.getNext();

        chain.setNext(new Node<>(e));
        size++;
        return true;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<E> temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        return temp.getValue();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        E item = temp.getValue();
        temp.setValue(element);
        return item;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0 && head == null) {
            add(element);
            return;
        }

        if (index == 0 && head != null) {
            Node<E> newNode = new Node<>(element);
            newNode.setNext(head);
            this.head = newNode;
            size++;
            return;
        }

        if (index == size) {
            add(element);
            return;
        }

        Node<E> temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }

        Node<E> newNode = new Node<>(element);
        Node<E> next = temp.getNext();

        newNode.setNext(next);
        temp.setNext(newNode);
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            E item = head.getValue();
            head = head.getNext();
            size--;
            return item;
        }

        Node<E> temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }

        E item = temp.getNext().getValue();
        temp.setNext(temp.getNext().getNext());
        size--;

        return item;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> temp = head;

        while (temp != null) {
            if (Objects.equals(temp.getValue(), o))
                return index;

            temp = temp.getNext();
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int find = -1;
        Node<E> temp = head;

        while (temp != null) {
            if (Objects.equals(temp.getValue(), o))
                find = index;

            temp = temp.getNext();
            index++;
        }

        return find;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            return false;

        int index = indexOf(o);

        if (index == -1)
            return false;

        remove(index);
        return true;
    }

    // ---------------------------------------------------
    // Functions not implemented yet
    // ---------------------------------------------------

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}

