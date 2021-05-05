package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {

  private class Node {
    T data;
    Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  private int size;
  private Node head;
  private Node tail;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(T data) {
    Node node = new Node(data);

    if (isEmpty()) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Queue is empty");

    T data = head.data;
    head = head.next;
    size--;

    if (isEmpty()) tail = null;
    return data;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        T data = current.data;
        current = current.next;
        return data;
      }
    };
  }

  @Override
  public String toString() {
    String list = "";
    int i = 0;
    for (T data : this) {
      if (i == 0) list = list + data;
      else list = list + "," + data;
      i++;
    }

    return "Queue{" + "size=" + size + ", list=" + list + '}';
  }

  public static void main(String[] args) {
    Queue<Integer> q = new Queue<Integer>();

    StdOut.println("Enqueuing 1 2 3");
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);

    StdOut.println(q);

    StdOut.println();
    StdOut.println("Size " + q.size());
    for (int n : q) {
      StdOut.println(n);
    }

    StdOut.println();
    StdOut.println("Dequeued " + q.dequeue());

    StdOut.println();
    StdOut.println("Size " + q.size());
    for (int n : q) {
      StdOut.println(n);
    }

    StdOut.println();
    StdOut.println("Dequeued " + q.dequeue());
    StdOut.println("Dequeued " + q.dequeue());

    StdOut.println();
    StdOut.println("Size " + q.size());
    for (int n : q) {
      StdOut.println(n);
    }
  }
}
