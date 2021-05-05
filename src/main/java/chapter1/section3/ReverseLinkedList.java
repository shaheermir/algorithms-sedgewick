package chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseLinkedList<T> implements Iterable<T> {

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

  public Node reverse(Node head) {
    Node first = head;
    Node reverse = null;

    while (first != null) {
      Node second = first.next;
      first.next = reverse;

      reverse = first;
      first = second;
    }

    return reverse;
  }

  public Node recursiveReverse(Node first) {
    if (head == null || head.next == null) return head;
    Node second = first.next;
    Node rest = recursiveReverse(second);
    second.next = first;
    first.next = null;
    return rest;
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
