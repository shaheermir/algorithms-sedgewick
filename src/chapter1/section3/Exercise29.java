package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercise29<T> implements Iterable<T> {

  public class Node {
    T item;
    Node next;

    public Node(T item) {
      this.item = item;
    }
  }

  private int size;
  private Node last;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(T item) {
    Node node = new Node(item);

    if (isEmpty()) {
      last = node;
      last.next = last;
      size++;
      return;
    }

    node.next = last.next;
    last.next = node;
    last = node;
    size++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Queue is empty.");

    T item;
    if (size == 1) {
      item = last.item;
      last = null;
    } else {
      item = last.next.item;
      last.next = last.next.next;
    }
    size--;
    return item;
  }

  @Override
  public Iterator<T> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<T> {

    int index = 0;
    Node current;

    QueueIterator() {
      if (size > 1) {
        current = last.next;
      } else {
        current = last;
      }
    }

    @Override
    public boolean hasNext() {
      return index < size;
    }

    @Override
    public T next() {
      T item = current.item;
      current = current.next;
      index++;
      return item;
    }
  }

  @Override
  public String toString() {
    String list = "";
    int i = 0;
    for (T item : this) {
      if (i == 0) list = list + item;
      else list = list + "," + item;
      i++;
    }
    return "Queue{" + "size=" + size + ", queue=" + list + '}';
  }

  public static void main(String[] args) {
    Exercise29<Integer> q = new Exercise29<>();
    for (int i = 0; i < 10; i++) q.enqueue(i);

    StdOut.println(q);

    for (int i = 0; i < 5; i++) StdOut.println("Dequeued: " + q.dequeue());

    StdOut.println("\n" + q);
  }
}
