package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 5; i++) list.insert(i);

    System.out.println("Before Any Deletes");
    StdOut.println(list);

    System.out.println("\nRemoved Value At Index 2: " + list.remove(2));
    StdOut.println(list);
  }
}
