package algoexpert.bst;

import edu.princeton.cs.algs4.StdOut;

public class ValidateBST {

  public static boolean validateBst(BST root) {
    return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  // Some ppl say its okay to have equivalent keys in the right tree.
  private static boolean validateBST(BST node, int min, int max) {
    if (node == null) return true;

    if (node.value < min) return false;
    if (node.value >= max) return false;

    return validateBST(node.left, min, node.value) && validateBST(node.right, node.value, max);
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

    StdOut.println(validateBst(root));
  }
}
