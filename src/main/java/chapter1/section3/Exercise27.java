package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Exercise27 {
  public static int max(LinkedList<Integer>.Node head) {
    if (head == null) throw new NoSuchElementException("List is empty");

    int max = head.data;
    LinkedList<Integer>.Node current = head;

    while (current != null) {
      if (current.data > max) max = current.data;
      current = current.next;
    }

    return max;
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 5; i++) list.insert(i);

    StdOut.println(list);
    StdOut.println("Max: " + max(list.getHeadNode()));
  }
}
