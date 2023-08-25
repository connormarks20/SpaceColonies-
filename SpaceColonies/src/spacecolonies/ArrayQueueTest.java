package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Connor Marks (connorm20)
/**
 * 
 * @author Connor Marks
 * @version 4.3.2021
 *
 */
public class ArrayQueueTest extends TestCase {
    /**
     * field variables
     */
    private ArrayQueue<Integer> test1;
    private ArrayQueue<Integer> equal;
    private ArrayQueue<Integer> full;
    private ArrayQueue<Integer> empty;
    private ArrayQueue<Integer> nullSet;
    private String message;

    /**
     * sets up the ArrayQueue objects
     */
    public void setUp() {
        this.test1 = new ArrayQueue<Integer>();
        this.test1.enqueue(1);
        this.test1.enqueue(2);
        this.test1.enqueue(3);
        this.test1.enqueue(4);
        this.test1.enqueue(5);
        this.equal = new ArrayQueue<Integer>();
        this.full = new ArrayQueue<Integer>();
        for (int i = 1; i <= 99; i++) {
            full.enqueue(i);
        }
        this.equal.enqueue(1);
        this.equal.enqueue(2);
        this.equal.enqueue(3);
        this.equal.enqueue(4);
        this.equal.enqueue(5);
        this.empty = new ArrayQueue<Integer>();
        this.nullSet = null;
        this.message = "message";
    }


    /**
     * tests the constructor
     */
    public void testConstructor() {
        Exception exception = null;
        try {
            new ArrayQueue(105);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
    }


    /**
     * tests getSize() method from ArrayQueue
     */
    public void testGetSize() {
        assertEquals(this.test1.getSize(), 5);
        assertEquals(this.empty.getSize(), 0);
    }


    /**
     * tests getSizeOfUnderLyingArray() from ArrayQueue
     */
    public void testGetSizeOfUnderlyingArray() {
        assertEquals(this.test1.getLengthOfUnderlyingArray(), 10, 0.01);
        assertEquals(this.empty.getLengthOfUnderlyingArray(), 10, 0.01);
        empty.enqueue(1);
        empty.enqueue(2);
        assertEquals(this.empty.getLengthOfUnderlyingArray(), 10, 0.01);
    }


    /**
     * tests clear() from ArrayQueue
     */
    public void testClear() {
        assertFalse(this.test1.isEmpty());
        this.test1.clear();
        assertTrue(this.test1.isEmpty());
        assertTrue(this.empty.isEmpty());
        this.empty.clear();
        assertTrue(this.empty.isEmpty());

    }


    /**
     * tests dequeue() from ArrayQueue
     */
    public void testDequeue() {

        assertTrue(this.test1.dequeue().equals(1));
        assertEquals(this.test1.getSize(), 4);
        assertEquals(this.equal.dequeue(), 1, 0.01);
        this.test1.dequeue();
        assertEquals(this.test1.getSize(), 3);
        Exception exception = null;
        try {
            empty.dequeue();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * tests enqueue() from ArrayQueue()
     */
    public void testEnqueue() {
        assertEquals(this.test1.dequeue(), 1, 0.01);
        this.test1.enqueue(5);
        assertEquals(this.test1.getSize(), 5);
        this.test1.enqueue(6);
        assertEquals(this.test1.getSize(), 6);

        assertEquals(this.empty.getSize(), 0, 0.01);
        this.empty.enqueue(1);
        assertEquals(this.empty.getSize(), 1, 0.01);

    }


    /**
     * tests toArray() from ArrayQueue
     */
    public void testToArray() {
        Exception exception = null;

        try {
            empty.dequeue();
            empty.toArray();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
        boolean flag = false;
        // object array which will store the queue's values.
        Object[] arr = test1.toArray();
        for (int i = 2; i <= arr.length; i++) {
            if (arr[i - 2] instanceof Integer) {
                int obj = (int)arr[i - 1];
                assertEquals(i, obj, 0.01);
            }
            else if (arr[i - 2] != null) {
                assertTrue(flag);
            }
        }
    }


    /**
     * tests the isFull() method in ArrayQueue.java
     */
    public void testIsFull() {
        assertTrue(full.isFull());
        assertFalse(test1.isFull());
    }


    /**
     * tests the getFront() method in ArrayQueue
     */
    public void testGetFront() {
        assertEquals(this.test1.getFront(), 1, 0.01);
        this.test1.enqueue(1);
        this.test1.enqueue(2);
        assertEquals(this.test1.getFront(), 1, 0.01);
        Exception exception = null;
        try {
            empty.getFront();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);

    }


    /**
     * tests the equals method from arrayqueue.
     */
    public void testEquals() {
        assertTrue(test1.equals(equal));
        assertTrue(test1.equals(full));
        assertTrue(test1.equals(test1));
        assertFalse(test1.equals(nullSet));
        assertFalse(test1.equals(message));
        assertTrue(test1.equals(empty));
    }

}
