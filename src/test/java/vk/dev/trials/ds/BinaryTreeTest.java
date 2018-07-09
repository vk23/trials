package vk.dev.trials.ds;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * BinaryTreeTest.
 *
 * @author Vladimir_Kuragin
 */
public class BinaryTreeTest {

    private BinaryTree<Integer> binaryTree;

    @Before
    public void setUp() {
        binaryTree = new BinaryTree<>();
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(0);
        binaryTree.add(3);
        binaryTree.add(8);
    }

    @Test
    public void getRoot() {
        BinaryTree.Node<Integer> root = binaryTree.getRoot();

        assertNotNull(root);
        assertThat(root.getValue(), is(2));
    }

    @Test
    public void add() {
        binaryTree.add(5);

        assertTrue(binaryTree.contains(5));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNPE() {
        binaryTree.add(null);
    }

    @Test
    public void removeLeaf() {
        binaryTree.remove(0);

        assertFalse(binaryTree.contains(0));
    }

    @Test
    public void removeNodeWithOneLeaf() {
        binaryTree.remove(1);

        assertFalse(binaryTree.contains(1));
        assertTrue(binaryTree.contains(0));
    }

    @Test
    public void removeNodeWithTwoLeafs() {
        binaryTree.remove(4);

        assertFalse(binaryTree.contains(4));
        assertTrue(binaryTree.contains(3));
        assertTrue(binaryTree.contains(8));
    }

    @Test
    public void contains() {
        assertTrue(binaryTree.contains(8));
    }
}