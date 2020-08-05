package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Exercise27 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) list.insert(i);

    StdOut.println(list);
    StdOut.println("Searching for max: " + max(list.getHeadNode()));
  }

  public static int max(LinkedList<Integer>.Node head) {
    if (head == null) throw new NoSuchElementException("List is empty");

    int max = head.item;
    LinkedList<Integer>.Node current = head;

    while (current != null) {
      if (current.item > max) {
        max = current.item;
      }
      current = current.next;
    }

    return max;
  }
}
