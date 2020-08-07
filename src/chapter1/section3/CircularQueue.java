package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueue<T> implements Iterable<T> {
  private T[] q;
  private int size, front, rear;

  public CircularQueue(int capacity) {
    q = (T[]) new Object[capacity];
    size = 0;
    front = rear = -1;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return front == -1 && rear == -1;
  }

  public boolean isFull() {
    return ((rear + 1) % q.length) == front;
  }

  public void enqueue(T item) {
    if (isFull()) {
      StdOut.println("Enqueue failed. No Op. Buffer is full.");
      return;
    } else if (isEmpty()) front++;

    rear = (rear + 1) % q.length;
    q[rear] = item;
    size++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Queue is empty.");

    T item = q[front];
    q[front] = null;
    size--;

    if (front == rear) front = rear = -1;
    else front = (front + 1) % q.length;

    return item;
  }

  @Override
  public String toString() {
    return "CircularQueue{"
        + "size="
        + size
        + ", front="
        + front
        + ", rear="
        + rear
        + ", q="
        + Arrays.toString(q)
        + '}';
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int current = front;
      int count = 0;

      @Override
      public boolean hasNext() {
        return count < size;
      }

      @Override
      public T next() {
        T item = q[current];
        current = (current + 1) % q.length;
        count++;
        return item;
      }
    };
  }

  public static void main(String[] args) {
    CircularQueue<Integer> buffer = new CircularQueue<>(7);
    for (int i = 0; i < 5; i++) buffer.enqueue(i);

    StdOut.println(buffer);

    StdOut.println("\nDequeued: " + buffer.dequeue());
    StdOut.println(buffer);

    StdOut.println("\nEnqueuing 5");
    buffer.enqueue(5);
    StdOut.println("Enqueuing 6");
    buffer.enqueue(6);
    StdOut.println("Enqueuing 7");
    buffer.enqueue(7);

    StdOut.println(buffer);
    StdOut.println("Is Full: " + buffer.isFull());

    StdOut.println("\nEnqueuing 8");
    buffer.enqueue(8);
    StdOut.println(buffer);
    StdOut.println();

    StdOut.println("Looping Through");
    for (int i : buffer) StdOut.println(i);

    StdOut.println();
    for (int i = 0; i < 7; i++) StdOut.println("Dequeued: " + buffer.dequeue());
    StdOut.println(buffer);
    StdOut.println("Is Empty: " + buffer.isEmpty());
  }
}
