package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Exercise28 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) list.insert(i);

    StdOut.println(list);
    StdOut.println("Searching for max: " + recursiveMax(list.getHeadNode()));
  }

  public static int recursiveMax(LinkedList<Integer>.Node head) {
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }
    return getMax(head.next, head.item);
  }

  private static int getMax(LinkedList<Integer>.Node current, int currentMax) {
    // reached end of list
    if (current == null) return currentMax;

    if (current.item > currentMax) {
      currentMax = current.item;
    }

    return getMax(current.next, currentMax);
  }
}
