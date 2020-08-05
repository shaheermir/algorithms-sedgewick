package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise26 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.insert(1);
    list.insert(1);
    list.insert(2);
    list.insert(1);
    list.insert(1);
    list.insert(1);

    StdOut.println(list);

    StdOut.println("\nRemoving all 1s");

    list.removeByKey(1);

    StdOut.println(list);
  }
}
