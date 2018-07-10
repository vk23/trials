package vk.dev.trials.ds;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }
    }

    @Getter
    private Node<T> root;

    public boolean contains(@NonNull T value) {
        return find(root, value) != null;
    }

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

    public void remove(@NonNull T value) {
        root = removeRecursively(root, value);
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
            return removeNode(node);
        }

        return node;
    }

    private Node<T> removeNode(Node<T> node) {
        // node has no children
        if (!node.hasLeft() && !node.hasRight()) {
            return null;
        }
        // node has only right child
        if (!node.hasLeft()) {
            return node.getRight();
        }
        // node has only left child
        if (!node.hasRight()) {
            return node.getLeft();
        }
        // node has both children:
        // find min value in right subtree,
        // set current node's value to min value
        // and delete duplicate node.
        T minVal = findMinVal(node.getRight());
        node.setValue(minVal);
        node.setRight(removeRecursively(node.getRight(), minVal));
        return node;
    }

    /**
     * Since it's a BST minVal will be always in the leftmost node.
     *
     * @param node subtree root
     * @return min value
     */
    private T findMinVal(Node<T> node) {
        return node.hasLeft()
                ? findMinVal(node.getLeft())
                : node.getValue()
                ;
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

    public List<Node<T>> traverseDepthFirst(Node<T> node) {
        List<Node<T>> nodeList = new ArrayList<>();
        traverseDepthFirstRecursively(node, nodeList);
        return nodeList;
    }

    private void traverseDepthFirstRecursively(Node<T> node, List<Node<T>> nodeList) {
        if (node == null) {
            return;
        }
        traverseDepthFirstRecursively(node.getLeft(), nodeList);
        nodeList.add(node);
        traverseDepthFirstRecursively(node.getRight(), nodeList);
    }

    public List<Node<T>> traverseBreadthFirst(Node<T> node) {
        List<Node<T>> nodeList = new ArrayList<>();

        Queue<Node<T>> q = new LinkedList<>(Collections.singleton(node));
        while (!q.isEmpty()) {
            Node<T> current = q.remove();
            nodeList.add(current);
            if (current.hasLeft()) {
                q.add(current.getLeft());
            }
            if (current.hasRight()) {
                q.add(current.getRight());
            }
        }
        return nodeList;
    }

    public Node<T> rotateLeft() {
        Node<T> result = rotateLeft(root);
        root = result;
        return result;
    }

    public Node<T> rotateRight() {
        Node<T> result = rotateRight(root);
        root = result;
        return result;
    }

    private Node<T> rotateLeft(Node<T> node) {
        if (!node.hasRight()) {
            return node;
        }
        Node<T> right = node.getRight();
        node.setRight(right.getLeft());
        right.setLeft(node);
        return right;
    }

    private Node<T> rotateRight(Node<T> node) {
        if (!node.hasLeft()) {
            return node;
        }
        Node<T> left = node.getLeft();
        node.setLeft(left.getRight());
        left.setRight(node);
        return left;
    }
}
