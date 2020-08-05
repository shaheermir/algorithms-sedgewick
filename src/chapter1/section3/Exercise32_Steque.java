package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercise32_Steque<T> implements Iterable<T> {
  public class Node {
    public T item;
    public Node next;

    public Node(T item) {
      this.item = item;
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

  public void push(T item) {
    if (isEmpty()) {
      head = tail = new Node(item);
      size++;
      return;
    }

    Node oldHead = head;
    head = new Node(item);
    head.next = oldHead;
    size++;
  }

  public T pop() {
    if (isEmpty()) throw new NoSuchElementException("Steque is empty");

    T item = head.item;
    head = head.next;
    size--;
    return item;
  }

  public void enqueue(T item) {
    if (isEmpty()) {
      head = tail = new Node(item);
      size++;
      return;
    }

    Node node = new Node(item);
    tail.next = node;
    tail = node;
    size++;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        T item = current.item;
        current = current.next;
        return item;
      }
    };
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
    return "Steque{" + "size=" + size + ", steque=" + list + '}';
  }

  public static void main(String[] args) {
    Exercise32_Steque<Integer> steque = new Exercise32_Steque<>();
    steque.enqueue(0);
    steque.enqueue(1);
    StdOut.println(steque);
    StdOut.println("Popped: " + steque.pop());
    StdOut.println("Popped: " + steque.pop());
    StdOut.println(steque);

    StdOut.println("\nPushing");

    for (int i = 0; i < 10; i++) steque.push(i);

    StdOut.println(steque);

    StdOut.println("Popped: " + steque.pop());
    StdOut.println(steque);

    StdOut.println("\nEnqueuing -1");
    steque.enqueue(-1);
    StdOut.println(steque);
  }
}
