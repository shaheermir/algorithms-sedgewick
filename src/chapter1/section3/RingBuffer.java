package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.NoSuchElementException;

// See CircularQueue for a slightly cleaner sol'n.
public class RingBuffer<T> {
  private T[] buffer;
  private int size;
  private int front;
  private int rear;

  public RingBuffer(int capacity) {
    assert (capacity > 0);
    buffer = (T[]) new Object[capacity];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == buffer.length;
  }

  public void enqueue(T item) {
    if (isFull()) {
      StdOut.println("Enqueue failed. No Op. Buffer is full.");
      return;
    }

    if (isEmpty()) {
      buffer[rear] = item;
      size++;
      return;
    }

    rear = (rear + 1) % buffer.length;
    buffer[rear] = item;
    size++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Buffer is empty.");

    T item = buffer[front];
    buffer[front] = null;
    front = (front + 1) % buffer.length;
    size--;

    if (isEmpty()) {
      front = 0;
      rear = 0;
    }

    return item;
  }

  @Override
  public String toString() {
    return "RingBuffer{"
        + "size="
        + size
        + ", front="
        + front
        + ", rear="
        + rear
        + ", array="
        + Arrays.toString(buffer)
        + '}';
  }

  public static void main(String[] args) {
    RingBuffer<Integer> buffer = new RingBuffer<>(7);
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

    StdOut.println("Enqueuing 8");
    buffer.enqueue(8);

    StdOut.println(buffer);
    StdOut.println();

    for (int i = 0; i < 7; i++) {
      StdOut.println("Dequeued: " + buffer.dequeue());
    }
    StdOut.println(buffer);

    for (int i = 0; i < 5; i++) buffer.enqueue(i);
    StdOut.println(buffer);

    StdOut.println("Dequeued: " + buffer.dequeue());
    StdOut.println("Dequeued: " + buffer.dequeue());
    StdOut.println(buffer);
  }
}
