package vk.dev.trials.ds;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * BinaryTree.
 *
 * @author Vladimir_Kuragin
 */
public class BinaryTree<T extends Comparable<? super T>> {

    @Data
    @Accessors(chain = true)
    @ToString(exclude = {"left", "right"})
    public static final class Node<T extends Comparable<? super T>> {
        private Node<T> left;
        private Node<T> right;
        private T value;
    }

    @Getter
    private Node<T> root;

    public void add(@NonNull T value) {
        root = addRecursively(root, value);
    }

    private Node<T> addRecursively(Node<T> node, T value) {
        if (node == null) {
            return new Node<T>().setValue(value);
        }
        int comparison = value.compareTo(node.getValue());
        if (comparison > 0) {
            node.setRight(addRecursively(node.getRight(), value));
        } else if (comparison < 0) {
            node.setLeft(addRecursively(node.getLeft(), value));
        }
        return node;
    }

    public boolean remove(@NonNull T value) {
        root = removeRecursively(root, value);
        return true; // TODO?
    }

    private Node<T> removeRecursively(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        int comparison = value.compareTo(node.getValue());

        if (comparison > 0) {
            node.setRight(removeRecursively(node.getRight(), value));
        } else if (comparison < 0) {
            node.setLeft(removeRecursively(node.getLeft(), value));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                //TODO: remove and rearrange?
            }
        }

        return node;
    }

    public boolean contains(@NonNull T value) {
        return find(root, value) != null;
    }

    private Node<T> find(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        int comparison = value.compareTo(node.getValue());
        if (comparison > 0) {
            return find(node.getRight(), value);
        } else if (comparison < 0) {
            return find(node.getLeft(), value);
        }
        return node;
    }
}
