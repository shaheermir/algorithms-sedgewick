package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Exercise28 {
  public static int max(LinkedList<Integer>.Node head) {
    if (head == null) throw new NoSuchElementException("List is empty");

    return recursiveMax(head, head.data);
  }

  public static int recursiveMax(LinkedList<Integer>.Node node, int currentMax) {
    if (node == null) return currentMax;

    if (node.data > currentMax) currentMax = node.data;

    return recursiveMax(node.next, currentMax);
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 5; i++) list.insert(i);

    StdOut.println(list);
    StdOut.println("Max: " + max(list.getHeadNode()));
  }
}
