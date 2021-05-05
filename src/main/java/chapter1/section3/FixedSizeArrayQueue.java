package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class FixedSizeArrayQueue<T> implements Iterable<T> {

  private int size;
  private int first;
  private int last;
  private T[] array;

  public FixedSizeArrayQueue(int capacity) {
    this.array = (T[]) new Object[capacity];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(T item) {
    if (size == array.length) throw new RuntimeException("Queue is full.");

    array[last] = item;
    size++;

    if (last == array.length - 1) last = 0;
    else last++;
  }

  public T dequeue() {
    if (size == 0) throw new RuntimeException("Queue is empty");

    T item = array[first];
    array[first] = null;

    if (first == array.length - 1) first = 0;
    else first++;

    size--;
    return item;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int i = size;
      private int f = first;

      @Override
      public boolean hasNext() {
        return i > 0;
      }

      @Override
      public T next() {
        T item = array[f];
        i--;

        f++;
        if (f == array.length) f = 0;

        return item;
      }
    };
  }

  public static void main(String[] args) {
    FixedSizeArrayQueue<Integer> q = new FixedSizeArrayQueue<>(5);

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
    StdOut.println("Testing iteration");
    for (int n : q) StdOut.println(n);

    for (int i = 0; i < 5; i++) StdOut.println("Dequeued " + q.dequeue());
  }
}
