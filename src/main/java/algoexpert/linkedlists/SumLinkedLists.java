package algoexpert.linkedlists;

import edu.princeton.cs.algs4.StdOut;

class SumLinkedLists {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }

    public LinkedList(int value, LinkedList next) {
      this.value = value;
      this.next = next;
    }
  }

  public static LinkedList sumOfLinkedLists(LinkedList one, LinkedList two) {
    int carry = 0;
    LinkedList head = null;
    LinkedList current = null;

    boolean carryExists = false;

    while (one != null || two != null) {
      int oneVal = one != null ? one.value : 0;
      int twoVal = two != null ? two.value : 0;
      int val = oneVal + twoVal + carry;

      if (val >= 10) {
        val = val - 10;
        carry = 1;
        carryExists = true;
      } else {
        carry = 0;
        carryExists = false;
      }

      if (head == null) {
        head = new LinkedList(val);
        current = head;
      } else {
        current.next = new LinkedList(val);
        current = current.next;
      }

      if (one != null) one = one.next;
      if (two != null) two = two.next;
    }

    if (carryExists) current.next = new LinkedList(carry);

    return head;
  }

  public static void main(String[] args) {
    LinkedList one = new LinkedList(1, new LinkedList(1, new LinkedList(1)));
    LinkedList two = new LinkedList(9, new LinkedList(9, new LinkedList(9)));

    LinkedList sum = sumOfLinkedLists(one, two);

    while (sum != null) {
      StdOut.print(sum.value + " -> ");
      sum = sum.next;
    }
  }
}
