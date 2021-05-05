package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import util.ArrayUtil;

public class Exercise3_PriorityQueue_Ordered_LinkedList<T extends Comparable<T>> {

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

  // aka sortedInsert (desc) -- we maintain descending order on every insert
  public void insert(T item) {
    Node node = new Node(item);
    if (head == null || item.compareTo(head.item) >= 0) {
      node.next = head;
      head = node;
      size++;
      return;
    }

    /* Locate the node before point of insertion. */
    Node current = head;
    while (current.next != null && ArrayUtil.less(item, current.next.item)) {
      current = current.next;
    }

    node.next = current.next;
    current.next = node;
    size++;
  }

  public T delMax() {
    if (isEmpty()) throw new RuntimeException("PQ is empty");

    T maxValue = head.item;
    head = head.next;
    size--;
    return maxValue;
  }

  public static void main(String[] args) {
    Exercise3_PriorityQueue_Ordered_LinkedList<Integer> pq =
        new Exercise3_PriorityQueue_Ordered_LinkedList<>();

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
