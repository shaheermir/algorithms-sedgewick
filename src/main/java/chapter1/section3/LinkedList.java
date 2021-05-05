package chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

  public class Node {
    T data;
    Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  private int size;
  private Node head;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Node getHeadNode() {
    if (isEmpty()) throw new NoSuchElementException("List is empty");
    return head;
  }

  public T get(int index) {
    if (isEmpty()) throw new NoSuchElementException("List is empty");
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");

    int i = 0;
    Node current = head;
    while (i < index) {
      i++;
      current = current.next;
    }

    return current.data;
  }

  public T getFirst() {
    return get(0);
  }

  public int indexOf(T key) {
    int i = 0;
    Node current = head;

    while (current != null) {
      if (current.data.equals(key)) return i;
      current = current.next;
      i++;
    }

    return -1;
  }

  public boolean contains(T item) {
    return indexOf(item) != -1;
  }

  public T getLast() {
    return get(size - 1);
  }

  public void insert(T data) {
    if (isEmpty()) {
      head = new Node(data);
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new Node(data);
      ;
    }
    size++;
  }

  public T remove(int index) {
    if (isEmpty()) throw new NoSuchElementException("List is empty");

    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");

    if (index == 0) {
      T data = head.data;
      head = head.next;
      size--;
      return data;
    }

    int i = 0;
    Node current = head;

    while (i < index - 1) {
      current = current.next;
      i++;
    }

    T data = current.next.data;
    current.next = current.next.next;
    size--;
    return data;
  }

  public T removeFirst() {
    return remove(0);
  }

  public T removeLast() {
    return remove(size - 1);
  }

  public void removeByKey(T key) {
    if (isEmpty() || key == null) return;

    Node current = head;
    while (current != null) {
      Node next = current.next;

      while (next != null && next.data.equals(key)) {
        next = next.next;
        size--;
      }
      current.next = next;
      current = current.next;
    }

    if (head.data.equals(key)) {
      head = head.next;
      size--;
    }
  }

  public void removeAfter(Node node) {
    if (isEmpty() || node == null) return;

    Node current = head;
    while (current != null) {
      if (current.data.equals(node.data)) {
        if (current.next != null) current.next = current.next.next;
        size--;
      }
      return;
    }
  }

  public void insertAfter(Node first, Node second) {
    if (isEmpty() || first == null || second == null) return;

    Node current = head;
    while (current != null) {
      if (current.data.equals(first.data)) {
        second.next = first.next;
        first.next = second;
        size++;
        return;
      }
      current = current.next;
    }
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
    for (T item : this) {
      if (i == 0) list = list + item;
      else list = list + ", " + item;
      i++;
    }

    return "LinkedList{" + "size=" + size + ", list=" + list + '}';
  }
}
