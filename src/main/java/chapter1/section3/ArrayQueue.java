package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Iterable<T> {
  private int size;
  private int first;
  private int last;
  private T[] array;

  public ArrayQueue() {
    this.array = (T[]) new Object[1];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(T item) {
    if (size == array.length) resize(size * 2);

    array[last++] = item;
    if (last == array.length) last = 0;
    size++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Queue is empty");

    T item = array[first];
    array[first] = null;

    first++;
    if (first == array.length) first = 0;

    size--;
    if (size > 0 && size == array.length / 4) resize(array.length / 2);
    return item;
  }

  private void resize(int n) {
    assert n > size;

    T[] temp = (T[]) new Object[n];
    for (int i = 0; i < n; i++) {
      temp[i] = array[(i + first) % array.length];
    }

    array = temp;

    first = 0;
    last = size;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int i = 0;

      @Override
      public boolean hasNext() {
        return i < size;
      }

      @Override
      public T next() {
        T item = array[(i + first) % array.length];
        i++;
        return item;
      }
    };
  }

  public static void main(String[] args) {
    ArrayQueue<Integer> q = new ArrayQueue<>();

    StdOut.println("Enqueueing 1 2 3");
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);

    StdOut.println();
    StdOut.println("Size is " + q.size());

    StdOut.println();
    StdOut.println("Dequeued " + q.dequeue());

    StdOut.println();
    StdOut.println("Enqueueing 4");
    q.enqueue(4);

    StdOut.println();
    StdOut.println("Dequeued " + q.dequeue());

    StdOut.println();
    StdOut.println("Size is " + q.size());

    StdOut.println();
    StdOut.println("Enqueueing 5 6 7");
    q.enqueue(5);
    q.enqueue(6);
    q.enqueue(7);

    StdOut.println();
    StdOut.println("Testing Iteration");
    for (int n : q) StdOut.println(n);

    for (int i = 0; i < 5; i++) StdOut.println("Dequeued: " + q.dequeue());

    StdOut.println();
    StdOut.println("Testing Iteration");
    for (int n : q) StdOut.println(n);
  }
}
