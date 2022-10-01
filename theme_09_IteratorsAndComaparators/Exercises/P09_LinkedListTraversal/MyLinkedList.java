package theme_09_IteratorsAndComaparators.Exercises.P09_LinkedListTraversal;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private static class Node<T> {
        private T element;
        private Node<T> next;

        private Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T element = currentNode.element;
                currentNode = currentNode.next;
                return element;
            }
        };
    }

    public void add(T element) {
        Node<T> newNode = new Node<T>(element, null);

        if (size == 0) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        this.size++;
    }

    public boolean remove(T element) {
        if (size == 0) {
            return false;
        }

        Node<T> currentNode = head;
        Node<T> prevNode = null;

        while (currentNode != null) {
            T currentElement = currentNode.element;
            if (currentElement.equals(element)) {

                if (prevNode == null) {
                    this.head = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }

                if (currentNode.next == null) {
                    this.tail = prevNode;
                }

                this.size--;
                return true;

            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }


}
