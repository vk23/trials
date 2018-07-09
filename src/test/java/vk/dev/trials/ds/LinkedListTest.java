package vk.dev.trials.ds;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * LinkedListTest.
 *
 * @author Vladimir_Kuragin
 */
public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(null);
        linkedList.add(2);
        linkedList.add(3);
    }

    @Test
    public void get() {
        Integer result = linkedList.get(3);

        assertThat(result, is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBounds() {
        linkedList.get(Integer.MAX_VALUE);
    }

    @Test
    public void add() {
        final Integer val = 1000;
        linkedList = new LinkedList<>();
        LinkedList.Node<Integer> headBefore = linkedList.getHead();

        linkedList.add(val);
        LinkedList.Node<Integer> headAfter = linkedList.getHead();

        assertNull(headBefore);
        assertNotNull(headAfter);
        assertThat(headAfter.getValue(), is(val));
    }

    @Test
    public void remove() {
        boolean removed = linkedList.remove(2);

        assertTrue(removed);
    }

    @Test
    public void contains() {
        final Integer val = 23;

        linkedList.add(val);

        assertTrue(linkedList.contains(val));
    }

    @Test
    public void containsNull() {
        assertTrue(linkedList.contains(null));
    }

    @Test
    public void getSize() {
        assertThat(linkedList.getSize(), is(4));
    }

    @Test
    public void getSizeAfterRemoval() {
        linkedList.remove(3);

        assertThat(linkedList.getSize(), is(3));
    }
}