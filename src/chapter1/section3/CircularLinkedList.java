package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class CircularLinkedList<T> implements Iterable<T> {

  public class Node {
    T item;
    Node next;

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

  public Node getHeadNode() {
    return head;
  }

  public Node getTailNode() {
    return tail;
  }

  public void insert(T item) {
    if (isEmpty()) {
      head = tail = new Node(item);
      tail.next = head;
      size++;
      return;
    }

    Node oldTail = tail; // also the head after initial insert :)
    tail = new Node(item);
    tail.next = head;
    oldTail.next = tail;
    size++;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;
      Node current = head;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public T next() {
        T value = current.item;
        current = current.next;
        index++;
        return value;
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
    return "LinkedList{" + "size=" + size + ", list=" + list + '}';
  }

  public static void main(String[] args) {
    CircularLinkedList<Integer> list = new CircularLinkedList<>();
    for (int i = 0; i < 10; i++) list.insert(i);

    StdOut.println(list);
    StdOut.println(list.getHeadNode().next.item);
    StdOut.println(list.getTailNode().item);

    StdOut.println(list.getTailNode().next == list.getHeadNode());
  }
}
