package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

public class Exercise3_PriorityQueue_Unordered_LinkedList<T extends Comparable<T>> {

  public class Node {
    T item;
    Node next;

    public Node(T item) {
      this.item = item;
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

  public void insert(T item) {
    Node oldHead = head;

    Node node = new Node(item);
    node.next = oldHead;

    head = node;
    size++;
  }

  public T delMax() {
    if (isEmpty()) throw new RuntimeException("PQ is empty.");

    T maxValue = head.item;

    Node current = head;
    while (current != null) {
      if (ArrayUtil.more(current.item, maxValue)) maxValue = current.item;
      current = current.next;
    }

    if (head.item.equals(maxValue)) {
      head = head.next;
    } else {
      current = head;
      while (!current.next.item.equals(maxValue)) {
        current = current.next;
      }

      if (current.next.next == null) {
        current.next = null;
      } else {
        current.next = current.next.next;
      }
    }
    size--;

    return maxValue;
  }

  public static void main(String[] args) {
    Exercise3_PriorityQueue_Unordered_LinkedList<Integer> pq =
        new Exercise3_PriorityQueue_Unordered_LinkedList<>();

    pq.insert(2);
    pq.insert(10);
    pq.insert(4);
    pq.insert(1);
    pq.insert(1);

    StdOut.println("Max value: " + pq.delMax() + " - Expected: 10");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 4");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 2");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 1");
    StdOut.println("Max value: " + pq.delMax() + " - Expected: 1");
  }
}
