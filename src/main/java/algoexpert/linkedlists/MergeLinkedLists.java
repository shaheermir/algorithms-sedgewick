package algoexpert.linkedlists;

import edu.princeton.cs.algs4.StdOut;

public class MergeLinkedLists {
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

  public static LinkedList mergeLinkedLists(LinkedList one, LinkedList two) {
    LinkedList head = null;

    while (one != null && two != null) {
      //      StdOut.println(one.value + " - " + two.value);
      if (one.value < two.value) {
        if (head == null) head = one;

        if (one.next != null && one.next.value <= two.value) {
          one = one.next;
          continue;
        }

        LinkedList temp = one.next;
        one.next = two;
        one = temp;
      } else {
        if (head == null) head = two;

        if (two.next != null && two.next.value <= one.value) {
          two = two.next;
          continue;
        }

        LinkedList temp = two.next;
        two.next = one;
        two = temp;
      }
    }

    //    StdOut.println(one.value);
    //    StdOut.println(two.value);

    return head;
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
