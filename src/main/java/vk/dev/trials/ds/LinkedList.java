package vk.dev.trials.ds;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * LinkedList.
 *
 * @author Vladimir_Kuragin
 */
@ToString
public class LinkedList<T> {

    @Data
    @Accessors(chain = true)
    public static final class Node<T> {
        private Node<T> next;
        private T value;

        @Override
        public String toString() {
            return "[" + value + "]" + (next == null ? "" : next.toString());
        }
    }

    @Getter
    private Node<T> head;

    @Getter
    private int size;

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<T>().setValue(value);
        } else {
            addRecursively(head, value);
        }
        size++;
    }

    private void addRecursively(Node<T> node, T value) {
        if (node.getNext() == null) {
            node.setNext(new Node<T>().setValue(value));
        } else {
            addRecursively(node.getNext(), value);
        }
    }

    public boolean remove(T value) {
        Node<T> prev = null;
        Node<T> node = head;
        while (node != null) {
            if (eq(value, node.getValue())) {
                if (prev != null) {
                    prev.setNext(node.getNext());
                }
                size--;
                return true;
            }
            prev = node;
            node = node.getNext();
        }
        return false;
    }

    private boolean eq(T left, T right) {
        return (left == null && right == null)
                || (left != null && left.equals(right));
    }

    public boolean contains(T value) {
        Node<T> node = head;
        while (node != null) {
            if (eq(value, node.getValue())) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public void reverseRecursively() {
        head = reverseRecursively(null, head);
    }

    private Node<T> reverseRecursively(Node<T> prev, Node<T> node) {
        Node<T> next = node.getNext();
        node.setNext(prev);
        if (next == null) {
            return node;
        } else {
            return reverseRecursively(node, next);
        }
    }

    public void reverse() {
        Node<T> node = head;
        Node<T> prev = null;

        while(true) {
            Node<T> next = node.getNext();
            node.setNext(prev);
            prev = node;
            if (next == null) {
                head = node;
                return;
            } else {
                node = next;
            }
        }
    }
}
