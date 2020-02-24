package Lesson4;

import java.util.Iterator;

public class LinkedList <T> implements Iterable <T> {

    private Node<T> first;
    private Node<T> last;

    private void insertFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if(first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    private void insertLast(T value) {
        Node<T> newNode = new Node<>(value);
        if(first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    private T deleteFirst() {
        T deletedValue = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return deletedValue;
    }

    private T deleteLast() {
        T deletedValue = last.value;
        Node<T> previous = findPrevious(last);
        last = previous;
        if (last == null) {
            first = null;
        } else {
            previous.next = null;
        }
        return deletedValue;
    }

    public void insertAt(int index, T value) {
        if(index == 0) {
            insertFirst(value);
        }
        Node<T> current = first;
        Node<T> previous = null;

        for (int i = 0; i < index && current != null; i++) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            insertLast(value);
        }

        Node<T> newNode = new Node<>(value);
        if (previous != null) {
            previous.next = newNode;
        }
        newNode.next = current;
    }

    public T deleteAt (int index) {
        if(index == 0) {
            deleteFirst();
        }
        T deletedValue = first.value;
        Node<T> current = first;
        first = current;
        Node<T> previous = null;

        for (int i = 0; i < index && current.next != null; i++) {
            previous = current;
            current = current.next;
        }

        if(current.next == null) {
            deleteLast();
        }

        if (previous != null) {
            previous.next = current.next;
        }
        return deletedValue;
    }

    private Node<T> findPrevious(Node<T> node) {
        Node<T> previous = first;
        while (previous != null && previous.next != node) {
            previous = previous.next;
        }
        return previous;
    }

    public void push (T value) {
    insertFirst(value);
    }

    public T pop() {
        return deleteFirst();
    }

    public T peek() {
        return first.value;
    }

    public void enqueue(T value) {
        insertLast(value);
    }

    public T deque() {
        return deleteFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            Node<T> curr = first;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.forEach(System.out::println);
        linkedList.deleteLast();
        linkedList.forEach(System.out::println);
        linkedList.insertLast(10);
        linkedList.forEach(System.out::println);
        linkedList.deleteFirst();
        linkedList.forEach(System.out::println);
    }
}
