package algoexpert.bst;

import edu.princeton.cs.algs4.StdOut;

public class ClosestValueInBST {
  // Average: O(log(n)) time |  O(1) space
  // Worst: O(n) time |  O(1) space
  public static int findClosestValueInBst(BST root, int target) {
    int closestValue = Integer.MAX_VALUE;
    int smallestDifference = Integer.MAX_VALUE;

    BST current = root;

    while (current != null) {
      int difference = Math.abs(current.value - target);
      if (difference < smallestDifference) {
        smallestDifference = difference;
        closestValue = current.value;
      }

      if (target < current.value) current = current.left;
      else if (target > current.value) current = current.right;
      else break;
    }
    return closestValue;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    BST root = new BST(10);
    root.left = new BST(5);
    root.left.left = new BST(2);
    root.left.left.left = new BST(1);
    root.left.right = new BST(5);
    root.right = new BST(15);
    root.right.left = new BST(13);
    root.right.left.right = new BST(14);
    root.right.right = new BST(22);
    StdOut.println(findClosestValueInBst(root, 12)); // expected 13
  }
}
