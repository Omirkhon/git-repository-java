package HandMadeLinkedList;

import java.util.NoSuchElementException;

public class HandMadeLinkedList<T> {

    class Node<E> {
        public E data;
        public Node<E> next;
        public Node<E> prev;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    private int size = 0;

    public T get(int index) {
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if(index == count) {
                return current.data;
            }
            current = current.next;
            count++;
        }
        return null;
    }

    public void printAll() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void add(int index, T element) {
        if (index == 0) {
            addFirst(element);
            return;
        }
        else if (index == size) {
            addLast(element);
            return;
        }
        Node<T> current = head;
        for (int i = 0; i<index-1; i++) {
            current = current.next;
        }

        size++;
        final Node<T> newNode = new Node<>(current, element, current.next);
        current.next.prev = newNode;
        current.next = newNode;
    }
    public void addFirst(T element) {
        final Node<T> oldHead = head;
        final Node<T> newNode = new Node<>(null, element, oldHead);
        head = newNode;
        if (oldHead == null)
            tail = newNode;
        else
            oldHead.prev = newNode;
        size++;
    }

    public T getFirst() {
        final Node<T> curHead = head;
        if (curHead == null)
            throw new NoSuchElementException();
        return head.data;
    }

    public void addLast(T element) {
        final Node<T> oldTail = tail;
        final Node<T> newNode = new Node<>(oldTail, element, null);
        tail = newNode;
        if (oldTail != null) {
            oldTail.next = newNode;
        } else {
            head = newNode;
        }
        size++;
    }

    public T getLast() {
        final Node<T> curTail = tail;
        if (curTail == null)
            throw new NoSuchElementException();
        return tail.data;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        HandMadeLinkedList<Integer> integers = new HandMadeLinkedList<Integer>();

        integers.addFirst(1);
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addLast(4);
        integers.addLast(5);
        integers.addFirst(1);
        integers.add(1, 5);

        System.out.println(integers.getFirst());
        System.out.println(integers.size());
        System.out.println(integers.getLast());
        System.out.println(integers.size());
        integers.printAll();
        System.out.println(integers.get(1));
    }
}