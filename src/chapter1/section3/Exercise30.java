package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise30 {
  private static class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(0);
    for (int i = 1; i < 10; i++) insert(head, i);
    print(head);

    Node reversed = reverse(head);
    print(reversed);
  }

  public static Node reverse(Node head) {
    Node reverse = null;
    Node first = head;

    while (first != null) {
      Node second = first.next;
      first.next = reverse;
      reverse = first;
      first = second;
    }

    return reverse;
  }

  public static void insert(Node head, int value) {
    Node current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new Node(value);
  }

  public static void print(Node head) {
    StringBuilder sb = new StringBuilder();

    Node current = head;
    while (current != null) {
      sb.append(current.value);
      sb.append(",");
      current = current.next;
    }
    StdOut.println(sb);
  }
}
