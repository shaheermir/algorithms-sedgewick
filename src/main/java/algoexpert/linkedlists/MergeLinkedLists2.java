package algoexpert.linkedlists;

import edu.princeton.cs.algs4.StdOut;

public class MergeLinkedLists2 {
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }

    LinkedList(int value, LinkedList next) {
      this.value = value;
      this.next = next;
    }
  }

  // merge p2 into p1, take smaller values from p2 and insert them into p1
  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

    LinkedList p1 = headOne;
    LinkedList p1prev = null;
    LinkedList p2 = headTwo;

    while (p1 != null && p2 != null) {
      if (p1.value < p2.value) {
        p1prev = p1;
        p1 = p1.next;
      } else {
        if (p1prev != null) p1prev.next = p2;
        p1prev = p2;
        p2 = p2.next;
        p1prev.next = p1;
      }
    }

    if (p1 == null) p1prev.next = p2;
    return headOne.value < headTwo.value ? headOne : headTwo;
  }

  public static void main(String[] args) {
    LinkedList one = new LinkedList(2, new LinkedList(6, new LinkedList(7, new LinkedList(8))));
    LinkedList two = new LinkedList(1, new LinkedList(3, new LinkedList(4)));

    LinkedList merged = mergeLinkedLists(one, two);

    while (merged != null) {
      StdOut.print(merged.value + " -> ");
      merged = merged.next;
    }
  }
}
