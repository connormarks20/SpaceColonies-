package spacecolonies;

import queue.QueueInterface;

import queue.EmptyQueueException;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and
// integrity at all times.
// I will not lie, cheat, or steal, nor will I accept
// the actions of those who
// do.
// -- Connor Marks (connorm20)

/**
 * 
 * @author Connor Marks
 * @version 4.4.2021
 *
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    /**
     * field variables
     */
    private int size;
    private int enqueueIndex;
    private int dequeueIndex;
    private T[] queue;
    /**
     * public field variable for default
     */
    public final static int DEFAULT_CAPACITY = 9;
    /**
     * public field variable for max
     */
    public final static int MAX_CAPACITY = 99;

    /**
     * constructs the ArrayQueue objects by first clearing the queue
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * constructor for ArrayQueue
     * 
     * @param capacity
     *            for the capacity
     */
    public ArrayQueue(int capacity) {
        if (capacity > MAX_CAPACITY || capacity < DEFAULT_CAPACITY) {
            throw new IllegalStateException();
        }
        queue = (T[])new Object[capacity + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
    }


    /**
     * gets the size field
     * 
     * @return the size
     */
    public int getSize() {
        return size;
    }


    /**
     * gets the array size
     * 
     * @return the length of array.
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }


    /**
     * dequeues an element.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T deq = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return deq;
    }


    /**
     * enqueues an object parameter.
     */
    @Override
    public void enqueue(T obj) {
        this.ensureCapacity();
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = obj;
        size++;
    }


    /**
     * Method to check whether or not the queue can enqueue more elements
     * 
     * @throws IllegalStateException
     *             if the capacity has been reached
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (!isFull()) {
            if (size == getLengthOfUnderlyingArray() - 1) {
                T[] temp = (T[])new Object[getSize() * 2 + 1];
                for (int i = 0; i < getLengthOfUnderlyingArray(); i++) {
                    temp[i] = this.queue[i];
                }
                enqueueIndex = size;
                queue = temp;
            }
            return;
        }
        throw new IllegalStateException("max");
    }


    /**
     * checks if the queue is full.
     * 
     * @return true if the max capacity and size are equivalent
     */
    public boolean isFull() {
        return size == MAX_CAPACITY;
    }


    /**
     * 
     * @param index
     *            for the index of the item
     * @return index + 1 % queue.length
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * returns the front of the queue as long as it isn't empty.
     * Throw EmptyQueueException if isEmpty() returns true.
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * checks if the queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * clears the queue
     */
    public void clear() {
        this.size = 0;
        this.enqueueIndex = 0;
        this.dequeueIndex = this.queue.length - 1;
    }


    /**
     * equals method
     * 
     * @param obj
     *            for the object comparison
     * @return boolean result
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass().equals(obj.getClass())) {
            @SuppressWarnings({ "unchecked" })
            ArrayQueue<T> o = (ArrayQueue<T>)obj;

            for (int i = 0; i < this.getLengthOfUnderlyingArray(); i++) {
                T a = queue[i];
                T b = o.queue[i];
                if (a != null && b != null) {
                    if (!a.equals(b)) {
                        return false;
                    }
                }

            }
            return true;
        }
        return false;
    }


    /**
     * puts the queue into array form.
     * 
     * @return the cloned queue
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T[] copy = (T[])new Object[this.getSize()];
        for (int i = 0; i < this.getSize(); i++) {
            copy[i] = this.queue[i];
        }
        return copy;
    }

}
