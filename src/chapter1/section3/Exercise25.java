package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise25 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) if (i % 2 == 0) list.insert(i);

    StdOut.println(list);

    LinkedList<Integer>.Node node0 = list.new Node(0);
    LinkedList<Integer>.Node node1 = list.new Node(1);
    LinkedList<Integer>.Node node8 = list.new Node(8);
    LinkedList<Integer>.Node node9 = list.new Node(9);

    StdOut.println("\nInserting 1 after 0");
    list.insertAfter(node0, node1);
    StdOut.println(list);

    StdOut.println("\nInserting 9 after 8");
    list.insertAfter(node8, node9);
    StdOut.println(list);
  }
}
