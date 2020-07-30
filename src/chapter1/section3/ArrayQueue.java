package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Iterable<T> {
  private int n;
  private int front;
  private int back;
  private T[] q;

  public ArrayQueue() {
    n = 0;
    front = back = 0;
    q = (T[]) new Object[2];
  }

  public int size() {
    return n;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public void resize(int length) {
    assert length >= n;

    T[] temp = (T[]) new Object[length];
    for (int i = 0; i < n; i++) temp[i] = q[(i + front) % q.length];

    q = temp;
    front = 0;
    back = n;
  }

  public void enqueue(T item) {
    if (n == q.length) resize(q.length * 2);

    q[back++] = item;
    if (back == q.length) back = 0;
    n++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Queue is empty");

    T item = q[front];
    q[front] = null;
    front++;
    if (front == q.length) front = 0;
    if (n > 0 && n == q.length / 4) resize(q.length * 2);
    return item;
  }

  public T peek() {
    if (isEmpty()) throw new NoSuchElementException("Queue is empty");
    return q[front];
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int i = 0;

      @Override
      public boolean hasNext() {
        return i < n;
      }

      @Override
      public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        T item = q[(i + front) % q.length];
        i++;
        return item;
      }
    };
  }

  public static void main(String[] args) {
    ArrayQueue<Integer> q = new ArrayQueue<>();

    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);

    for (int i : q) {
      StdOut.println(i);
    }
    StdOut.println("\nDequeuing.");
    StdOut.println(q.dequeue());
    StdOut.println(q.dequeue());
  }
}
