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
public class LinkedList<T> {

    @Data
    @ToString(exclude = "next")
    @Accessors(chain = true)
    public static final class Node<T> {
        private Node<T> next;
        private T value;
    }

    @Getter
    private Node<T> head;

    @Getter
    private int size;

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
}
