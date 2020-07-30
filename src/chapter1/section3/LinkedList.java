package chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
  public class Node {
    T item;
    Node next;

    public Node(T item) {
      this.item = item;
    }
  }

  private int size = 0;
  private Node head;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T get(int index) {
    if (isEmpty()) throw new NoSuchElementException("List is empty");
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    Node current = head;
    int i = 0;
    while (i < index) {
      i++;
      current = current.next;
    }

    return current.item;
  }

  public int indexOf(T item) {
    if (isEmpty()) throw new NoSuchElementException("List is empty");

    Node current = head;
    int i = 0;

    while (current != null) {
      if (current.item.equals(item)) return i;
      current = current.next;
      i++;
    }

    return -1;
  }

  public boolean contains(T item) {
    return indexOf(item) != -1;
  }

  public T getFirst() {
    return get(0);
  }

  public T getLast() {
    return get(size - 1);
  }

  public void insert(T item) {
    if (isEmpty()) {
      head = new Node(item);
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new Node(item);
    }

    size++;
  }

  public T remove(int index) {
    if (isEmpty()) throw new NoSuchElementException("List is etmpy");
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    if (index == 0) {
      T item = head.item;
      head = head.next;
      size--;
      return item;
    }

    int i = 0;
    Node current = head;
    while (i < index - 1) {
      current = current.next;
      i++;
    }

    T item = current.next.item;
    current.next = current.next.next;
    size--;
    return item;
  }

  public T removeFirst() {
    return remove(0);
  }

  public T removeLast() {
    return remove(size - 1);
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
    return "LinkedList{" + "size=" + size + ", list=" + list + '}';
  }
}
