package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 5; i++) list.insert(i);

    System.out.println("Before Removing Tail");
    StdOut.println(list);

    System.out.println("\nRemoved Tail Value: " + list.removeLast());
    StdOut.println(list);
  }
}
