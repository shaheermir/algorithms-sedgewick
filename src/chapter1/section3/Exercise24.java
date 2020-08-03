package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise24 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 5; i++) list.insert(i);

    // idk how to use static inner classes yet, so stuck with this funny syntax for now.
    LinkedList<Integer>.Node node0 = list.new Node(0);
    LinkedList<Integer>.Node node4 = list.new Node(4);
    LinkedList<Integer>.Node node6 = list.new Node(6);

    StdOut.println(list);

    StdOut.println("\nRemoving After 0");
    list.removeAfter(node0);
    StdOut.println(list);

    StdOut.println("\nRemoving After 4");
    list.removeAfter(node4);
    StdOut.println(list);

    StdOut.println("\nRemoving After 6");
    list.removeAfter(node6);
    StdOut.println(list);
  }
}
