package vk.dev.trials.ds;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * BinaryTreeTest.
 *
 * @author Vladimir_Kuragin
 */
public class BinaryTreeTest {

    private static final int ROOT = 5;
    private BinaryTree<Integer> binaryTree;

    /**
     * Initialize binary search tree:
     *              (5)
     *             /   \
     *          (1)     (7)
     *         /  \    /   \
     *      (0)  (3) (6)   (9)
     *          /  \       /  \
     *        (2) (4)    (8) (10)
     */
    @Before
    public void setUp() {
        binaryTree = new BinaryTree<>();
        binaryTree.add(ROOT);
        binaryTree.add(1);
        binaryTree.add(0);
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(6);
        binaryTree.add(9);
        binaryTree.add(8);
        binaryTree.add(10);
    }

    @Test
    public void shouldContain() {
        assertTrue(binaryTree.contains(8));
    }

    @Test
    public void getRoot() {
        BinaryTree.Node<Integer> root = binaryTree.getRoot();

        assertNotNull(root);
        assertThat(root.getValue(), is(ROOT));
    }

    @Test
    public void add() {
        binaryTree.add(100);

        assertTrue(binaryTree.contains(100));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPE() {
        binaryTree.add(null);
    }

    @Test
    public void removeNodeWithoutChildren() {
        binaryTree.remove(0);

        assertFalse(binaryTree.contains(0));
    }

    @Test
    public void removeNodeWithOneChild() {
        binaryTree.remove(1);

        assertFalse(binaryTree.contains(1));
        assertTrue(binaryTree.contains(0));
    }

    @Test
    public void removeNodeWithTwoChildren() {
        binaryTree.remove(3);

        assertFalse(binaryTree.contains(3));
        assertTrue(binaryTree.contains(2));
        assertTrue(binaryTree.contains(4));
    }

    @Test
    public void removeRoot() {
        int rightMinVal = 6;

        binaryTree.remove(ROOT);

        assertFalse(binaryTree.contains(ROOT));
        assertTrue(binaryTree.contains(7));
        assertTrue(binaryTree.contains(1));
        assertThat(binaryTree.getRoot().getValue(), is(rightMinVal));
    }

    @Test
    public void traverseDepthFirst() {
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> result = binaryTree.traverseDepthFirst(binaryTree.getRoot())
                .stream()
                .map(BinaryTree.Node::getValue)
                .collect(Collectors.toList());

        assertThat(result, containsInRelativeOrder(expected));
    }

    @Test
    public void traverseBreadthFirst() {
        Integer[] expected = {5, 1, 7, 0, 3, 6, 9, 2, 4, 8, 10};

        List<Integer> result = binaryTree.traverseBreadthFirst(binaryTree.getRoot())
                .stream()
                .map(BinaryTree.Node::getValue)
                .collect(Collectors.toList());

        assertThat(result, containsInRelativeOrder(expected));
    }

    @Test
    public void rotateLeft() {
        BinaryTree.Node<Integer> newRoot = binaryTree.rotateLeft();

        assertThat(newRoot, is(binaryTree.getRoot()));
        assertThat(newRoot.getValue(), is(7));
    }

    @Test
    public void rotateRight() {
        BinaryTree.Node<Integer> newRoot = binaryTree.rotateRight();

        assertThat(newRoot, is(binaryTree.getRoot()));
        assertThat(newRoot.getValue(), is(1));
    }
}