package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
  public class Node {
    public T item;
    public Node prev;
    public Node next;

    public Node(T item, Node prev, Node next) {
      this.item = item;
      this.prev = prev;
      this.next = next;
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

  public void insertAtStart(T item) {
    if (isEmpty()) {
      head = tail = new Node(item, null, null);
      size++;
      return;
    }

    head.prev = new Node(item, null, head);
    head = head.prev;
    size++;
  }

  public void insert(T item) {
    insertAtEnd(item);
  }

  public void insertAtEnd(T item) {
    if (isEmpty()) {
      head = tail = new Node(item, null, null);
      size++;
      return;
    }

    tail.next = new Node(item, tail, null);
    tail = tail.next;
    size++;
  }

  public T removeFromStart() {
    if (isEmpty()) throw new NoSuchElementException("List is empty");

    T item = head.item;
    head = head.next;
    size--;

    if (isEmpty()) tail = null;
    else head.prev = null;

    return item;
  }

  public T removeFromEnd() {
    if (isEmpty()) throw new NoSuchElementException("List is empty");

    T item = tail.item;
    tail = tail.prev;
    size--;

    if (isEmpty()) head = null;
    else tail.next = null;

    return item;
  }

  public T remove(Node node) {
    if (isEmpty()) throw new NoSuchElementException("List is empty");

    if (node == head) return removeFromStart();
    if (node == tail) return removeFromEnd();

    Node current = head;
    while (current != null) {
      if (current.next == node) {
        T item = node.item;
        current.next = node.next;
        node.next.prev = current;
        size--;
        return item;
      }
      current = current.next;
    }

    return null;
  }

  public T removeAt(int index) {
    if (isEmpty() || index < 0 || index >= size) {
      throw new NoSuchElementException("List empty or index out of bounds");
    }

    if (index == 0) return removeFromStart();
    if (index == size - 1) return removeFromEnd();

    int i;
    Node current;

    if (index < size / 2) {
      for (i = 0, current = head; i != index; i++) {
        current = current.next;
      }
    } else {
      for (i = size - 1, current = tail; i != index; i--) {
        current = current.prev;
      }
    }

    return remove(current);
  }

  public int indexOf(T item) {
    if (isEmpty()) return -1;

    int index = 0;
    Node current = head;
    while (current != null) {
      if (current.item.equals(item)) return index;
      index++;
      current = current.next;
    }
    return -1;
  }

  public boolean contains(T item) {
    return indexOf(item) != -1;
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
    return "DoublyLinkedList{" + "size=" + size + ", DLL=" + list + '}';
  }

  public static void main(String[] args) {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    for (int i = 0; i < 10; i++) list.insert(i);

    StdOut.println(list);

    StdOut.println("\nRemoving From Start: " + list.removeFromStart());
    StdOut.println(list);

    StdOut.println("\nRemoving From End: " + list.removeFromEnd());
    StdOut.println(list);

    StdOut.println("\nInserting At Start: 99");
    list.insertAtStart(99);
    StdOut.println(list);

    StdOut.println("\nRemoving At Index 0: " + list.removeAt(0));
    StdOut.println(list);

    StdOut.println("\nRemoving At Index 7 (last elem): " + list.removeAt(7));
    StdOut.println(list);

    StdOut.println("\nRemoving At Index 4: " + list.removeAt(4));
    StdOut.println(list);

    StdOut.println("\nContains 4: " + list.contains(4));
    StdOut.println("Index Of 4: " + list.indexOf(4));

    StdOut.println("\nContains 77: " + list.contains(77));
    StdOut.println("Index Of 77: " + list.indexOf(77));
  }
}
