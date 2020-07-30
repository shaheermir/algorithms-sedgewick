package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise21 {
  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    for (int i = 1; i < 6; i++) {
      list.insert(String.valueOf((char) (i + 64)).toLowerCase());
    }
    list.insert("Shaheer");

    StdOut.println(list);
    StdOut.println();

    System.out.println("List Contains \"a\": " + list.contains("a"));
    System.out.println("List Contains \"b\": " + list.contains("b"));
    System.out.println("List Contains \"x\": " + list.contains("x"));
    System.out.println("List Contains \"Shaheer\": " + list.contains("Shaheer"));
  }
}
