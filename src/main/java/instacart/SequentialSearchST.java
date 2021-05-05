package instacart;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key, Value> {
  private class Node {
    Key key;
    Value value;
    Node next;

    Node(Key key, Value value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private Node head;
  private int size;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Value get(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    if (isEmpty()) return null;

    for (Node current = head; current != null; current = current.next) {
      if (current.key.equals(key)) return current.value;
    }

    return null;
  }

  public boolean contains(Key key) {
    return get(key) != null;
  }

  public void put(Key key, Value value) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    if (value == null) {
      delete(key);
      return;
    }

    for (Node current = head; current != null; current = current.next) {
      if (current.key.equals(key)) {
        current.value = value;
        return;
      }
    }

    head = new Node(key, value, head);
    size++;
  }

  public void delete(Key key) {
    if (key == null) throw new IllegalArgumentException("Key cannot be null");
    if (isEmpty()) return;

    if (head.key.equals(key)) {
      head = head.next;
      size--;
      return;
    }

    for (Node current = head; current != null; current = current.next) {
      if (current.next != null && current.next.key.equals(key)) {
        current.next = current.next.next;
        size--;
        return;
      }
    }
  }

  public Iterable<Key> keys() {
    Queue<Key> keys = new Queue<>();
    for (Node current = head; current != null; current = current.next) {
      keys.enqueue(current.key);
    }
    return keys;
  }

  public static void main(String[] args) {
    String str = "S E A R C H E X A M P L E";
    String[] a = str.split(" ", 0);

    SequentialSearchST<String, Integer> st = new SequentialSearchST<>();

    for (int i = 0; i < a.length; i++) {
      st.put(a[i], i);
    }

    for (String key : st.keys()) {
      StdOut.println("Key " + key + " - Value: " + st.get(key));
    }

    StdOut.println("Deleting All");
    for (int i = 0; i < a.length; i++) {
      st.delete(a[i]);
    }

    StdOut.println("Printing all");
    for (String key : st.keys()) {
      StdOut.println("Key " + key + " - Value: " + st.get(key));
    }
  }
}
