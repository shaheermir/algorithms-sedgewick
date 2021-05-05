package chapter1.section3;

import java.util.NoSuchElementException;

public class Exercise29<T> {
  public class Node {
    T data;
    Node next;

    public Node(T data) {
      this.data = data;
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

  public void insert(T data) {
    Node node = new Node(data);

    if (isEmpty()) {
      last = node;
      node.next = last;
      return;
    }

    node.next = last.next;
    last.next = node;
    last = node;
    size++;
  }

  public T dequeue() {
    if (isEmpty()) throw new NoSuchElementException();

    T data;
    if (size == 1) {
      data = last.data;
      last = null;
    } else {
      data = last.next.data;
      last.next = last.next.next;
    }

    size--;
    return data;
  }
}
